package com.edwyn.demo.offers.infra.entities;

import com.edwyn.demo.domain.model.Market;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketEntity {
    @Id
    @Enumerated(EnumType.STRING)
    private Market id;

    private String description;

    public MarketEntity(Market market) {
        this.id = market;
        this.description = market.getDescription();
    }
}


