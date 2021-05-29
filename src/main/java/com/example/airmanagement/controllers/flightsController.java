package com.example.airmanagement.controllers;

import com.example.airmanagement.constants.StatusConstants;
import com.example.airmanagement.dao.AirCompanyDAO;
import com.example.airmanagement.dao.AirPlaneDAO;
import com.example.airmanagement.dao.FlightDAO;
import com.example.airmanagement.models.AirCompany;
import com.example.airmanagement.models.Airplane;
import com.example.airmanagement.models.Flight;
import com.example.airmanagement.models.FlightStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class flightsController {
    FlightDAO flightDAO;
    AirCompanyDAO airCompanyDAO;
    AirPlaneDAO airPlaneDAO;

    public flightsController(FlightDAO flightDAO, AirCompanyDAO airCompanyDAO, AirPlaneDAO airPlaneDAO) {
        this.flightDAO = flightDAO;
        this.airCompanyDAO = airCompanyDAO;
        this.airPlaneDAO = airPlaneDAO;
    }

    @PostMapping()
    private String createNewFlight(@RequestParam int airCompanyId,
                                   @RequestParam int airplaneId,
                                   @RequestParam String departureCountry,
                                   @RequestParam String destinationCountry,
                                   @RequestParam int distance,
                                   @RequestParam Time estFlightTime) {
        if (airCompanyDAO.findById(airCompanyId).isPresent() && airPlaneDAO.findById(airplaneId).isPresent()) {
            AirCompany airCompany = airCompanyDAO.findById(airCompanyId).get();
            Airplane airplane = airPlaneDAO.findById(airplaneId).get();
            Flight flight = new Flight(airCompany, airplane, departureCountry, destinationCountry, distance, estFlightTime);
            flight.setCreatedAt(LocalDateTime.now());
            flight.setFlightStatus(FlightStatus.PENDING);
            flightDAO.save(flight);
            return StatusConstants.SUCCESSFULLY_ADDED_FLIGHT;
        }
        return StatusConstants.UNSUCCESS;
    }

    @GetMapping("/active")
    public List<Flight> getActiveFlightsStartedMoreThan24Ago() {
        return flightDAO.searchActiveFlights24();
    }

    @PatchMapping("/{id}")
    public String setNewStatus(@PathVariable int id,
                               @RequestParam String status) {
        boolean b = Arrays.stream(FlightStatus.values()).anyMatch((t) -> t.name().equals(status.toUpperCase()));
        if (flightDAO.findById(id).isPresent() && b) {
            Flight flight = flightDAO.findById(id).get();
            FlightStatus flightStatus = FlightStatus.valueOf(status.toUpperCase());
            Flight withSwitchStatus = switchStatus(flight, flightStatus);
            flightDAO.save(withSwitchStatus);
            return StatusConstants.SUCCESSFULLY_UPDATED_FLIGHTS_STATUS;
        }
        return StatusConstants.UNSUCCESS;
    }

    private Flight switchStatus(Flight flight, FlightStatus flightStatus) {
        switch (flightStatus) {
            case DELAYED:
                flight.setDelayStartedAt(LocalDateTime.now());
                flight.setFlightStatus(FlightStatus.DELAYED);
                break;
            case ACTIVE:
                flight.setStartedAt(LocalDateTime.now());
                flight.setFlightStatus(FlightStatus.ACTIVE);
                break;
            case COMPLETED:
                flight.setEndedAt(LocalDateTime.now());
                flight.setFlightStatus(FlightStatus.COMPLETED);
                break;
        }
        return flight;
    }

    @GetMapping("/completedwithdelay")
    public List<Flight> getCompletedFlightsWithDelay() {
        return flightDAO.searchCompletedFlightsWithDelay();
    }
}
