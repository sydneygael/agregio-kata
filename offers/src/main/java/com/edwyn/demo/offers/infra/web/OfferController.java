package com.edwyn.demo.offers.infra.web;


import com.edwyn.demo.offers.application.usecases.OffersManagement;
import com.edwyn.demo.offers.domain.Offer;
import com.edwyn.demo.offers.infra.dto.CreateOfferRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing offers.
 */
@RestController
@RequestMapping("/offers")
public class OfferController {

    private final OffersManagement offersManagement;

    public OfferController(OffersManagement offersManagement) {
        this.offersManagement = offersManagement;
    }

    @PostMapping
    public Offer createOffer(@RequestBody CreateOfferRequest request) {
        return offersManagement.createOffer(request.toDomain());
    }

    @GetMapping("/{market}")
    public List<Offer> getOffersByMarket(@PathVariable String market) {
        return offersManagement.getOffersByMarket(market);
    }

    @GetMapping("/{offerId}/parks")
    public Offer getOfferWithParks(@PathVariable Long offerId) {
        return offersManagement.getOfferWithParks(offerId);
    }
}
