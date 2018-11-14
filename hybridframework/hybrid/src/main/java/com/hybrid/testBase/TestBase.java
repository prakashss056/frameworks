package com.hybrid.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.hybrid.excelreader.ExcelReader;
import com.hybrid.helper.waitHelper.WaitHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	public WebDriver driver;
	
	public FileInputStream file;
	public File f1;
	public static Properties OR;
	
	public static  ExtentReports extent;
	public  ExtentTest test;
	
	public ITestResult result;
	public ExcelReader excelreader;
	
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/
	static {
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat(":dd-MM-yyyy:HH_mm_ss");
		extent=new ExtentReports(System.getProperty("user.dir")+"/src/main/java/com/hybrid/reports/test"+ formater.format(calendar.getTime())+".html",true);
	
		}
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/
									/*OS and browser configuration*/
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/
	public void getBrowser(String browser) {
		if (System.getProperty("os.name").contains("Window")) {		
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/resource/drivers/chromedriver.exe");
					driver = new ChromeDriver();
					
				}
				else if(browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/resource/drivers/geckodriver.exe");
					driver = new FirefoxDriver();
					
				}
			}
		else if (System.getProperty("os.name").contains("Mac")) {
			System.out.println(System.getProperty("os.name"));
				if (browser.equalsIgnoreCase("chrome")) {
				System.out.println(System.getProperty("user.dir"));
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/resource/drivers/chromedriver");
					driver = new ChromeDriver();
				
				}
				else if(browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko..driver", System.getProperty("user.dir")+"/src/resource/drivers/geckodriver");
					driver = new FirefoxDriver();
					
				}
			}
		}
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/
						/*loading property file at runtime like URL,waits,browser,userName,password....etc from outside*/
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/
	public void loadpropertiesFile() throws IOException {
		OR=new Properties();
		f1=new File(System.getProperty("user.dir")+"/src/main/java/com/hybrid/config/config.properties");
		file=new FileInputStream(f1);
		OR.load(file);
		
	
		f1=new File(System.getProperty("user.dir")+"/src/main/java/com/hybrid/config/or.properties");
		file=new FileInputStream(f1);
		OR.load(file);
		
	}
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/
						/*take screenshots*/
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/	
	public String getScreenshot(String imagename) throws IOException {
		if(imagename.equals("")) {
			imagename="blank";
			}
			//At what time we got screenshot
			Calendar calendar=Calendar.getInstance();
			SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			//image location
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//where we want to store
			String imagelocation=System.getProperty("user.dir")+"/src/main/java/com/hybrid/screenshots/";
			//in which format we have to store
			String actualimage=imagelocation+src+"_"+formater.format(calendar.getTime())+".png";
			//destination file
			File dest=new File(actualimage);
			//copy file source to destination file
			FileUtils.copyFile(src, dest);
			
			return actualimage;
	}
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/	
		public void getresult(ITestResult result) throws IOException {
			
			if (result.getStatus()==ITestResult.SUCCESS) {
				test.log(LogStatus.PASS,"the test method name as :" +result.getName() +" is passed");

			} else if (result.getStatus()==ITestResult.SKIP) {
				test.log(LogStatus.SKIP,"the test method name as :" +result.getName() +" is skipped"+"reason is :-"+result.getThrowable());
			
		
			} else if (result.getStatus()==ITestResult.FAILURE) {	
				test.log(LogStatus.FAIL,"the test method name as :" +result.getName() +" is failed"+"reason is :-"+result.getThrowable());
				
				String Sreenshot=getScreenshot("");	
				test.log(LogStatus.FAIL,test.addScreenCapture(Sreenshot));
			}
				else if (result.getStatus()==ITestResult.STARTED) {
				test.log(LogStatus.INFO,"the test method name as :" +result.getName() +" is STARTED");
				}
			}	
		
		
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/
		@BeforeMethod
		public void beforemethod(Method result) {
			test=extent.startTest(result.getName());
			//String testName=result.getName();
			//test=extent.createTest(testName);
			test.log(LogStatus.INFO, result.getName()+"is strated");			
		}
		
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/			
		@BeforeTest
		public void LaunchBrowser() throws IOException {
			try{
				loadpropertiesFile();
			}catch (IOException e) {
				e.printStackTrace();
			}
	
			Config config=new Config(OR);
			getBrowser(config.getBrowser());
			WaitHelper waithelper=new WaitHelper(driver);		
			waithelper.setImplicitWait(config.getImplicitWait(), TimeUnit.SECONDS);
			waithelper.setPageLoadTimeout(config.getPageLoadTimeOut(), TimeUnit.SECONDS);
		}
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/			
		@AfterMethod
		public void aftermethod(ITestResult result) throws IOException {
			getresult(result);
}
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/			
		@AfterClass(alwaysRun= true)
		public void endTest() {
			driver.quit();	
			extent.endTest(test);
			extent.flush();	
}
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/	
		public WebElement getLocator(String Locator) throws Exception {
			String[] split=Locator.split(":");
			String Locatortype=split[0];
			String LocatorValue=split[1];
			if(Locatortype.toLowerCase().equals("id")) 
				return driver.findElement(By.id(LocatorValue));
		
			else if(Locatortype.toLowerCase().equals("name")) 
				return driver.findElement(By.name(LocatorValue));
		
			else if(Locatortype.toLowerCase().equals("classname") || (Locatortype.toLowerCase().equals("class")))
				return driver.findElement(By.className(LocatorValue));
			
			else if(Locatortype.toLowerCase().equals("tagname") || (Locatortype.toLowerCase().equals("tag")))
				return driver.findElement(By.id(LocatorValue));
		
			else if(Locatortype.toLowerCase().equals("linktext") || (Locatortype.toLowerCase().equals("link"))) 
				return driver.findElement(By.id(LocatorValue));
	
			else if(Locatortype.toLowerCase().equals("cssselector") || (Locatortype.toLowerCase().equals("cssselector")))
				return driver.findElement(By.id(LocatorValue));
		
			else if (Locatortype.toLowerCase().equals("xpath")) 
				return driver.findElement(By.id(LocatorValue));
	
			else if (Locatortype.toLowerCase().equals("partiallinktext")) 
				return driver.findElement(By.id(LocatorValue));
	
			else 
				throw new Exception("Unknown LocatorType"+Locatortype+"'");
		}
		
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/
		public List<WebElement>getLocators(String Locator) throws Exception{
			String[] split=Locator.split(":");
			String Locatortype=split[0];
			String LocatorValue=split[1];
			if(Locatortype.toLowerCase().equals("id")) 
				return driver.findElements(By.id(LocatorValue));
		
			else if(Locatortype.toLowerCase().equals("name")) 
				return driver.findElements(By.name(LocatorValue));
		
			else if(Locatortype.toLowerCase().equals("classname") || (Locatortype.toLowerCase().equals("class")))
				return driver.findElements(By.className(LocatorValue));
			
			else if(Locatortype.toLowerCase().equals("tagname") || (Locatortype.toLowerCase().equals("tag")))
				return driver.findElements(By.id(LocatorValue));
		
			else if(Locatortype.toLowerCase().equals("linktext") || (Locatortype.toLowerCase().equals("link"))) 
				return driver.findElements(By.id(LocatorValue));
	
			else if(Locatortype.toLowerCase().equals("cssselector") || (Locatortype.toLowerCase().equals("cssselector")))
				return driver.findElements(By.id(LocatorValue));
		
			else if (Locatortype.toLowerCase().equals("xpath")) 
				return driver.findElements(By.id(LocatorValue));
	
			else if (Locatortype.toLowerCase().equals("partiallinktext")) 
				return driver.findElements(By.id(LocatorValue));
	
			else 
				throw new Exception("Unknown LocatorType"+Locatortype+"'");
		}
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/
		public WebElement getWebElement(String Locator) throws Exception {
			return getLocator(OR.getProperty(Locator));
		}
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/	
		public List<WebElement> getWebElements(String Locator) throws Exception {
			return getLocators(OR.getProperty(Locator));
		}
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/

public Object[][] getData(String excelName,String sheetName){
	System.out.println(System.getProperty("user.dir"));
	String excellocation=System.getProperty("user.dir")+"/src/main/java/com/hybrid/data/"+excelName;
	System.out.println(excellocation);
	excelreader =new ExcelReader();
	return excelreader.getExcelData(excellocation,sheetName) ;	
}
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



