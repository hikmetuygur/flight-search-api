package com.huygur.flightapi.scheduled;

import com.huygur.flightapi.model.Flight;
import com.huygur.flightapi.service.FlightService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Component
public class FlightDataJob {

    private final FlightService flightService;

    public FlightDataJob(FlightService flightService) {

        this.flightService = flightService;
    }

    @Scheduled(cron = "* * * 1 * *")
    public void fetchDataAndSaveToDatabase() {
        String mockApiUrl = "https://mockapi.com/flight-data";
        RestTemplate restTemplate = new RestTemplate();
        Flight flightData = createFlightObjectFromMockData();
        flightService.save(flightData);

        System.out.println("Flight data fetched and saved to database.");
    }

    private Flight createFlightObjectFromMockData() {

        return new Flight("IST", "JFK", new Date(), new Date(), 500.0);
    }
}