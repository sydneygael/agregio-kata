package com.edwyn.demo.offers.application.ports.out;

import com.edwyn.demo.offers.domain.Offer;

import java.util.List;

public interface DataOffersPort {
    Offer save(Offer offer);
    Offer findOfferWithParks(Long offerId);
    List<Offer> findByMarket(String market);
}
