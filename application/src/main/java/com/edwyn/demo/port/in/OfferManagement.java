package com.edwyn.demo.port.in;

import com.edwyn.demo.domain.model.Offer;
import com.edwyn.demo.dto.CreateOfferRequest;

import java.util.List;

public interface OfferManagement {

    Offer createOffer(CreateOfferRequest request);
    Offer getOfferWithParks(Long offerId);
    List<Offer> getOffersByMarket(String market);


}
