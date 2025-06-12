package org.example;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {

    @Test
    void testUpdateStatusChangesToDeparted() {
        Flight flight = new Flight(
                "XY999",
                LocalDateTime.now().minusHours(2), // Hora pasada
                ZoneId.of("Europe/London")
        );

        assertEquals(FlightStatus.SCHEDULED, flight.getStatus()); // Antes de update

        flight.updateStatus();

        assertEquals(FlightStatus.DEPARTED, flight.getStatus()); // Después de update
    }

    @Test
    void testUpdateStatusStaysScheduledIfNotDeparted() {
        Flight flight = new Flight(
                "XY888",
                LocalDateTime.now().plusHours(2),
                ZoneId.of("Europe/London")
        );

        flight.updateStatus();

        assertEquals(FlightStatus.SCHEDULED, flight.getStatus());
    }

    @Test
    void testIsDepartedReturnsTrueWhenPast() {
        LocalDateTime past = LocalDateTime.now().minusMinutes(30);
        Flight flight = new Flight("XY003", past, ZoneId.of("America/New_York"));

        assertTrue(flight.isDeparted());
    }

}
