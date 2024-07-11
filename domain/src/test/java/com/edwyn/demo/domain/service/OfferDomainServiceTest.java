package com.edwyn.demo.domain.service;

import com.edwyn.demo.domain.exception.InvalidTimeBlockException;
import com.edwyn.demo.domain.exception.TimeBlockExceedingException;
import com.edwyn.demo.domain.model.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the OfferDomainService.
 */
 class OfferDomainServiceTest {

    @Test
    void testValidateTimeBlocks() {
        //Given
        Market market = Market.RESERVE_PRIMAIRE;
        List<Park> parks = List.of(new Park(1L, "Park1", ParkType.SOLAR, 100.0));
        Offer offer = new Offer(100, new BigDecimal("50.00"), market, parks);
        //when
        offer.addTimeBlock(new TimeBlock(0, 8));
        offer.addTimeBlock(new TimeBlock(8, 8));
        offer.addTimeBlock(new TimeBlock(16, 8));
        var offerDomainService = new OfferDomainService();
        //then
        assertTrue(offerDomainService.isValidOffer(offer));
    }

    @Test
    void testInvalidTimeBlocks() {
        Market market = Market.RESERVE_PRIMAIRE;
        List<Park> parks = List.of(new Park(1L, "Park1", ParkType.SOLAR, 100.0));
        Offer offer = new Offer(100, new BigDecimal("50.00"), market, parks);

        offer.addTimeBlock(new TimeBlock(0, 10));
        offer.addTimeBlock(new TimeBlock(10, 10));
        offer.addTimeBlock(new TimeBlock(20, 4));

        var offerDomainService = new OfferDomainService();

        assertFalse(offerDomainService.isValidOffer(offer));
    }

    @Test
    void testCreateOffer() {
        Market market = Market.RESERVE_PRIMAIRE;
        List<Park> parks = List.of(new Park(1L, "Park1", ParkType.SOLAR, 100.0));
        List<Integer> timeBlocks = List.of(8, 8, 8);

        var offerDomainService = new OfferDomainService();
        Offer offer = offerDomainService.createOffer(100, new BigDecimal("50.00"), market, parks, timeBlocks);

        assertNotNull(offer);
        assertTrue(offerDomainService.isValidOffer(offer));
    }

    @Test
    void testCreateInvalidOffer() {
        Market market = Market.RESERVE_PRIMAIRE;
        List<Park> parks = List.of(new Park(1L, "Park1", ParkType.SOLAR, 100.0));
        List<Integer> timeBlocks = List.of(10, 10, 4);

        var offerDomainService = new OfferDomainService();

        assertThrows(IllegalArgumentException.class, () -> offerDomainService.createOffer(100, new BigDecimal("50.00"), market, parks, timeBlocks));
    }

    @Test
    void testAddInvalidTimeBlockExceedingLimit() {
        Market market = Market.RESERVE_PRIMAIRE;
        List<Park> parks = List.of(new Park(1L, "Park1", ParkType.SOLAR, 100.0));
        Offer offer = new Offer(100, new BigDecimal("50.00"), market, parks);

        offer.addTimeBlock(new TimeBlock(0, 16));

        assertThrows(TimeBlockExceedingException.class, () -> {
            offer.addTimeBlock(new TimeBlock(16, 9));
        });
    }

    @Test
    void testAddInvalidTimeBlockEarlierStartHour() {
        Market market = Market.RESERVE_PRIMAIRE;
        List<Park> parks = List.of(new Park(1L, "Park1", ParkType.SOLAR, 100.0));
        Offer offer = new Offer(100, new BigDecimal("50.00"), market, parks);

        offer.addTimeBlock(new TimeBlock(0, 8));
        offer.addTimeBlock(new TimeBlock(8, 8));

        assertThrows(InvalidTimeBlockException.class, () -> {
            offer.addTimeBlock(new TimeBlock(7, 8));
        });
    }
}
