package com.edwyn.demo.service;

import com.edwyn.demo.domain.model.Offer;
import com.edwyn.demo.domain.model.Park;
import com.edwyn.demo.domain.service.OfferDomainService;
import com.edwyn.demo.dto.CreateOfferRequest;
import com.edwyn.demo.port.UseCase;
import com.edwyn.demo.port.in.OfferManagement;
import com.edwyn.demo.port.out.OfferPort;
import com.edwyn.demo.port.out.ParkPort;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Application service for managing offers.
 */
@UseCase
public class OfferUseCase implements OfferManagement {

    private final OfferDomainService offerDomainService;
    private final OfferPort offerPort;
    private final ParkPort parkPort;

    public OfferUseCase(OfferDomainService offerDomainService,
                        OfferPort offerPort,
                        ParkPort parkPort) {
        this.offerDomainService = offerDomainService;
        this.offerPort = offerPort;
        this.parkPort = parkPort;
    }

    @Transactional
    @Override
    public Offer createOffer(CreateOfferRequest request) {
        BigDecimal priceFloor = new BigDecimal(request.priceFloor());
        List<Park> parks = request.parks().stream().map(park -> {
            if (park.getId() != null) {
                return parkPort.findById(park.getId());
            } else {
                return parkPort.save(park);
            }
        }).toList();
        var offer = offerDomainService.createOffer(
                request.quantity(),
                priceFloor, request.market(),
                parks,
                request.timeBlocks());
        return offerPort.save(offer);
    }

    @Override
    public Offer getOfferWithParks(Long offerId) {
        return offerPort.findOfferWithParks(offerId);
    }

    @Override
    public List<Offer> getOffersByMarket(String market) {
        return offerPort.findByMarket(market);
    }
}
