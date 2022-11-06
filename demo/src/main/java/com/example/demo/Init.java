package com.example.demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Init {
    public void main() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\chromedriver.exe");

        searchBuddy();
    }

    public void searchBuddy() {
      String url1 = "http://www.falabella.com/falabella-cl/category/cat1012/TV-y-Video";
      String product = "Smart TV Caixun 43 UHD 4K Android";
      String price = "184.990";
      Boolean foundIt = false;

     
      
      do {

        ChromeDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
  
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(url1);
        driver.manage().window().maximize();


        //Espera a que encuentre el elemento
        WebElement findNextPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id( "testId-pagination-bottom-arrow-right")));
       // WebElement findProduct = driver.findElement(By.xpath("//*[starts-with(@id, 'testId-pod-displaySubTitle')]"));
      //  System.out.println("XDDDDDDDDDDDDDDDDD" + findProduct);
        //WebElement findPrice = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/section[2]/div[1]/div[2]/div[1]/div/a/div[2]/div[2]/ol/li[1]/div/span"));
      
      
        List<WebElement> findProduct = driver.findElements(By.xpath("//*[starts-with(@id, 'testId-pod-displaySubTitle')]"));

        for (WebElement product_find : findProduct){
            String nameProduct =  product_find.getText().toString();
            if ( nameProduct.equals(product) ) {
                foundIt = true;
                System.out.println("Encontramos su producto!");
               // driver.quit();
            }
        }

      /* 
        //El sitio caraga mientras scrolleas, con esta funcion scroleamos hasta encontrar el elemento
        js.executeScript("arguments[0].scrollIntoView();", findNextPage);
        findNextPage.click();
          */
      } while (!foundIt);{
        //driver.quit();
        System.out.println("Encontramos su producto!");

      }

    }
    
    public void testWhatsapp() {
        String url1 = "https://web.whatsapp.com/";
        ChromeDriver driver = new ChromeDriver();
        driver.get(url1);
        WebElement findSearch = driver.findElement(By.xpath("//*[@id=\"side\"]/div[1]/div/div/div[2]/div/div[2]"));
        findSearch.click();
        findSearch.sendKeys("Rorro");   
    }
    
    private void test2() {
        int expected_price = 270000;
        int actual_price = 0;
        
        //File file = new File(getClass().getResource("chromedriver.exe").getFile());
        //file.getPath();
        
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
            //Thread.sleep(3000);
        }
        
        while(expected_price < actual_price);{
            System.out.println("COMPRA AHORA POR $ "+ actual_price);
        }  
    }
}
