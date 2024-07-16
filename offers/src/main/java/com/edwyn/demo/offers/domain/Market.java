package com.edwyn.demo.offers.domain;

import lombok.Getter;

/**
 * Enum representing the three main energy markets. (extensible)
 */
@Getter
public enum Market {
    RESERVE_PRIMAIRE("Réserve Primaire"),
    RESERVE_SECONDAIRE("Réserve Secondaire"),
    RESERVE_RAPIDE("Réserve Rapide");

    private final String description;

    Market(String description) {
        this.description = description;
    }
}
