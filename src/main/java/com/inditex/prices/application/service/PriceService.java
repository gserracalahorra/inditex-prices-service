package com.inditex.prices.application.service;

import com.inditex.prices.application.domain.Price;
import com.inditex.prices.application.exception.ResourceNotFoundException;
import com.inditex.prices.application.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public Price findByProductIdBrandIdBetweenApplicationDate(Long productId,
                                                              Long brandId,
                                                              LocalDateTime applicationDate) {

        log.debug("Retrieving product price by {}, {}, {}", productId, brandId, applicationDate);
        return priceRepository.findByProductIdBrandIdBetweenApplicationDate(productId, brandId, applicationDate)
                .orElseThrow(() -> new ResourceNotFoundException("Price not found for product " + productId +
                        " and brand " + brandId + " at " + applicationDate));
    }

}