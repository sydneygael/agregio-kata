package com.edwyn.demo.parks.infra.adapters;


import com.edwyn.demo.parks.application.ports.out.DataParksPort;
import com.edwyn.demo.parks.domain.Park;
import com.edwyn.demo.parks.domain.ParkType;
import com.edwyn.demo.parks.infra.repository.ParkRepository;
import com.edwyn.demo.parks.mapper.ParkMapper;
import org.springframework.stereotype.Component;

@Component
public class ParkPersistenceAdapter implements DataParksPort {

    private final ParkRepository parkRepository;
    private final ParkMapper parkMapper;

    public ParkPersistenceAdapter(ParkRepository parkRepository, ParkMapper parkMapper) {
        this.parkRepository = parkRepository;
        this.parkMapper = parkMapper;
    }

    @Override
    public Park findById(Long id) {
        return parkRepository.findById(id)
                .map(parkMapper::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("Park not found: " + id));// Handle appropriately in your application context
    }

    @Override
    public Park findByType(ParkType type) {
        return parkRepository.findByType(type)
                .map(parkMapper::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("Park type not found: " + type.getDescription())); // Handle appropriately in your application context
    }

    @Override
    public Park save(Park park) {
        var parkEntity = parkMapper.toEntity(park);
        var savedEntity = parkRepository.save(parkEntity);
        return parkMapper.toDomain(savedEntity);
    }
}

