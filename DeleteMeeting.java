package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteMeeting {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://172.20.208.105:4040/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDeleteMeeting() throws Exception {
	  driver.get(baseUrl + "/tablet/#/register");	    
	  driver.findElement(By.id("service-url-input")).clear();
	  driver.findElement(By.id("service-url-input")).sendKeys("http://172.20.208.105:4040");
	  driver.findElement(By.id("username")).clear();
	  driver.findElement(By.id("username")).sendKeys("atxrm\\elver");
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("password")).sendKeys("Control123");
	  driver.findElement(By.xpath("//div[@type='submit']")).click();
	  driver.findElement(By.xpath("//div[@type='button']")).click();
	  driver.findElement(By.xpath("//section[@id='rm-account-status']/div[3]/div[2]/div/rm-select-item/div/div[2]/div/a")).click();
	  driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	  	
	  
      driver.get(baseUrl + "/tablet/#/schedule");    
      (new WebDriverWait(driver, 10))
  	  .until(
  			  ExpectedConditions.
  			  elementToBeClickable(driver.findElement(By.xpath("//div[@id='timelinePanel']/rm-vis/div/div[4]/div/div/div[2]/div/div")))
  			  );
	  driver.findElement(By.xpath("//div[@id='timelinePanel']/rm-vis/div/div[4]/div/div/div[2]/div/div")).click();
	  
	  (new WebDriverWait(driver, 5))
	  .until(
			  ExpectedConditions.
			  elementToBeClickable(driver.findElement(By.xpath("//button[contains(.,'Remove')]")))
			  );
	  driver.findElement(By.xpath("//button[contains(.,'Remove')]")).click();
	  
	  (new WebDriverWait(driver, 5))
	  .until(
			  ExpectedConditions.
			  visibilityOf(driver.findElement(By.xpath("//input[@type='password']")))
			  );
      driver.findElement(By.xpath("//input[@type='password']")).clear();
      driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Control123");
      
      (new WebDriverWait(driver, 10))
	  .until(
			  ExpectedConditions.
			  elementToBeClickable(driver.findElement(By.xpath("(//button[@type='button'])[2]")))
			  );
      driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();      
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
