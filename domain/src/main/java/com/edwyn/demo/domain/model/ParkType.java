package com.edwyn.demo.domain.model;

/**
 * Enum representing the type of the park.
 */
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

    public String getDescription() {
        return description;
    }
}
