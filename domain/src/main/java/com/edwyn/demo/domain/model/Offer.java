package com.edwyn.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Domain model representing an energy offer.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    /**
     * Unique identifier for the offer.
     */
    private Long id;

    /**
     * Quantity of energy in MW.
     */
    private double quantity;

    /**
     * Minimum price at which the energy will be sold.
     */
    private BigDecimal priceFloor;

    /**
     * Market where the offer is placed.
     */
    private Market market;

    /**
     * List of parks that will produce the energy.
     */
    private List<Park> parks;

    /**
     * List of time blocks for the offer.
     */
    private List<TimeBlock> timeBlocks = new ArrayList<>();

    public void addTimeBlock(TimeBlock timeBlock) {
        this.timeBlocks.add(timeBlock);
    }

    public boolean validateTimeBlocks() {
        int totalHours = this.timeBlocks.stream().mapToInt(TimeBlock::getDuration).sum();
        return totalHours == 24;
    }
}
