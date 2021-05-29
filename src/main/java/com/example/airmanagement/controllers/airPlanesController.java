package com.example.airmanagement.controllers;

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
    public String addNewAirplane(@RequestBody Airplane airplane){
        airplane.setCreatedAt(LocalDate.now());
        airPlaneDAO.save(airplane);
        return "Successfully added new airplane";
    }

    @PostMapping("/addwithcompany")
    public String addNewAirplaneWithCompany(@RequestParam String name,
                                            @RequestParam long serialNumber,
                                            @RequestParam int flightsNumber,
                                            @RequestParam int flightDistance,
                                            @RequestParam int fuelCapacity,
                                            @RequestParam String type,
                                            @RequestParam int airCompanyid){
        if (airCompanyDAO.findById(airCompanyid).isPresent()) {
            Airplane airplane = new Airplane(name, serialNumber, flightsNumber, flightDistance, fuelCapacity, type);
            airplane.setAirCompanyId(airCompanyDAO.findById(airCompanyid).get());
            airplane.setCreatedAt(LocalDate.now());
            airPlaneDAO.save(airplane);
            return "Successfully added new airplane";
        }
        return "Something went wrong";
    }

    @PatchMapping("/{id}")
    public String moveAirplaneToAnotherCompany(@PathVariable int id, @RequestParam int newCompanyId){
        if (airPlaneDAO.findById(id).isPresent() && airCompanyDAO.findById(newCompanyId).isPresent()) {
            Airplane airplane = airPlaneDAO.findById(id).get();
            AirCompany airCompany = airCompanyDAO.findById(newCompanyId).get();
            airplane.setAirCompanyId(airCompany);
            airPlaneDAO.save(airplane);
            return "Updated company for airplane sucessfully";
        }
        return "Something went wrong, please try again";
    }
}
