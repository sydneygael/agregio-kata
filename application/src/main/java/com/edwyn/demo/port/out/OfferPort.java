package com.edwyn.demo.port.out;

import com.edwyn.demo.domain.model.Offer;

import java.util.List;

/**
 * Port interface for persisting offers.
 */
public interface OfferPort {
    Offer save(Offer offer);
    Offer findOfferWithParks(Long offerId);
    List<Offer> findByMarket(String market);
}

