package com.edwyn.demo.entity;

import com.edwyn.demo.domain.model.ParkType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Entity representing a park.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "park")
public class ParkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ParkType type;

    private double capacity;

    @ManyToMany(mappedBy = "parks", fetch = FetchType.LAZY)
    private List<OfferEntity> offers;
}
