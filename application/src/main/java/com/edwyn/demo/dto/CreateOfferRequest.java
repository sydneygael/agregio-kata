package com.edwyn.demo.dto;

import com.edwyn.demo.domain.model.Market;
import com.edwyn.demo.domain.model.Park;

import java.util.List;

/**
 * DTO for creating an offer.
 */
public record CreateOfferRequest(
        double quantity,
        String priceFloor,
        Market market,
        List<Park> parks,
        List<Integer> timeBlocks,
        String parkType,
        double capacity,
        String parkName
) { }

