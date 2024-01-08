package com.huygur.flightapi.dto;

import java.io.Serializable;

public record AirportDTO(String city) implements Serializable {

    public String getCity() {
        return city;
    }

}