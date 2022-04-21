package extentReportingDemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

public class NopCommerceTest {
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	@BeforeTest
	public void setExtent()
	{
		htmlReporter= new ExtentHtmlReporter(System.getProperty("User.dir"+"/test-output/myReport.html"));
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("TesterName", "prajalin");
		extent.setSystemInfo("Browser", "chrome");
		
	}
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","./CommonDrivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://demo.nopcommerce.com/");
	}
	@Test
	public void noCommerceTitleTest()
	{
		test= extent.createTest("noCommerceTitleTest");
		String expectedtitle="nopcommerce demo store";
		String actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		Assert.assertEquals(actualtitle, expectedtitle+"  "+"title is not matching");
	}
	@Test
	public void noCommerceLogoTest()
	{
		test=extent.createTest("noCommerceLogoTest");
		boolean status=driver.findElement(By.xpath("")).isDisplayed();
		Assert.assertTrue(status);
	}
	@Test
	public void noCommerceLoginTest()
	{
		test= extent.createTest("noCommerceLoginTest");
		test.createNode("login with valid input");
		Assert.assertTrue(true);
		test.createNode("login with invalid input");
		Assert.assertTrue(true);
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws Throwable
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//to add name of result in extent report
			test.log(Status.FAIL,"TestCase failed is"+result.getName());
			// to add error/exception in extent reports
			test.log(Status.FAIL,"TestCase failed is"+result.getTestName());
			String screenShotPath=NopCommerceTest.getScreenshot(driver,result.getName());
			test.addScreenCaptureFromPath(screenShotPath);
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,"TestCase passed is"+result.getName());
			
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP,"TestCase skipped is"+result.getName());
		}
		driver.quit();
	}
	public static String getScreenshot(WebDriver driver,String screenshotName)throws IOException
	{
		String dateName= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		//AFTER execution we can see a folder"failed TestsScreenshots" under src folder
		String destination=System.getProperty("User.dir")+"/Screenshots/"+ screenshotName+ dateName+".png";
		File finalDestination= new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
		
	}
	
	
	

}
