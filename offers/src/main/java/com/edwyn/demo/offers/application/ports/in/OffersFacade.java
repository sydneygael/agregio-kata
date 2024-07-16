package com.edwyn.demo.offers.application.ports.in;

import com.edwyn.demo.offers.domain.Offer;

import java.util.List;

public interface OffersFacade {
    Offer createOffer(Offer offer);
    Offer getOfferWithParks(Long offerId);
    List<Offer> getOffersByMarket(String market);
}
