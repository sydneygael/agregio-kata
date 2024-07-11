package com.edwyn.demo.domain.model;

import lombok.Getter;

/**
 * Enum representing the type of the park.
 */
@Getter
public enum ParkType {
    SOLAR("Solar"),
    WIND("Wind"),
    HYDRO("Hydro");

    /**
     * Description of the park type.
     */
    private final String description;

    ParkType(String description) {
        this.description = description;
    }
}
