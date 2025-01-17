package com.inditex.prices.infrastructure.rest.controller.mapper;

import com.inditex.prices.application.domain.Price;
import com.inditex.prices.infrastructure.rest.dto.PriceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDtoMapper {

    PriceDto fromDomainToDto(Price priceDomain);

}