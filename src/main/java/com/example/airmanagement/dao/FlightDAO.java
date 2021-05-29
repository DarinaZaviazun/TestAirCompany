package com.example.airmanagement.dao;

import com.example.airmanagement.util.QueryConstants;
import com.example.airmanagement.models.AirCompany;
import com.example.airmanagement.models.Flight;
import com.example.airmanagement.util.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface FlightDAO extends JpaRepository<Flight, Integer> {

    @Query(QueryConstants.FLIGHTS_OF_AIRCOMPANY_BY_STATUS)
    List<Flight> searchFlightsByStatus(@Param("airCompany") AirCompany airCompany,
                                       @Param("status") FlightStatus status);

    @Query(value = QueryConstants.ACTIVE_FLIGHTS_STARTED_MORE_THAN_24_HOURS_AGO, nativeQuery = true)
    List<Flight> searchActiveFlights24();

    @Query(value = QueryConstants.COMPLETED_FLIGHTS_WITH_DELAY, nativeQuery = true)
    List<Flight> searchCompletedFlightsWithDelay();
}
