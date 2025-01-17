package com.inditex.prices.application.repository;

import com.inditex.prices.application.domain.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {

    Optional<Price> findByProductIdBrandIdBetweenApplicationDate(Long productId,
                                                                 Long brandId,
                                                                 LocalDateTime applicationDate);

}