package com.softtech.currencyexchangeservice.repository;

import com.softtech.currencyexchangeservice.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by N.Bimeri on 09/08/2021.
 */
@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {
    CurrencyEntity findByFromAndTo(String from, String to);
}
