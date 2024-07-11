package com.edwyn.demo.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

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

    public TimeBlock(int startHour, int duration) {
        this.startHour = startHour;
        this.duration = duration;
    }
}
