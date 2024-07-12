package com.edwyn.demo.repository;

import com.edwyn.demo.domain.model.Market;
import com.edwyn.demo.entity.MarketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<MarketEntity, Market> {
}