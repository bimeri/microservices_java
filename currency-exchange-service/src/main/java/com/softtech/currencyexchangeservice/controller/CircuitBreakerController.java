package com.softtech.currencyexchangeservice.controller;

//import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * Created by N.Bimeri on 11/08/2021.
 */
@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
//    @Retry(name = "sample-api", fallbackMethod="hardcodeResponse")
//    @CircuitBreaker(name = "sample-api", fallbackMethod="hardcodeResponse")
//    @RateLimiter(name = "sample-api")
//    @Bulkhead(name = "sample-api")
    @GetMapping(path = "/break-request")
    public String breakRequest(){
        logger.info("Request received");
        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/sample-default", String.class);
        return responseEntity.getBody();
    }

    private String hardcodeResponse(Exception ex){
        return ex.getMessage();
    }

}
