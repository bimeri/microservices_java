package com.softtech.currencyexchangeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by N.Bimeri on 09/08/2021.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeDto {
    private Long id;
    private String country;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;


}
