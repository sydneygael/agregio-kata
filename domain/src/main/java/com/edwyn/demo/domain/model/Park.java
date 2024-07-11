package com.edwyn.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain model representing an energy park.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
