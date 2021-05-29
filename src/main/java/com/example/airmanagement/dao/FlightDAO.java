package com.example.airmanagement.dao;

import com.example.airmanagement.models.AirCompany;
import com.example.airmanagement.models.Flight;
import com.example.airmanagement.models.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface FlightDAO extends JpaRepository<Flight, Integer> {

    @Query("SELECT f FROM Flight f WHERE f.airCompanyId = :airCompany and f.flightStatus = :status")
    List<Flight> searchFlightsByStatus(@Param("airCompany") AirCompany airCompany,
                                       @Param("status") FlightStatus status);

    @Query(value = "SELECT * FROM Flight f WHERE f.flight_status = 'ACTIVE' and TIMESTAMPDIFF(minute , f.started_at, current_time) > 1440", nativeQuery = true)
    List<Flight> searchActiveFlights24();

    @Query(value = "SELECT * FROM Flight f WHERE f.flight_status = 'COMPLETED' and TIMESTAMPDIFF(second , f.started_at, f.ended_at) > TIME_TO_SEC (f.est_flight_time);", nativeQuery = true)
    List<Flight> searchCompletedFlightsWithDelay();
}
