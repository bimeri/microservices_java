package com.softtech.currencyconversionservice.controller;

import com.softtech.currencyconversionservice.dto.CurrencyConversionDto;
import com.softtech.currencyconversionservice.repository.CurrencyConversionProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by N.Bimeri on 09/08/2021.
 */
@RestController
public class CurrencyController {

    @Autowired
    private CurrencyConversionProxy currencyConversionProxy;

    @GetMapping(path = "currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionDto getCurrencyExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        HashMap<String, String> uriVariable = new HashMap<>();
        uriVariable.put("from", from);
        uriVariable.put("to", to);

        ResponseEntity<CurrencyConversionDto> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionDto.class, uriVariable);
        CurrencyConversionDto currencyConversion = responseEntity.getBody();
        return new CurrencyConversionDto(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversionMultiple(), quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment());
    }

    @GetMapping(path = "currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionDto getCurrencyExchangeValueFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
        CurrencyConversionDto currencyConversion = currencyConversionProxy.retrieveExchangeValue(from, to);
        return new CurrencyConversionDto(currencyConversion.getId(), from, to, quantity, currencyConversion.getConversionMultiple(), quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment() + " " + "feign");
    }
}
