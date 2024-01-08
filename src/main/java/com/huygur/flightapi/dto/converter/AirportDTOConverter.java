package com.huygur.flightapi.dto.converter;

import com.huygur.flightapi.dto.AirportDTO;
import com.huygur.flightapi.model.Airport;

public class AirportDTOConverter {

    public static AirportDTO convertToAirportDto(Airport airport) {
        return new AirportDTO(
                airport.getCity()
        );
    }

    public static Airport convertToAirport(AirportDTO airportDto) {
        return new Airport(
                airportDto.getCity()
        );
    }

}
