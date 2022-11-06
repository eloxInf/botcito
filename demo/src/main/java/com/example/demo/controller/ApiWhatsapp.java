package com.example.demo.controller;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RequestSendMessageWhatsapp;
import com.example.demo.dto.ResponseSendMessage;

@RestController
public class ApiWhatsapp {
	/*
	String urlWhatsapp = "https://web.whatsapp.com/";
	final Logger logger = LoggerFactory.getLogger(cronController.class);
	ChromeDriver driver = null;
	
	private void ApiWhatsapp() {
        System.setProperty("webdriver.chrome.driver","C://chromedriver_win32//chromedriver.exe");

        driver = new ChromeDriver();
	}
	
	
	@Scheduled(fixedDelay = 10000)
	public void testSheduler() {

		
		if (driver == null) {
        System.setProperty("webdriver.chrome.driver","C://chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
		}
		
	}
	
	
	@PostMapping(value = "sendMessage")
	public ResponseSendMessage SendMessage(@RequestBody RequestSendMessageWhatsapp request) {
		ResponseSendMessage response = new ResponseSendMessage();
		
		logger.info("datos del request {0}", request);

		
		if(!IsInWhatsapp(driver)) {
			driver.get(urlWhatsapp);
		}
		
		if(!isLogin(driver)) {
			logger.info("No estoy loggeado :(");
			
			response.setCode("-1");
			response.setMessage("No estoy loggeado :(");
			return response;
		}

        
		return sendMessageToContact(request.getNameOrNumber(), request.getMessage());
		
		
	}
	

	private ResponseSendMessage sendMessageToContact(String nombre, String message) {
		
		ResponseSendMessage response = new ResponseSendMessage();
		
        WebElement findSearch = findSearchNumber(driver);
        
        if(findSearch == null) {
			response.setCode("-2");
			response.setMessage("No pude encontrar el campo de busqueda :(");
        	return response;
        }
      
        findSearch.click();
        findSearch.sendKeys(nombre);
        findSearch.sendKeys(Keys.RETURN);
        
        WebElement textMesssage = findSendText(driver);
        
        if(textMesssage == null) {
			response.setCode("-3");
			response.setMessage("No pude encontrar el campo de escritura :(");
			return response;
        }
        
        textMesssage.sendKeys(message);
        textMesssage.sendKeys(Keys.RETURN);
        
        
        findSearch.sendKeys("");
        
		response.setCode("0");
		response.setMessage("ok");
		
		return response;
	}
	
	private WebElement findSendText(ChromeDriver driver) {
			
		return findElement(driver, "//*[@id=\'main\']/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p");
	}
	
	
	private WebElement findSearchNumber(ChromeDriver driver) {
		
		
		return findElement(driver, "//*[@id=\'side\']/div[1]");
	}
	
	
	private WebElement findElement(ChromeDriver driver, String filter) {
		WebElement textMesssage = null;
		try {
			textMesssage = driver.findElement(By.xpath(filter));
		}catch(Exception e) {
			logger.info(e.getMessage());
			
		}
		
		return textMesssage;
	}

	
	
	private boolean IsInWhatsapp(ChromeDriver driver2) {
		
		logger.info("El titulo de la pagina es:" + driver2.getTitle());
		
		return (driver2.getTitle().equals("WhatsApp"));

		
	}

	private boolean isLogin(ChromeDriver driver) {
		
		return findSearchNumber(driver) !=null;
		
	}
 */
}
