package org.example;

public enum FlightStatus {
    SCHEDULED,
    DELAYED,
    DEPARTED,
    ARRIVED;

    public boolean isFinal() {
        return this == ARRIVED;
    }
}
