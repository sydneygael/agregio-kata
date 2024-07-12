package com.edwyn.demo.repository;

import com.edwyn.demo.domain.model.ParkType;
import com.edwyn.demo.entity.ParkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkRepository extends JpaRepository<ParkEntity, Long> {
    Optional<ParkEntity> findById(Long id);
    Optional<ParkEntity> findByType(ParkType type);
}
