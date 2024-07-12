package com.edwyn.demo.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Domain model representing a time block within an offer.
 */
@Data
@NoArgsConstructor
public class TimeBlock {
    /**
     * Unique identifier for the time block.
     */
    private Long id;

    /**
     * Starting hour of the time block.
     */
    private int startHour;

    /**
     * Duration of the time block in hours.
     */
    private int duration;

    /**
     * Minimum price at which the energy will be sold.
     */
    private BigDecimal priceFloor;

    public TimeBlock(int startHour, int duration,BigDecimal priceFloor) {
        this.startHour = startHour;
        this.duration = duration;
        this.priceFloor = priceFloor;
    }
}
