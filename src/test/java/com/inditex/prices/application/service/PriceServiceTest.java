package com.inditex.prices.application.service;

import com.inditex.prices.application.domain.Price;
import com.inditex.prices.application.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

  @InjectMocks
  private PriceService priceService;

  @Mock
  private PriceRepository priceRepository;

  @Test
  public void testWhenTwoPricesThePrioritiIsRespected() {

    var price = Price.builder().price(BigDecimal.valueOf(10.5f)).build();

    when(priceRepository.findByProductIdBrandIdBetweenApplicationDate(eq(Long.valueOf(1l)),
        eq(Long.valueOf(1l)), eq(LocalDate.of(2020, 1, 1).atStartOfDay()))).thenReturn(
        Optional.of(price));

    var result = priceService.findByProductIdBrandIdBetweenApplicationDate(1l, 1l,
        LocalDate.of(2020, 1, 1).atStartOfDay());

    assertEquals(result.getPrice(), BigDecimal.valueOf(10.5f));
  }

}
