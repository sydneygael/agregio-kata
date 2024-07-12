package com.edwyn.demo.domain.model;

import com.edwyn.demo.domain.exception.InvalidTimeBlockException;
import com.edwyn.demo.domain.exception.TimeBlockExceedingException;
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

    public Offer(double quantity, Market market, List<Park> parks) {
        this.quantity = quantity;
        this.market = market;
        this.parks = parks;
    }

    /**
     * Adds a time block to the offer.
     *
     * @param timeBlock the time block to add
     */
    public void addTimeBlock(TimeBlock timeBlock) {
        if (!timeBlocks.isEmpty()) {
            var lastBlock = timeBlocks.getLast(); //java 21
            if (timeBlock.getStartHour() < lastBlock.getStartHour()) {
                throw new InvalidTimeBlockException("Start hour of the new time block must not be earlier than the last time block");
            }
        }

        var totalHours = this.timeBlocks.stream().mapToInt(TimeBlock::getDuration).sum();
        if (totalHours + timeBlock.getDuration() > 24) {
            throw new TimeBlockExceedingException("Adding this time block would exceed the 24-hour limit");
        }

        this.timeBlocks.add(timeBlock);
    }

    /**
     * Validates the time blocks of the offer.
     *
     * @return true if the total duration of time blocks is 24 hours, false otherwise
     */
    public boolean validateTimeBlocks() {
        int totalHours = this.timeBlocks.stream().mapToInt(TimeBlock::getDuration).sum();
        return totalHours == 24;
    }
}

