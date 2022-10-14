package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;


public class Init {
    public void main() throws InterruptedException{
        int expected_price = 270000;
        int actual_price = 0;
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\chromedriver.exe");
        String url1 = "https://www.falabella.com/falabella-cl/product/15127677/LED-65-65A6G-Android-TV-4K-SmartTV/15127677?rid=Recs%21PDP%21CL_F.com%21Rec1%21Productos_Similares%21Similares_ModeloAA_v2_Ctrl%2115041834%2115127677%212%2115";
        String url2 = "https://www.falabella.com/falabella-cl/product/15041834/LED-50-50A6G-4K-HDR-Android-Smart-TV-2020-21/15041834";
        
        List<String> listURL = new ArrayList<>();
        listURL.add(url1);
        listURL.add(url2);
        do {
            ChromeDriver driver = new ChromeDriver();
            for (String url : listURL){
                driver.get(url);
                WebElement priceData = driver.findElement(By.xpath("//span[contains(@class, 'copy12 primary medium jsx-3548557188 normal      line-height-29')]"));
            
                String priceValue = priceData.getText().toString().replace("$", "").replace(" ", "").replace(".", "");
                actual_price = Integer.parseInt(priceValue);
                System.out.println("El valor: "+actual_price + " // " + expected_price);
                driver.switchTo().newWindow(WindowType.TAB);
            }
            driver.quit();
            Thread.sleep(3000);
        }
        while(expected_price < actual_price);{
            System.out.println("COMPRA AHORA POR $ "+ actual_price);
        }














        //  WebElement textBox2 = driver.findElement(By.xpath("//li[contains(@class, 'jsx-2797633547 prices-0')]"));
        //  System.out.println(textBox2.getText());
        
        //textBox.sendKeys("Selenium");
       // textBox2.sendKeys("jajajaj wena");
      //  WebElement submitButton = driver.findElement(By.name("login"));

       // submitButton.click();

        
        
    }
}
