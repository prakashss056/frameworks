package com.datadriven.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;
	public FileInputStream file;
	public File f1;
	public Properties OR;
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/
	public void getBrowser(String browser) {
		if (System.getProperty("os.name").contains("Window")) {
			
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resource/drivers/chromedriver.exe");
					driver = new ChromeDriver();
				}
				else if(browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resource/drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				}
			}
		else if (System.getProperty("os.name").contains("Mac")) {
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resource/drivers/chromedriver");
					driver = new ChromeDriver();
				}
				else if(browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko..driver", System.getProperty("user.dir")+"/src/main/resource/drivers/geckodriver");
					driver = new FirefoxDriver();
				}
			}
		}
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/
	public void loadpropertiesFile() throws IOException {
		OR=new Properties();
		f1=new File(System.getProperty("user.dir")+"/src/main/resource/property configuration/config.properties");
		file=new FileInputStream(f1);
		OR.load(file);
		
	
		f1=new File(System.getProperty("user.dir")+"/src/main/resource/property configuration/or.properties");
		file=new FileInputStream(f1);
		OR.load(file);
	}
/*---------------------------------------------------------------------------------------------------------------------------------------------------*/

}


