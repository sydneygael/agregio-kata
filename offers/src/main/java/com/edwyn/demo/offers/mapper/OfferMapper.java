package com.edwyn.demo.offers.mapper;


import com.edwyn.demo.offers.domain.Offer;
import com.edwyn.demo.offers.domain.TimeBlock;
import com.edwyn.demo.offers.infra.entities.OfferEntity;
import com.edwyn.demo.offers.infra.entities.TimeBlockEntity;
import com.edwyn.demo.parks.mapper.ParkMapper;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between domain models and entities.
 */
@Component
public class OfferMapper {

    private final ParkMapper parkMapper;

    public OfferMapper(ParkMapper parkMapper) {
        this.parkMapper = parkMapper;
    }


    /**
     * Converts an offer entity to a domain model.
     *
     * @param entity the offer entity
     * @return the domain model
     */
    public Offer toDomain(OfferEntity entity) {
        Offer offer = new Offer();
        offer.setId(entity.getId());
        offer.setQuantity(entity.getQuantity());
        offer.setMarket(entity.getMarket());
        offer.setParks(entity.getParks().stream().map(parkMapper::toDomain).toList());
        offer.setTimeBlocks(entity.getTimeBlocks().stream().map(this::toDomain).toList());
        return offer;
    }

    /**
     * Converts a domain model to an offer entity.
     *
     * @param domain the domain model
     * @return the offer entity
     */
    public OfferEntity toEntity(Offer domain) {
        OfferEntity offerEntity = new OfferEntity();
        offerEntity.setId(domain.getId());
        offerEntity.setQuantity(domain.getQuantity());
        offerEntity.setMarket(domain.getMarket());
        offerEntity.setParks(domain.getParks().stream().map(parkMapper::toEntity).toList());
        offerEntity.setTimeBlocks(domain.getTimeBlocks().stream().map(this::toEntity).toList());
        return offerEntity;
    }

    /**
     * Converts a time block entity to a domain model.
     *
     * @param entity the time block entity
     * @return the domain model
     */
    public TimeBlock toDomain(TimeBlockEntity entity) {
        TimeBlock timeBlock = new TimeBlock();
        timeBlock.setId(entity.getId());
        timeBlock.setStartHour(entity.getStartHour());
        timeBlock.setDuration(entity.getDuration());
        timeBlock.setPriceFloor(entity.getPriceFloor());
        return timeBlock;
    }

    /**
     * Converts a domain model to a time block entity.
     *
     * @param domain the domain model
     * @return the time block entity
     */
    public TimeBlockEntity toEntity(TimeBlock domain) {
        TimeBlockEntity timeBlockEntity = new TimeBlockEntity();
        timeBlockEntity.setId(domain.getId());
        timeBlockEntity.setStartHour(domain.getStartHour());
        timeBlockEntity.setDuration(domain.getDuration());
        timeBlockEntity.setPriceFloor(domain.getPriceFloor());
        return timeBlockEntity;
    }
}
