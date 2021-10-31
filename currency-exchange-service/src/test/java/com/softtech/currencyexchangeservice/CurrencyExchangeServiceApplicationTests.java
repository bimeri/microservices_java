package com.softtech.currencyexchangeservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CurrencyExchangeServiceApplicationTests {

	@Test
	void contextLoads() {
		assertEquals("5.1.10.RELEASE", SpringVersion.getVersion());
	}

}
