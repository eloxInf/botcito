package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		WebDriverManager.chromedriver().setup();
	}

}
