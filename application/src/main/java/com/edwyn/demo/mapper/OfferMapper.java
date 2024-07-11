package com.edwyn.demo.mapper;

import com.edwyn.demo.domain.model.Offer;
import com.edwyn.demo.domain.model.Park;
import com.edwyn.demo.domain.model.ParkType;
import com.edwyn.demo.domain.model.TimeBlock;
import com.edwyn.demo.dto.CreateOfferRequest;
import com.edwyn.demo.entity.OfferEntity;
import com.edwyn.demo.entity.ParkEntity;
import com.edwyn.demo.entity.TimeBlockEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for converting between domain models and entities.
 */
@Component
public class OfferMapper {

    // Other existing methods...

    /**
     * Converts a CreateOfferRequest to a list of Park.
     *
     * @param request the CreateOfferRequest
     * @return the list of parks
     */
    public List<Park> toParks(CreateOfferRequest request) {
        return request.parks().stream()
                .map(park -> new Park(request.parkName(), ParkType.valueOf(request.parkType()), request.capacity()))
                .collect(Collectors.toList());
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
        offer.setPriceFloor(entity.getPriceFloor());
        offer.setMarket(entity.getMarket());
        offer.setParks(entity.getParks().stream().map(this::toDomain).collect(Collectors.toList()));
        offer.setTimeBlocks(entity.getTimeBlocks().stream().map(this::toDomain).collect(Collectors.toList()));
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
        offerEntity.setPriceFloor(domain.getPriceFloor());
        offerEntity.setMarket(domain.getMarket());
        offerEntity.setParks(domain.getParks().stream().map(this::toEntity).collect(Collectors.toList()));
        offerEntity.setTimeBlocks(domain.getTimeBlocks().stream().map(this::toEntity).collect(Collectors.toList()));
        return offerEntity;
    }

    /**
     * Converts a park entity to a domain model.
     *
     * @param entity the park entity
     * @return the domain model
     */
    private Park toDomain(ParkEntity entity) {
        Park park = new Park();
        park.setId(entity.getId());
        park.setName(entity.getName());
        park.setType(entity.getType());
        park.setCapacity(entity.getCapacity());
        return park;
    }

    /**
     * Converts a domain model to a park entity.
     *
     * @param domain the domain model
     * @return the park entity
     */
    private ParkEntity toEntity(Park domain) {
        ParkEntity parkEntity = new ParkEntity();
        parkEntity.setId(domain.getId());
        parkEntity.setName(domain.getName());
        parkEntity.setType(domain.getType());
        parkEntity.setCapacity(domain.getCapacity());
        return parkEntity;
    }

    /**
     * Converts a time block entity to a domain model.
     *
     * @param entity the time block entity
     * @return the domain model
     */
    private TimeBlock toDomain(TimeBlockEntity entity) {
        TimeBlock timeBlock = new TimeBlock();
        timeBlock.setId(entity.getId());
        timeBlock.setStartHour(entity.getStartHour());
        timeBlock.setDuration(entity.getDuration());
        return timeBlock;
    }

    /**
     * Converts a domain model to a time block entity.
     *
     * @param domain the domain model
     * @return the time block entity
     */
    private TimeBlockEntity toEntity(TimeBlock domain) {
        TimeBlockEntity timeBlockEntity = new TimeBlockEntity();
        timeBlockEntity.setId(domain.getId());
        timeBlockEntity.setStartHour(domain.getStartHour());
        timeBlockEntity.setDuration(domain.getDuration());
        return timeBlockEntity;
    }
}

