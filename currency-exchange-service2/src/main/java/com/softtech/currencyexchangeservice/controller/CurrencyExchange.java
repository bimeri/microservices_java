package com.softtech.currencyexchangeservice.controller;

import com.softtech.currencyexchangeservice.dto.ExchangeDto;
import com.softtech.currencyexchangeservice.entity.CurrencyEntity;
import com.softtech.currencyexchangeservice.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by N.Bimeri on 09/08/2021.
 */
@RestController
public class CurrencyExchange {
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private Environment environment;

    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyEntity currencyExchanger(@PathVariable String from, @PathVariable String to){
        ExchangeDto exchangeDto = new ExchangeDto(100L, from, to, BigDecimal.valueOf(50), "");
        String port = environment.getProperty("local.server.port");
        CurrencyEntity currencyEntity = currencyRepository.findByFromAndTo(from, to);
        if (currencyEntity == null){
            throw new RuntimeException("unable to fetch result from: "+ from +" to: "+ to);
        }
        currencyEntity.setEnvironment(port);
        return currencyEntity;
    }
}
