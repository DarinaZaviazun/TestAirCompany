package com.example.airmanagement.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long serialNumber;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "airCompany_id", referencedColumnName = "id")
    private AirCompany airCompany;
    private int flightsNumber;
    private long flightDistance;
    private int fuelCapacity;
    private String type;
    private LocalDate createdAt;

    public Airplane() {
    }

    public Airplane(String name,
                    long serialNumber,
                    AirCompany airCompany,
                    int flightsNumber,
                    long flightDistance,
                    int fuelCapacity,
                    String type) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.airCompany = airCompany;
        this.flightsNumber = flightsNumber;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
        this.createdAt = LocalDate.now();
    }

    public Airplane(String name,
                    long serialNumber,
                    int flightsNumber,
                    long flightDistance,
                    int fuelCapacity,
                    String type) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.flightsNumber = flightsNumber;
        this.flightDistance = flightDistance;
        this.fuelCapacity = fuelCapacity;
        this.type = type;
        this.createdAt = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public AirCompany getAirCompany() {
        return airCompany;
    }

    public void setAirCompany(AirCompany airCompany) {
        this.airCompany = airCompany;
    }

    public int getFlightsNumber() {
        return flightsNumber;
    }

    public void setFlightsNumber(int flightsNumber) {
        this.flightsNumber = flightsNumber;
    }

    public long getFlightDistance() {
        return flightDistance;
    }

    public void setFlightDistance(long flightDistance) {
        this.flightDistance = flightDistance;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serialNumber=" + serialNumber +
                ", airCompanyId=" + airCompany.getId() +
                ", flightsNumber=" + flightsNumber +
                ", flightDistance=" + flightDistance +
                ", fuelCapacity=" + fuelCapacity +
                ", type='" + type + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
