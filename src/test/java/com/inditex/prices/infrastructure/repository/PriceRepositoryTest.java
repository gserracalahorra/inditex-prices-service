package com.inditex.prices.infrastructure.repository;

import com.inditex.prices.application.domain.Price;
import com.inditex.prices.infrastructure.repository.jpa.PriceEntity;
import com.inditex.prices.infrastructure.repository.jpa.PriceJpaRepository;
import com.inditex.prices.infrastructure.repository.mapper.PriceEntityMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceRepositoryTest {

  @InjectMocks
  private PriceRepositoryImpl priceRepository;

  @Mock
  private PriceJpaRepository priceJpaRepository;

  @Mock
  private PriceEntityMapper priceEntityMapper;

  @Test
  public void testFindByProductIdBrandIdAndApplicationDateBetweenStartDateAndEndDateSuccess() {

    var priceEntity = PriceEntity.builder().build();

    when(
        priceJpaRepository.findByProductIdBrandIdAndApplicationDateBetweenStartDateAndEndDate(any(),
            any(), any())).thenReturn(Optional.of(priceEntity));

    when(priceEntityMapper.fromEntityToDomain(any())).thenReturn(Price.builder().build());

    var result = priceRepository.findByProductIdBrandIdBetweenApplicationDate(1l, 1l,
        LocalDate.now().atStartOfDay());

    assertTrue(result.isPresent());
  }

  @Test
  public void testFindByProductIdBrandIdAndApplicationDateBetweenStartDateAndEndDateNoRegistry() {

    when(
        priceJpaRepository.findByProductIdBrandIdAndApplicationDateBetweenStartDateAndEndDate(any(),
            any(), any())).thenReturn(Optional.empty());

    var result = priceRepository.findByProductIdBrandIdBetweenApplicationDate(1l, 1l,
        LocalDate.now().atStartOfDay());

    assertFalse(result.isPresent());
  }

}
