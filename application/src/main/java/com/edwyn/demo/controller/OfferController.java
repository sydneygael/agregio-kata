package com.edwyn.demo.controller;

import com.edwyn.demo.domain.model.Offer;
import com.edwyn.demo.dto.CreateOfferRequest;
import com.edwyn.demo.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing offers.
 */
@RestController
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public Offer createOffer(@RequestBody CreateOfferRequest request) {
        return offerService.createOffer(request);
    }

    @GetMapping("/{market}")
    public List<Offer> getOffersByMarket(@PathVariable String market) {
        return offerService.getOffersByMarket(market);
    }

    @GetMapping("/{offerId}/parks")
    public Offer getOfferWithParks(@PathVariable Long offerId) {
        return offerService.getOfferWithParks(offerId);
    }
}
