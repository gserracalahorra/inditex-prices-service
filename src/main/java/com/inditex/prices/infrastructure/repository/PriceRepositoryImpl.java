package com.inditex.prices.infrastructure.repository;

import com.inditex.prices.application.domain.Price;
import com.inditex.prices.application.repository.PriceRepository;
import com.inditex.prices.infrastructure.repository.jpa.PriceJpaRepository;
import com.inditex.prices.infrastructure.repository.mapper.PriceEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceEntityMapper mapper;

    private final PriceJpaRepository priceJpaRepository;

    @Override
    public Optional<Price> findByProductIdBrandIdBetweenApplicationDate(Long productId,
                                                                        Long brandId,
                                                                        LocalDateTime applicationDate) {
        return priceJpaRepository
                .findByProductIdBrandIdAndApplicationDateBetweenStartDateAndEndDate(productId, brandId,
                        applicationDate).map(mapper::fromEntityToDomain);
    }

}