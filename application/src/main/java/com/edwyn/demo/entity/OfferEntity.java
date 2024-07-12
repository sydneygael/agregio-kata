package com.edwyn.demo.entity;
import com.edwyn.demo.domain.model.Market;
import com.edwyn.demo.entity.converter.MarketConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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

    @Column(precision = 19, scale = 4)
    private BigDecimal priceFloor;

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
