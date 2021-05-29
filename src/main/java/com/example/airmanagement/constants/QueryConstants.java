package com.example.airmanagement.constants;

public class QueryConstants {

    private QueryConstants() {
    }

    public static final String FLIGHTS_OF_AIRCOMPANY_BY_STATUS = "SELECT f FROM Flight f WHERE f.airCompany = :airCompany and f.flightStatus = :status";
    public static final String ACTIVE_FLIGHTS_STARTED_MORE_THAN_24_HOURS_AGO = "SELECT * FROM Flight f" +
            " WHERE f.flight_status = 'ACTIVE' and TIMESTAMPDIFF(minute , f.started_at, current_time) > 1440;";
    public static final String COMPLETED_FLIGHTS_WITH_DELAY = "SELECT * FROM Flight f WHERE " +
            "f.flight_status = 'COMPLETED' and TIMESTAMPDIFF(second , f.started_at, f.ended_at) > " +
            "TIME_TO_SEC (f.est_flight_time);";
}
