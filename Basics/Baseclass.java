package testng.Basics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Baseclass {
	WebDriver driver;
	SoftAssert softassert;
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest logger;
	
	/*-------------------------------------------------------------------------------------------------------------------------*/
	@BeforeClass
	public void setup() {
		reporter = new ExtentHtmlReporter(System.getProperty("./basicsprojectReports/myreports.html"));
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		softassert = new SoftAssert();
		System.out.println("before class report section configuration is correctly executed");
		
		System.setProperty("webdriver.chrome.driver", "/Users/prakash/Desktop/eclipse-workspace/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		System.out.println("before class configuration executed");
	}

	/*-------------------------------------------------------------------------------------------------------------------------*/
	@BeforeMethod
	public void launchng() {
		
		driver.get("https://www.makemytrip.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("before method executed");
	}

	/*-------------------------------------------------------------------------------------------------------------------------*/
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {
			String temp = Utility.captureScreenshot(driver, result.getName());
			logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} 
	
		/*		else if (ITestResult.SUCCESS == result.getStatus()) {
			String temp = Utility.captureScreenshot(driver, result.getName());
			logger.pass(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} 
		else {
			String temp = Utility.captureScreenshot(driver, result.getName());
			logger.skip(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}*/
		
		driver.close();
		extent.flush();
		System.out.println("After method executed");
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------*/
	@AfterClass
	public void lastprocess() {
		
		driver.quit();
		System.out.println("after class executed");
	}
}
