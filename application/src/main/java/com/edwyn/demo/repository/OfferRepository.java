package com.edwyn.demo.repository;
import com.edwyn.demo.entity.OfferEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * JPA repository for managing offer entities.
 */
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    /**
     * Finds all offers with their associated parks.
     *
     * @return a list of offer entities with their parks.
     */
    @Query("SELECT o FROM OfferEntity o JOIN FETCH o.parks WHERE o.id = :offerId")
    @EntityGraph(attributePaths = {"parks"})
    OfferEntity findOfferWithParks(@Param("offerId") Long offerId);

    /**
     * Finds all offers for a specific market.
     *
     * @param market the market for which to find offers.
     * @return a list of offer entities for the specified market.
     */
    @EntityGraph(attributePaths = {"parks", "timeBlocks"})
    List<OfferEntity> findByMarket(String market);
}
