package com.edwyn.demo.offers.infra.entities;


import com.edwyn.demo.offers.domain.Market;
import com.edwyn.demo.parks.infra.entities.ParkEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double quantity;

    @Convert(converter = MarketConverter.class)
    @Column(nullable = false)
    private Market market;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "offer_park",
            joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "park_id")
    )
    private List<ParkEntity> parks;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<TimeBlockEntity> timeBlocks;
}