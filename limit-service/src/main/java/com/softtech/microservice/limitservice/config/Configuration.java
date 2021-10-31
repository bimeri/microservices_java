package com.softtech.microservice.limitservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by N.Bimeri on 09/08/2021.
 */

@Component
@ConfigurationProperties("limit-service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Configuration {
    private int minimum;
    private int maximum;
}
