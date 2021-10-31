package com.softtech.currencyconversionservice.repository;
        import com.softtech.currencyconversionservice.dto.CurrencyConversionDto;
        import org.springframework.cloud.openfeign.FeignClient;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange", url = "http://localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyConversionProxy {

    @GetMapping(path = "currency-exchange/from/{from}/to/{to}")
    CurrencyConversionDto retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
