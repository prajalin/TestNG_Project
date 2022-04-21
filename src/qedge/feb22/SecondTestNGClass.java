package qedge.feb22;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTestNGClass {
	WebDriver driver;
	@BeforeTest
	public void setUp()throws Throwable
	{
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://calc.qedgetech.com/");
		Thread.sleep(3000);
		Reporter.log("running setUp",true);
	}
	@Test
	public void addition()throws Throwable
	{
		driver.findElement(By.xpath("//input[@value='C']")).click();
		driver.findElement(By.name("display")).sendKeys("768943");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='+']")).click();
		driver.findElement(By.name("display")).sendKeys("7358");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='=']")).click();
		Thread.sleep(3000);
		String additionres = driver.findElement(By.name("display")).getAttribute("value");
		Reporter.log("executing addition test",true);
		Reporter.log("addition result::"+additionres,true);
		
		
	}
	@Test
	public void multiplication()throws Throwable
	{
	  driver.findElement(By.xpath("//input[@value='C']")).click();
	  driver.findElement(By.name("display")).sendKeys("768234943");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("(//input[@id='btn'])[16]")).click();
	  driver.findElement(By.name("display")).sendKeys("456");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@value='=']")).click();
	  Thread.sleep(3000);
	  String mulres = driver.findElement(By.name("display")).getAttribute("value");
	  Reporter.log("executing multiplication test",true);
	  Reporter.log("multiplication result::"+mulres,true);
	  
	  }
	@Test
	public void division()throws Throwable
	{
		driver.findElement(By.xpath("//input[@value='C']")).click();
		driver.findElement(By.name("display")).sendKeys("768234943");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='/']")).click();
		driver.findElement(By.name("display")).sendKeys("768");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='=']")).click();
		Thread.sleep(3000);
		String divres = driver.findElement(By.name("display")).getAttribute("value");
		  Reporter.log("executing division test",true);
		  Reporter.log("division result::"+divres,true);
		  
		}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		Reporter.log("running tearDown",true);
		
	}
	
	
}
