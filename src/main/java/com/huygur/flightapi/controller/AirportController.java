package com.huygur.flightapi.controller;

import com.huygur.flightapi.dto.AirportDTO;
import com.huygur.flightapi.service.AirportService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/airport")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    //get all airports
    @GetMapping("/user/all")
    public List<AirportDTO> getAllAirport() {
        return airportService.getAllAirports();
    }

    //get airport by id
    @GetMapping("/user/{id}")
    public AirportDTO getAirportById(@PathVariable Long id) {
        return airportService.getAirportById(id);
    }

    //create airport
    @PostMapping("/admin/create")
    public AirportDTO createAirport(@Valid @RequestBody AirportDTO airport) {
        return airportService.createAirport(airport);
    }

    //update airport
    @PutMapping("/admin/{id}")
    public AirportDTO updateAirport(@PathVariable Long id, AirportDTO airport) {
        return airportService.updateAirport(id, airport);
    }
    //delete airport

    @DeleteMapping("/admin/{id}")
    public void deleteAirport(@PathVariable Long id) {
        airportService.deleteAirport(id);
    }
}
