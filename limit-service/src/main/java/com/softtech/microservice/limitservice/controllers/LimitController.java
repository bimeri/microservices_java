package com.softtech.microservice.limitservice.controllers;

import com.softtech.microservice.limitservice.config.Configuration;
import com.softtech.microservice.limitservice.dto.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by N.Bimeri on 06/08/2021.
 */
@RestController
public class LimitController {

    @Autowired
    private Configuration configuration;
    @GetMapping(path = "/limits")
    public Limit appLimits(){
    return new Limit(configuration.getMinimum(), configuration.getMaximum());
    }
}
