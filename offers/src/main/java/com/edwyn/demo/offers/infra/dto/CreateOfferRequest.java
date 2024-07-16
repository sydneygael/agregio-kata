package com.edwyn.demo.offers.infra.dto;

import com.edwyn.demo.offers.domain.Market;
import com.edwyn.demo.offers.domain.Offer;
import com.edwyn.demo.offers.domain.OffersFactory;
import com.edwyn.demo.parks.domain.Park;

import java.math.BigDecimal;
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
) {
    public Offer toDomain() {
        BigDecimal price = new BigDecimal(priceFloor);
        return OffersFactory.createOffer(quantity, price, market, parks, timeBlocks);
    }
}

