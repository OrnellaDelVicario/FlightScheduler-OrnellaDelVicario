package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Flight {
    private final String flightNumber;
    private final LocalDateTime departureTime;
    private final ZoneId departureZone;
    private FlightStatus status;

    public Flight(String flightNumber, LocalDateTime departureTime, ZoneId departureZone) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.departureZone = departureZone;
        this.status = FlightStatus.SCHEDULED;
    }

    public boolean isDeparted() {
        ZonedDateTime zonedDeparture = departureTime.atZone(departureZone);
        ZonedDateTime now = ZonedDateTime.now(departureZone);
        return now.isAfter(zonedDeparture);
    }

    public void updateStatus() {
        if (isDeparted() && status == FlightStatus.SCHEDULED) {
            status = FlightStatus.DEPARTED;
        }
    }

    public void printFlightDetails() {
        ZonedDateTime zonedDeparture = departureTime.atZone(departureZone);
        System.out.println("Flight: " + flightNumber);
        System.out.println("Departs at: " + zonedDeparture.format(DateTimeFormatter.RFC_1123_DATE_TIME));
        System.out.println("Status: " + status);
    }

    // Getters opcionales
    public FlightStatus getStatus() {
        return status;
    }

    public ZonedDateTime getZonedDeparture() {
        return departureTime.atZone(departureZone);
    }
}
