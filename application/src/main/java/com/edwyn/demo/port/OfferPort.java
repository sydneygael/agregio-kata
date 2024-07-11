package com.edwyn.demo.port;

import com.edwyn.demo.domain.model.Offer;

import java.util.List;

/**
 * Port interface for persisting offers.
 */
public interface OfferPort {
    Offer save(Offer offer);
    List<Offer> getOffers();
    Offer findOfferWithParks(Long offerId);
    List<Offer> findByMarket(String market);
}

