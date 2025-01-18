package com.inditex.prices.infrastructure.repository.mapper;

import com.inditex.prices.application.domain.Price;
import com.inditex.prices.infrastructure.repository.jpa.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

  Price fromEntityToDomain(PriceEntity priceEntity);

}
