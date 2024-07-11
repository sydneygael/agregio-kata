package com.edwyn.demo.domain.model;
/**
 * Enum representing the three main energy markets. (extensible)
 */
public enum Market {
    RESERVE_PRIMAIRE("Réserve Primaire"),
    RESERVE_SECONDAIRE("Réserve Secondaire"),
    RESERVE_RAPIDE("Réserve Rapide");

    private final String description;

    Market(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
