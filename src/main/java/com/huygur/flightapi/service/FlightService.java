package com.huygur.flightapi.service;

import com.huygur.flightapi.controller.request.SearchRequest;
import com.huygur.flightapi.dto.FlightDTO;
import com.huygur.flightapi.dto.converter.FlightDTOConverter;
import com.huygur.flightapi.model.Flight;
import com.huygur.flightapi.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDTO> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights
                .stream()
                .map(FlightDTOConverter::convertToFlightDto)
                .collect(Collectors.toList());
    }

    public List<FlightDTO> getAllFlightsByDepartureAirport(String departureAirport) {
        List<Flight> flights = flightRepository.findAllByDepartureAirport(departureAirport);
        return flights
                .stream()
                .map(FlightDTOConverter::convertToFlightDto)
                .collect(Collectors.toList());
    }

    public FlightDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id).orElseThrow();
        return FlightDTOConverter.convertToFlightDto(flight);
    }


    public FlightDTO createFlight(FlightDTO flightDto) {
        Flight flight = FlightDTOConverter.convertToFlight(flightDto);
        Flight savedFlight = flightRepository.save(flight);
        return FlightDTOConverter.convertToFlightDto(savedFlight);
    }

    public FlightDTO updateFlight(Long id, FlightDTO flightDto) {
        Flight flight = FlightDTOConverter.convertToFlight(flightDto);
        flight.setId(id);
        Flight savedFlight = flightRepository.save(flight);
        return FlightDTOConverter.convertToFlightDto(savedFlight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }


    public List<FlightDTO> searchFlights(SearchRequest request) {
        List<Flight> flights;
        if (!request.getDepartureAirport().isEmpty()) {
            flights = flightRepository
                    .findAllByDepartureAirportAndArrivalAirportAndDepartureTimeAndArrivalTime(
                            request.getDepartureAirport(),
                            request.getArrivalAirport(),
                            request.getDepartureDate(),
                            request.getArrivalDate());
        } else {
            flights = flightRepository
                    .findAllByDepartureAirportAndArrivalAirportAndDepartureTime(
                            request.getDepartureAirport(),
                            request.getArrivalAirport(),
                            request.getDepartureDate());
        }
        return flights
                .stream()
                .map(FlightDTOConverter::convertToFlightDto)
                .collect(Collectors.toList());
    }

    public void save(Flight flight) {
        flightRepository.save(flight);
    }
}
