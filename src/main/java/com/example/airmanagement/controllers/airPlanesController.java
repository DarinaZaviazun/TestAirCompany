package com.example.airmanagement.controllers;

import com.example.airmanagement.util.StatusConstants;
import com.example.airmanagement.dao.AirCompanyDAO;
import com.example.airmanagement.dao.AirPlaneDAO;
import com.example.airmanagement.models.AirCompany;
import com.example.airmanagement.models.Airplane;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/airplanes")
public class airPlanesController {
    AirPlaneDAO airPlaneDAO;
    AirCompanyDAO airCompanyDAO;

    public airPlanesController(AirPlaneDAO airPlaneDAO, AirCompanyDAO airCompanyDAO) {
        this.airPlaneDAO = airPlaneDAO;
        this.airCompanyDAO = airCompanyDAO;
    }

    @PostMapping("/add")
    public String addNewAirplane(@RequestParam String name,
                                 @RequestParam long serialNumber,
                                 @RequestParam int flightsNumber,
                                 @RequestParam int flightDistance,
                                 @RequestParam int fuelCapacity,
                                 @RequestParam String type,
                                 @RequestParam(required = false) Integer airCompanyId) {
        Airplane airplane = new Airplane(name, serialNumber, flightsNumber, flightDistance, fuelCapacity, type);
        airplane.setCreatedAt(LocalDate.now());
        if (airCompanyId != null && airCompanyDAO.findById(airCompanyId).isPresent()) {
            airplane.setAirCompany(airCompanyDAO.findById(airCompanyId).get());
        }
        airPlaneDAO.save(airplane);
        return StatusConstants.SUCCESSFULLY_ADDED_AIRPLANE;
    }

    @PatchMapping("/{id}")
    public String moveAirplaneToAnotherCompany(@PathVariable int id, @RequestParam int newCompanyId) {
        if (airPlaneDAO.findById(id).isPresent() && airCompanyDAO.findById(newCompanyId).isPresent()) {
            Airplane airplane = airPlaneDAO.findById(id).get();
            AirCompany airCompany = airCompanyDAO.findById(newCompanyId).get();
            airplane.setAirCompany(airCompany);
            airPlaneDAO.save(airplane);
            return StatusConstants.SUCCESSFULLY_UPDATED_AIRPLANES_COMPANY;
        }
        return StatusConstants.UNSUCCESS;
    }
}
