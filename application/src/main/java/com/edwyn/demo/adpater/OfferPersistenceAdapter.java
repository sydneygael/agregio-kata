package com.edwyn.demo.adpater;

import com.edwyn.demo.domain.model.Offer;
import com.edwyn.demo.entity.OfferEntity;
import com.edwyn.demo.mapper.OfferMapper;
import com.edwyn.demo.port.out.OfferPort;
import com.edwyn.demo.repository.OfferRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Persistence adapter for managing offer persistence.
 */
@Component
public class OfferPersistenceAdapter implements OfferPort {

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

