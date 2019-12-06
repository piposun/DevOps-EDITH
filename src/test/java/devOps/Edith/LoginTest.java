package devOps.Edith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class LoginTest {
	
    public static void main(String[] args) { // TODO Auto-generated method stub 
	      ChromeOptions ChromeOptions = new ChromeOptions();
	      ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
    	
    	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver"); 
  WebDriver driver=new ChromeDriver(ChromeOptions);
  driver.manage().window().maximize(); 
  driver.get("http://35.240.3.128:8080/edith/signIn"); 
  
  WebElement username=driver.findElement(By.id("username")); 
  WebElement password=driver.findElement(By.id("password")); 
  
  WebElement login=driver.findElement(By.xpath("//button[text()='Sign In']")); 
  username.sendKeys("test"); password.sendKeys("test"); 
  login.click(); 
  
  String actualUrl="http://35.240.3.128:8080/edith/!test"; 
  String expectedUrl= driver.getCurrentUrl(); 
  
  if(actualUrl.equalsIgnoreCase(expectedUrl)) { 
	  System.out.println("Test passed"); }
  else { System.out.println("Test failed"); 
  } 
  }   
}