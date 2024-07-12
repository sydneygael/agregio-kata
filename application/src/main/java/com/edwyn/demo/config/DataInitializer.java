package com.edwyn.demo.config;

import com.edwyn.demo.domain.model.Market;
import com.edwyn.demo.domain.model.ParkType;
import com.edwyn.demo.entity.MarketEntity;
import com.edwyn.demo.entity.ParkEntity;
import com.edwyn.demo.repository.MarketRepository;
import com.edwyn.demo.repository.ParkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ParkRepository parkRepository;
    private final MarketRepository marketRepository;

    public DataInitializer(ParkRepository parkRepository, MarketRepository marketRepository) {
        this.parkRepository = parkRepository;
        this.marketRepository = marketRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Initialize ParkType data
        for (ParkType parkType : ParkType.values()) {
            if (parkRepository.findByType(parkType).isEmpty()) {
                ParkEntity parkEntity = new ParkEntity();
                parkEntity.setType(parkType);
                parkEntity.setName(parkType.getDescription());
                parkEntity.setCapacity(100.0); // Default capacity, modify as needed
                parkRepository.save(parkEntity);
            }
        }

        // Initialize Market data
        for (Market market : Market.values()) {
            if (marketRepository.findById(market).isEmpty()) {
                MarketEntity marketEntity = new MarketEntity();
                marketEntity.setId(market);
                marketRepository.save(marketEntity);
            }
        }
    }
}
