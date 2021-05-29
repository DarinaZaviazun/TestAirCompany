package com.example.airmanagement.controllers;

import com.example.airmanagement.constants.StatusConstants;
import com.example.airmanagement.dao.AirCompanyDAO;
import com.example.airmanagement.dao.FlightDAO;
import com.example.airmanagement.models.AirCompany;
import com.example.airmanagement.models.Flight;
import com.example.airmanagement.models.FlightStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/aircompanies")
public class airCompaniesController {
    AirCompanyDAO airCompanyDAO;
    FlightDAO flightDAO;

    public airCompaniesController(AirCompanyDAO airCompanyDAO, FlightDAO flightDAO) {
        this.airCompanyDAO = airCompanyDAO;
        this.flightDAO = flightDAO;
    }

    @GetMapping
    public List<AirCompany> getAirCompanies() {
        return airCompanyDAO.findAll();
    }

    @GetMapping("/{id}")
    public AirCompany getAirCompanyById(@PathVariable int id) {
        AirCompany one = null;
        if (airCompanyDAO.findById(id).isPresent()) {
            one = airCompanyDAO.findById(id).get();
        }
        return one;
    }

    @PostMapping
    public String addNewAirCompany(@RequestBody AirCompany airCompany) {
        airCompanyDAO.save(airCompany);
        return StatusConstants.SUCCESSFULLY_ADDED_AIRCOMPANY;
    }

    @DeleteMapping("/{id}")
    public String deleteAirCompany(@PathVariable int id) {
        if (airCompanyDAO.findById(id).isPresent()) {
            airCompanyDAO.deleteById(id);
            return StatusConstants.SUCCESSFULLY_DELETED_AIRCOMPANY;
        }
        return StatusConstants.UNSUCCESSFUL_DELETED_AIRCOMPANY + id;
    }

    @PatchMapping("/{id}")
    public String updateAirCompany(@PathVariable int id,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) String companyType,
                                   @RequestParam(required = false) String foundedAt) {
        if (airCompanyDAO.findById(id).isPresent()) {
            AirCompany forUpdate = airCompanyDAO.findById(id).get();
            boolean updated = false;
            if (name != null && !name.equals(forUpdate.getName())) {
                forUpdate.setName(name);
                updated = true;
            }
            if (companyType != null && !companyType.equals(forUpdate.getCompanyType())) {
                forUpdate.setCompanyType(companyType);
                updated = true;
            }
            if (foundedAt != null && !LocalDate.parse(foundedAt).equals(forUpdate.getFoundedAt())) {
                forUpdate.setFoundedAt(LocalDate.parse(foundedAt));
                updated = true;
            }
            if (updated) {
                airCompanyDAO.save(forUpdate);
                return StatusConstants.SUCCESSFULLY_UPDATED_AIRCOMPANY;
            } else return StatusConstants.UNSUCCESSFUL_UPDATED_AIRCOMPANY;
        }
        return StatusConstants.UNSUCCESS;
    }

    @GetMapping("/{name}/{status}")
    public List<Flight> getFlightsByStatus(@PathVariable String name,
                                           @PathVariable String status) {
        List<Flight> flights = null;
        boolean b = Arrays.stream(FlightStatus.values()).anyMatch((t) -> t.name().equals(status.toUpperCase()));
        if (b && airCompanyDAO.findByName(name) != null) {
            AirCompany airCompany = airCompanyDAO.findByName(name);
            flights = flightDAO.searchFlightsByStatus(airCompany, FlightStatus.valueOf(status.toUpperCase()));
        }
        return flights;
    }
}
