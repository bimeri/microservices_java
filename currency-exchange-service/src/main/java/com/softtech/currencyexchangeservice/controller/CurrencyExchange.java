package com.softtech.currencyexchangeservice.controller;

import com.softtech.currencyexchangeservice.dto.ExchangeDto;
import com.softtech.currencyexchangeservice.entity.CurrencyEntity;
import com.softtech.currencyexchangeservice.repository.CurrencyRepository;
import com.softtech.currencyexchangeservice.service.serviceInterface.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by N.Bimeri on 09/08/2021.
 */
@RestController
public class CurrencyExchange {
    private CurrencyExchangeService currencyExchangeService;
    public CurrencyExchange(CurrencyExchangeService currencyExchangeService){
    this.currencyExchangeService = currencyExchangeService;
    }
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private Environment environment;

    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyEntity currencyExchanger(@PathVariable String from, @PathVariable String to){
//        ExchangeDto exchangeDto = new ExchangeDto(100L, "cam", from, to, BigDecimal.valueOf(50), "");
        String port = environment.getProperty("local.server.port");
        CurrencyEntity currencyEntity = currencyRepository.findByFromAndTo(from, to);
        if (currencyEntity == null){
            throw new RuntimeException("unable to fetch result from: "+ from +" to: "+ to);
        }
        currencyEntity.setEnvironment(port);
        return currencyEntity;
    }

    @GetMapping(path = "/currency-exchange/all")
    public List<CurrencyEntity> retrieveAll(){

        return currencyExchangeService.getAll();
    }

    @GetMapping(path = "/currency-exchange/{country}/{rate}")
    public List<ExchangeDto> findByFRomAndTo(@PathVariable String country, @PathVariable int rate){

        ExchangeDto exchangeDto = new ExchangeDto();
        exchangeDto.setCountry(country);
        exchangeDto.setConversionMultiple(BigDecimal.valueOf(rate));
        List list = new ArrayList<ExchangeDto>();
        CurrencyEntity currencyEntity = currencyExchangeService.getFromValue(exchangeDto);
        if (currencyEntity.getClass().isArray()){
            list = Arrays.asList((CurrencyEntity) currencyEntity);
        }
        else if (currencyEntity instanceof Collection) {
            list = new ArrayList<>((Collection<?>)currencyEntity);
        }
        return list;
    }
}


