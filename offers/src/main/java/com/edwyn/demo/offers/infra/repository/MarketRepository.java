package com.edwyn.demo.offers.infra.repository;

import com.edwyn.demo.offers.domain.Market;
import com.edwyn.demo.offers.infra.entities.MarketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<MarketEntity, Market> {
}