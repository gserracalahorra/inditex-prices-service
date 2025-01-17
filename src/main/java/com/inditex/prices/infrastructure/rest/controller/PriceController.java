package com.inditex.prices.infrastructure.rest.controller;

import com.inditex.prices.application.service.PriceService;
import com.inditex.prices.infrastructure.rest.controller.mapper.PriceDtoMapper;
import com.inditex.prices.infrastructure.rest.dto.PriceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PriceController implements PricesApi {

    private final PriceService priceService;

    private final PriceDtoMapper mapper;

    @Override
    public ResponseEntity<PriceDto> pricesGet(LocalDateTime applicationDate, Long productId, Long brandId) {
        var pricesDomain = priceService
                .findByProductIdBrandIdBetweenApplicationDate(productId, brandId, applicationDate);
        return ResponseEntity.ok(mapper.fromDomainToDto(pricesDomain));
    }

}