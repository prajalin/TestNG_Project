package qedge.feb22;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestNGClass {
	WebDriver driver;
  @BeforeMethod
  public void setUp() 
  {
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get("http://primusbank.qedgetech.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("txtuId")).sendKeys("Admin");
	driver.findElement(By.name("txtPword")).sendKeys("Admin");
	driver.findElement(By.name("login")).click();
	Reporter.log("running setup",true);
	 }
  @Test
  public void branches() 
  {
	  driver.findElement(By.xpath("(//img)[5]")).click();
	  Reporter.log("executing branch test case",true);
	 }
  @Test
  public void roles() 
  {
	  driver.findElement(By.xpath("(//img)[6]")).click();
	  Reporter.log("executing role test case",true);
	  
  }

 @AfterMethod
  public void tearDown() 
 {
	 Reporter.log("running tearDown",true);
	 driver.close();
	 
  }

}
