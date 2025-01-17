package com.inditex.prices.application.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Price {

    private Integer brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priceList;

    private Integer productId;

    private Integer priority;

    private BigDecimal price;

    private String currency;

}