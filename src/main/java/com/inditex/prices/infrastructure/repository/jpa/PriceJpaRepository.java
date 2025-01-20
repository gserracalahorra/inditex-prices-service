package com.inditex.prices.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Integer> {

  @Query(
      "select p1 from PriceEntity p1 where p1.productId = :productId and p1.brandId = :brandId " +
          "and p1.startDate <= :applicationDate and p1.endDate >= :applicationDate and p1.priority = " +
          "(select max(p2.priority) from PriceEntity p2 where p2.productId = :productId and p2.brandId = :brandId " +
          "and p2.startDate <= :applicationDate and p2.endDate >= :applicationDate) ")
  Optional<PriceEntity> findByProductIdBrandIdAndApplicationDateBetweenStartDateAndEndDate(
      @Param("productId") Long productId,
      @Param("brandId") Long brandId,
      @Param("applicationDate") LocalDateTime applicationDate);

}
