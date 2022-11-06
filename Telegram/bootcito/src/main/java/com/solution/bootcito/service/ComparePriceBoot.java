package com.solution.bootcito.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComparePriceBoot {

    public String executeBoot(String url, int expected_price) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\chromedriver.exe");
        int actual_price = 0;
        do {
            ChromeDriver driver = new ChromeDriver();
  
            driver.get(url);
            WebElement priceData = driver.findElement(By.xpath("//span[contains(@class, 'copy12 primary medium jsx-3548557188 normal      line-height-29')]"));
            
            String priceValue = priceData.getText().toString().replace("$", "").replace(" ", "").replace(".", "");
            actual_price = Integer.parseInt(priceValue);

            driver.quit();
            Thread.sleep(3000);
        }
        while(expected_price < actual_price);{
            return "Compra el producto ahora!, esta a un valor de ¡¡ $" + actual_price + " !!";
        }

    }
}
