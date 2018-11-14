package com.hybrid.pageobjects.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.helper.Logger.LoggerHelper;
import com.hybrid.helper.waitHelper.WaitHelper;
import com.hybrid.testBase.Config;
import com.hybrid.testBase.TestBase;

public class AccountdashboardPage {
	public WebDriver driver;
	private static final Logger log=LoggerHelper.getLogger(Homepage.class);
	WaitHelper waithelper;
	
	@FindBy(xpath="jjd")
	public WebElement tt;
	
public AccountdashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);
		waithelper.waitForElement(driver,tt,new Config(TestBase.OR).getImplicitWait());
		 }
}
