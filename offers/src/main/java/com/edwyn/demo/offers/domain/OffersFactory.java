package com.edwyn.demo.offers.domain;

import com.edwyn.demo.domain.exception.InvalidTimeBlockException;
import com.edwyn.demo.domain.exception.TimeBlockExceedingException;
import com.edwyn.demo.parks.domain.Park;

import java.math.BigDecimal;
import java.util.List;

/**
 * Domain service for managing offers.
 */
public final class OffersFactory {

    /**
     * Creates an offer and validates the time blocks.
     *
     * @param quantity   the quantity of energy in MW
     * @param priceFloor the minimum price at which the energy will be sold
     * @param market     the market where the offer is placed
     * @param parks      the list of parks that will produce the energy
     * @param timeBlocks the list of time blocks for the offer
     * @return the created offer
     */
    public static Offer createOffer(double quantity, BigDecimal priceFloor, Market market, List<Park> parks, List<Integer> timeBlocks) throws InvalidTimeBlockException, TimeBlockExceedingException {
        Offer offer = new Offer(quantity, market, parks);

        int startHour = 0;
        for (int duration : timeBlocks) {
            TimeBlock timeBlock = new TimeBlock(startHour, duration,priceFloor);
            offer.addTimeBlock(timeBlock);
            startHour += duration;
        }

        if (!offer.validateTimeBlocks()) {
            throw new TimeBlockExceedingException("Total duration of time blocks must be 24 hours");
        }

        return offer;
    }

    /**
     * Validates the time blocks of an offer.
     *
     * @param offer the offer to validate
     * @return true if the offer is valid, false otherwise
     */
    public boolean isValidOffer(Offer offer) {
        return offer.validateTimeBlocks();
    }
}

