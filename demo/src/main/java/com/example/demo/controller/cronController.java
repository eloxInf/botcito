package com.example.demo.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;


@Controller
public class cronController {
	ChromeDriver driver;
	String urlWhatsapp = "https://web.whatsapp.com/";
	
	final Logger logger = LoggerFactory.getLogger(cronController.class);
	
	public cronController() { 

	}
	
	@Scheduled(fixedDelay = 10000)
	public void testSheduler() {

		logger.info("Estoy corriendo y no hago nada");
		
	}
	
	
	
	
}
