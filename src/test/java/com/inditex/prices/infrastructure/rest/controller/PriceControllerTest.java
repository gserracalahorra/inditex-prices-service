package com.inditex.prices.infrastructure.rest.controller;

import com.inditex.prices.application.domain.Price;
import com.inditex.prices.application.exception.ResourceNotFoundException;
import com.inditex.prices.application.service.PriceService;
import com.inditex.prices.infrastructure.rest.controller.mapper.PriceDtoMapper;
import com.inditex.prices.infrastructure.rest.dto.PriceDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PriceControllerTest {

    @InjectMocks
    private PriceController priceController;

    @Mock
    private PriceService priceService;

    @Mock
    private PriceDtoMapper priceDtoMapper;

    @Test
    public void test200Response() {

        var price = Price.builder().build();

        when(priceService.findByProductIdBrandIdBetweenApplicationDate(any(), any(), any())).thenReturn(price);

        when(priceDtoMapper.fromDomainToDto(any())).thenReturn(new PriceDto());

        var response = priceController.pricesGet(LocalDate.now().atStartOfDay(), 1l, 1l);

        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    public void test404Response() {

        when(priceService.findByProductIdBrandIdBetweenApplicationDate(any(), any(), any()))
                .thenThrow(new ResourceNotFoundException("Resource not found"));

        assertThrows(ResourceNotFoundException.class, () -> {
            priceController.pricesGet(LocalDate.now().atStartOfDay(), 1l, 1l);
        });
    }

}