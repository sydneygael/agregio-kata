package com.edwyn.demo.service;

import com.edwyn.demo.domain.model.Offer;
import com.edwyn.demo.domain.model.Park;
import com.edwyn.demo.domain.service.OfferDomainService;
import com.edwyn.demo.dto.CreateOfferRequest;
import com.edwyn.demo.mapper.OfferMapper;
import com.edwyn.demo.port.OfferPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Application service for managing offers.
 */
@Service
public class OfferService {

    private final OfferDomainService offerDomainService;
    private final OfferPort offerPort;
    private final OfferMapper offerMapper;

    public OfferService(OfferDomainService offerDomainService, OfferPort offerPort, OfferMapper offerMapper) {
        this.offerDomainService = offerDomainService;
        this.offerPort = offerPort;
        this.offerMapper = offerMapper;
    }

    @Transactional
    public Offer createOffer(CreateOfferRequest request) {
        List<Park> parks = offerMapper.toParks(request);
        BigDecimal priceFloor = new BigDecimal(request.priceFloor());
        var offer = offerDomainService.createOffer(request.quantity(), priceFloor, request.market(), parks, request.timeBlocks());
        return offerPort.save(offer);
    }

    public Offer getOfferWithParks(Long offerId) {
        return offerPort.findOfferWithParks(offerId);
    }

    public List<Offer> getOffersByMarket(String market) {
        return offerPort.findByMarket(market);
    }
}
