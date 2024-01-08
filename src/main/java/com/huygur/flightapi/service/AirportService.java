package com.huygur.flightapi.service;

import com.huygur.flightapi.dto.AirportDTO;
import com.huygur.flightapi.dto.converter.AirportDTOConverter;
import com.huygur.flightapi.model.Airport;
import com.huygur.flightapi.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<AirportDTO> getAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        return airports
                .stream()
                .map(AirportDTOConverter::convertToAirportDto)
                .collect(Collectors.toList());
    }

    public AirportDTO getAirportById(Long id) {
        Airport airport = airportRepository.findById(id).orElseThrow();
        return AirportDTOConverter.convertToAirportDto(airport);
    }

    public AirportDTO createAirport(AirportDTO airportDto) {
        Airport airport = AirportDTOConverter.convertToAirport(airportDto);
        Airport savedAirport = airportRepository.save(airport);
        return AirportDTOConverter.convertToAirportDto(savedAirport);
    }

    public AirportDTO updateAirport(Long id, AirportDTO airportDto) {
        Airport airport = AirportDTOConverter.convertToAirport(airportDto);
        airport.setId(id);
        Airport savedAirport = airportRepository.save(airport);
        return AirportDTOConverter.convertToAirportDto(savedAirport);
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }

}
