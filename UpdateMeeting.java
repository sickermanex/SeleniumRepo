package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UpdateMeeting {
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
  public void testUpdateMeeting() throws Exception {
    driver.get(baseUrl + "/tablet/#/schedule");
    driver.findElement(By.xpath("//div[@id='timelinePanel']/rm-vis/div/div[4]/div/div/div[2]/div/div")).click();
    driver.findElement(By.id("txtSubject")).clear();
    driver.findElement(By.id("txtSubject")).sendKeys("ola k ase mi negro");
    driver.findElement(By.xpath("//input[@type='time']")).click();
    driver.findElement(By.xpath("//input[@type='time']")).clear();
    driver.findElement(By.xpath("//input[@type='time']")).sendKeys("12:45:00.000");
    driver.findElement(By.xpath("(//input[@type='time'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@type='time'])[2]")).sendKeys("13:55:00.000");
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("elver@atxrm.com");
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//button[2]")).click();
    driver.findElement(By.xpath("//input[@type='password']")).clear();
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Control123");
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    driver.findElement(By.id("go-home")).click();
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
