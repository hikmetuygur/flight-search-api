package com.huygur.flightapi.repository;

import com.huygur.flightapi.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByDepartureAirport(String departureAirport);

    List<Flight> findAllByDepartureAirportAndArrivalAirportAndDepartureTimeAndArrivalTime(String departureAirport, String arrivalAirport, Date departureTime, Date arrivalTime);

    List<Flight> findAllByDepartureAirportAndArrivalAirportAndDepartureTime(String departureAirport, String arrivalAirport, Date departureTime);
}
