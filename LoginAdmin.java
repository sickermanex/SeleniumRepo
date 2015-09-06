package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAdmin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    baseUrl = "http://172.20.208.105:4040/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginAdmin(){
	  driver.get(baseUrl + "/admin/#/login");
	  
	  (new WebDriverWait(driver, 5))
	  .until(
			  ExpectedConditions.
			  visibilityOf(driver.findElement(By.id("loginUsername"))					  )
			  );
	  driver.findElement(By.id("loginUsername")).clear();
	  driver.findElement(By.id("loginUsername")).sendKeys("atxrm\\elver");
	  
	  (new WebDriverWait(driver, 5))
	  .until(
			  ExpectedConditions.
			  visibilityOf(driver.findElement(By.id("loginPassword"))					  )
			  );
	  driver.findElement(By.id("loginPassword")).clear();
	  driver.findElement(By.id("loginPassword")).sendKeys("Control123");
	  
	  (new WebDriverWait(driver,10))
	  .until(
			  ExpectedConditions.
			  elementToBeClickable(
					  driver.findElement(By.xpath("//button[@type='submit']")
							  ))
			  );
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  (new WebDriverWait(driver,10))
	  .until(
			  ExpectedConditions. 
			  textToBePresentInElement(driver.findElement(By.cssSelector("span.ng-binding")), 
					  "atxrm\\elver"));
	  assertEquals("atxrm\\elver", driver.findElement(By.cssSelector("span.ng-binding")).getText());
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
