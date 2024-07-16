package com.edwyn.demo.parks.infra.repository;

import com.edwyn.demo.parks.domain.ParkType;
import com.edwyn.demo.parks.infra.entities.ParkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkRepository extends JpaRepository<ParkEntity, Long> {
    Optional<ParkEntity> findByType(ParkType type);
}
