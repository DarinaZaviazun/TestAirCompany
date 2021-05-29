package com.example.airmanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private AirCompany airCompanyId;
    @OneToOne
//    @JoinColumn(name = "airplane_id", referencedColumnName = "id")
    @JsonIgnore
    private Airplane airplaneId;
    private String departureCountry;
    private String destinationCountry;
    private int distance;
    private Time estFlightTime;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private LocalDateTime delayStartedAt;
    private LocalDateTime createdAt;

    public Flight() {
    }

    public Flight(AirCompany airCompanyId,
                  Airplane airplaneId,
                  String departureCountry,
                  String destinationCountry,
                  int distance,
                  Time estFlightTime) {
        this.airCompanyId = airCompanyId;
        this.airplaneId = airplaneId;
        this.departureCountry = departureCountry;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
        this.estFlightTime = estFlightTime;
        this.createdAt = LocalDateTime.now();
        this.flightStatus = FlightStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public AirCompany getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(AirCompany airCompanyId) {
        this.airCompanyId = airCompanyId;
    }

    public Airplane getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Airplane airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Time getEstFlightTime() {
        return estFlightTime;
    }

    public void setEstFlightTime(Time estFlightTime) {
        this.estFlightTime = estFlightTime;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public LocalDateTime getDelayStartedAt() {
        return delayStartedAt;
    }

    public void setDelayStartedAt(LocalDateTime delayStartedAt) {
        this.delayStartedAt = delayStartedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightStatus=" + flightStatus +
                ", airCompanyId=" + airCompanyId.getId() +
                ", airplaneId=" + airplaneId.getId() +
                ", departureCountry='" + departureCountry + '\'' +
                ", destinationCountry='" + destinationCountry + '\'' +
                ", distance=" + distance +
                ", estFlightTime=" + estFlightTime +
                ", endedAt=" + endedAt +
                ", delayStartedAt=" + delayStartedAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
