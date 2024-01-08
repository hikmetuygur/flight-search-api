package com.huygur.flightapi.controller;

import com.huygur.flightapi.controller.request.SearchRequest;
import com.huygur.flightapi.dto.FlightDTO;
import com.huygur.flightapi.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {

    private final FlightService flightService;


    public FlightController(FlightService flightService) {
        this.flightService = flightService;

    }

    @GetMapping("/user")
    public List<FlightDTO> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/user/{id}")
    public FlightDTO getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @PostMapping("/admin/create")
    public FlightDTO createFlight(@Valid @RequestBody FlightDTO flight) {
        return flightService.createFlight(flight);
    }


    @PutMapping("/admin/{id}")
    public FlightDTO updateFlight(@PathVariable Long id, FlightDTO flight) {
        return flightService.updateFlight(id, flight);
    }


    @DeleteMapping("/admin/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }


    @PostMapping("/user/search")
    public ResponseEntity<List<FlightDTO>> searchFlights(@Valid @RequestBody SearchRequest searchRequest) {
        return ResponseEntity.ok(flightService.searchFlights(searchRequest));
    }

}
