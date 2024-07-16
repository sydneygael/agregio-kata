package com.edwyn.demo.offers.infra.adpater;


import com.edwyn.demo.offers.application.ports.out.DataOffersPort;
import com.edwyn.demo.offers.domain.Offer;
import com.edwyn.demo.offers.infra.entities.OfferEntity;
import com.edwyn.demo.offers.infra.repository.OfferRepository;
import com.edwyn.demo.offers.mapper.OfferMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Persistence adapter for managing offer persistence.
 */
@Component
public class OfferPersistenceAdapter implements DataOffersPort {

    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper;

    public OfferPersistenceAdapter(OfferRepository offerRepository, OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.offerMapper = offerMapper;
    }

    @Override
    public Offer save(Offer offer) {
        OfferEntity offerEntity = offerMapper.toEntity(offer);
        offerEntity.getTimeBlocks().forEach(timeBlockEntity -> timeBlockEntity.setOffer(offerEntity));
        OfferEntity savedEntity = offerRepository.save(offerEntity);
        return offerMapper.toDomain(savedEntity);
    }

    public List<Offer> getOffers() {
        return offerRepository.findAll().stream().map(offerMapper::toDomain).toList();
    }

    @Override
    public Offer findOfferWithParks(Long offerId) {
        OfferEntity offerEntity = offerRepository.findOfferWithParks(offerId);
        return offerMapper.toDomain(offerEntity);
    }

    @Override
    public List<Offer> findByMarket(String market) {
        List<OfferEntity> offerEntities = offerRepository.findByMarket(market);
        return offerEntities.stream().map(offerMapper::toDomain).toList();
    }
}

