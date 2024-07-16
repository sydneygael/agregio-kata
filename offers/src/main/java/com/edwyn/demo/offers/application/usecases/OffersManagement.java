package com.edwyn.demo.offers.application.usecases;

import com.edwyn.demo.common.annotation.UseCase;
import com.edwyn.demo.offers.application.ports.in.OffersFacade;
import com.edwyn.demo.offers.application.ports.out.DataOffersPort;
import com.edwyn.demo.offers.domain.Offer;
import com.edwyn.demo.parks.application.ports.out.DataParksPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UseCase
public class OffersManagement implements OffersFacade {

    private final DataOffersPort dataOffersPort;
    private final DataParksPort dataParkPort;

    @Autowired
    public OffersManagement(DataOffersPort dataOffersPort, DataParksPort dataParkPort) {
        this.dataOffersPort = dataOffersPort;
        this.dataParkPort = dataParkPort;
    }

    @Override
    public Offer createOffer(Offer offer) {
        offer.getParks().forEach(park -> {
            if (park.getId()!= null) {
                dataParkPort.findById(park.getId());
            } else {
                dataParkPort.save(park);
            }
        });
        return dataOffersPort.save(offer);
    }

    @Override
    public Offer getOfferWithParks(Long offerId) {
        return dataOffersPort.findOfferWithParks(offerId);
    }

    @Override
    public List<Offer> getOffersByMarket(String market) {
        return dataOffersPort.findByMarket(market);
    }
}
