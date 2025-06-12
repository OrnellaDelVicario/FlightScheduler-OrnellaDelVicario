package org.example;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class App {
    public static void main(String[] args) {

        Flight flight1 = new Flight(
                "XY123",
                LocalDateTime.parse("2025-06-10T10:00"),
                ZoneId.of("Europe/London")
        );

        Flight flight2 = new Flight(
                "AB456",
                LocalDateTime.parse("2025-06-10T18:00"),
                ZoneId.of("America/New_York")
        );

        Flight flight3 = new Flight(
                "CD789",
                LocalDateTime.parse("2025-06-10T08:30"),
                ZoneId.of("Asia/Tokyo")
        );

        flight1.updateStatus();
        flight2.updateStatus();
        flight3.updateStatus();

        flight1.printFlightDetails();
        flight2.printFlightDetails();
        flight3.printFlightDetails();
    }
}
