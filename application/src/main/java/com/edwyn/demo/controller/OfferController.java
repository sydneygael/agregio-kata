package com.edwyn.demo.controller;

import com.edwyn.demo.domain.model.Offer;
import com.edwyn.demo.dto.CreateOfferRequest;
import com.edwyn.demo.service.OfferUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing offers.
 */
@RestController
@RequestMapping("/offers")
public class OfferController {

    private final OfferUseCase offerUseCase;

    public OfferController(OfferUseCase offerUseCase) {
        this.offerUseCase = offerUseCase;
    }

    @PostMapping
    public Offer createOffer(@RequestBody CreateOfferRequest request) {
        return offerUseCase.createOffer(request);
    }

    @GetMapping("/{market}")
    public List<Offer> getOffersByMarket(@PathVariable String market) {
        return offerUseCase.getOffersByMarket(market);
    }

    @GetMapping("/{offerId}/parks")
    public Offer getOfferWithParks(@PathVariable Long offerId) {
        return offerUseCase.getOfferWithParks(offerId);
    }
}
