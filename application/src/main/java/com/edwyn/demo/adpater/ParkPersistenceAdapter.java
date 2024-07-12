package com.edwyn.demo.adpater;

import com.edwyn.demo.domain.model.Park;
import com.edwyn.demo.domain.model.ParkType;
import com.edwyn.demo.mapper.OfferMapper;
import com.edwyn.demo.port.ParkPort;
import com.edwyn.demo.repository.ParkRepository;
import org.springframework.stereotype.Component;

@Component
public class ParkPersistenceAdapter implements ParkPort {

    private final ParkRepository parkRepository;
    private final OfferMapper offerMapper;

    public ParkPersistenceAdapter(ParkRepository parkRepository, OfferMapper offerMapper) {
        this.parkRepository = parkRepository;
        this.offerMapper = offerMapper;
    }

    @Override
    public Park findById(Long id) {
        return parkRepository.findById(id)
                .map(offerMapper::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("Park not found: " + id));// Handle appropriately in your application context
    }

    @Override
    public Park findByType(ParkType type) {
        return parkRepository.findByType(type)
                .map(offerMapper::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("Park type not found: " + type.getDescription())); // Handle appropriately in your application context
    }

    @Override
    public Park save(Park park) {
        var parkEntity = offerMapper.toEntity(park);
        var savedEntity = parkRepository.save(parkEntity);
        return offerMapper.toDomain(savedEntity);
    }
}

