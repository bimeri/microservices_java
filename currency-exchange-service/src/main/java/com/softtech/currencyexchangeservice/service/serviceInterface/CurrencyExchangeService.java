    package com.softtech.currencyexchangeservice.service.serviceInterface;

    import com.softtech.currencyexchangeservice.dto.ExchangeDto;
    import com.softtech.currencyexchangeservice.entity.CurrencyEntity;

    import java.util.List;

    /**
     * Created by N.Bimeri on 17/08/2021.
     */
    public interface CurrencyExchangeService {
        List<CurrencyEntity> getAll();

       CurrencyEntity getFromValue(ExchangeDto exchangeDto);
    }
