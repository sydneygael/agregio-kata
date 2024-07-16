package com.edwyn.demo.parks.mapper;

import com.edwyn.demo.parks.domain.Park;
import com.edwyn.demo.parks.infra.entities.ParkEntity;

public final class ParkMapper {

    /**
     * Converts a park entity to a domain model.
     *
     * @param entity the park entity
     * @return the domain model
     */
    public Park toDomain(ParkEntity entity) {
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
    public ParkEntity toEntity(Park domain) {
        ParkEntity parkEntity = new ParkEntity();
        parkEntity.setId(domain.getId());
        parkEntity.setName(domain.getName());
        parkEntity.setType(domain.getType());
        parkEntity.setCapacity(domain.getCapacity());
        return parkEntity;
    }
}
