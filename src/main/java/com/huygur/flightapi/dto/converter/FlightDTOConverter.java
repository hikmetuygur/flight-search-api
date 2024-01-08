package com.huygur.flightapi.dto.converter;

import com.huygur.flightapi.dto.FlightDTO;
import com.huygur.flightapi.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightDTOConverter {

    public static FlightDTO convertToFlightDto(Flight flight) {
        return new FlightDTO(
                flight.getDepartureAirport(),
                flight.getArrivalAirport(),
                flight.getDepartureTime(),
                flight.getArrivalTime()
        );
    }

    public static Flight convertToFlight(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setDepartureAirport(flightDTO.getDepartureAirport());
        flight.setArrivalAirport(flightDTO.getArrivalAirport());
        flight.setDepartureTime(flightDTO.getDepartureTime());
        flight.setArrivalTime(flightDTO.getArrivalTime());

        return flight;
    }

    public static List<FlightDTO> convertToFlightDtoList(List<Flight> flights) {
        return flights.stream()
                .map(FlightDTOConverter::convertToFlightDto)
                .collect(Collectors.toList());
    }

    public static List<Flight> convertToFlightList(List<FlightDTO> flightDtos) {
        return flightDtos.stream()
                .map(FlightDTOConverter::convertToFlight)
                .collect(Collectors.toList());
    }

}