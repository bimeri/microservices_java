package com.softtech.currencyexchangeservice.service.serviceImpl;


import com.softtech.currencyexchangeservice.dto.ExchangeDto;
import com.softtech.currencyexchangeservice.entity.CurrencyEntity;
import com.softtech.currencyexchangeservice.repository.CurrencyRepository;
import com.softtech.currencyexchangeservice.service.serviceInterface.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by N.Bimeri on 17/08/2021.
 */
@Service
public class CurrencyRepositoryImpl implements CurrencyExchangeService {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public List<CurrencyEntity> getAll() {
        return currencyRepository.findAll();
    }

    @Override
    public CurrencyEntity getFromValue(ExchangeDto exchangeDto) {
        return currencyRepository.findAllByCountryAndConversionMultiple(exchangeDto.getCountry(), exchangeDto.getConversionMultiple());
    }

}
