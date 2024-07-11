package com.edwyn.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain model representing an energy park.
 */
@Data
@NoArgsConstructor
public class Park {
    /**
     * Unique identifier for the park.
     */
    private Long id;

    /**
     * Name of the park.
     */
    private String name;

    /**
     * Type of the park (e.g., Solar, Wind, Hydro).
     */
    private ParkType type;

    /**
     * Capacity of the park in MW.
     */
    private Double capacity;

    public Park(String name, ParkType type, Double capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }
}
