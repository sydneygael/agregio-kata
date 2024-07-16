package com.edwyn.demo.offers.infra.entities;

import com.edwyn.demo.domain.model.Market;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MarketConverter implements AttributeConverter<Market, String> {

    @Override
    public String convertToDatabaseColumn(Market market) {
        return market != null ? market.name() : null;
    }

    @Override
    public Market convertToEntityAttribute(String name) {
        return name != null ? Market.valueOf(name) : null;
    }
}

