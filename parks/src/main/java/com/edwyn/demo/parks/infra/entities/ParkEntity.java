package com.edwyn.demo.parks.infra.entities;

import com.edwyn.demo.parks.domain.ParkType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ParkType type;

    private String name;

    private double capacity;
}
