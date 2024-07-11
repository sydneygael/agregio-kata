package com.edwyn.demo.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Domain model representing an energy offer.
 */
@Data
@NoArgsConstructor
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
    private double priceFloor;

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

    public Offer(double quantity, double priceFloor, Market market, List<Park> parks) {
        this.quantity = quantity;
        this.priceFloor = priceFloor;
        this.market = market;
        this.parks = parks;
    }
}
