package com.huygur.flightapi.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public record FlightDTO(String departureAirport,
                        String arrivalAirport,
                        @DateTimeFormat(pattern = "YYYY-MM-DD")
                        Date departureTime,
                        @DateTimeFormat(pattern = "YYYY-MM-DD")
                        Date arrivalTime)
        implements Serializable {

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }
}