package com.hybrid.pageobjects.homepage;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.helper.Logger.LoggerHelper;
import com.hybrid.helper.waitHelper.WaitHelper;
import com.hybrid.testBase.Config;
import com.hybrid.testBase.TestBase;

public class Homepage {
	public WebDriver driver;
	private static final Logger log=LoggerHelper.getLogger(Homepage.class);
	WaitHelper waithelper;
	
	String MyAccount="My Account";
	String MyWishlist="My Wishlist";
	String MyCart="My Cart";
	String Checkout="Checkout";
	String Register="Register";
	String LogIn="Log In";
	
	
	@FindBy(xpath="//*[text()='Browse Our Category']")
	public WebElement BrowseOurCategory;
	
	@FindBy(xpath="//span[@class='label'][text()='My Account']")
	static WebElement MyAccountheader;

 public Homepage(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	 waithelper=new WaitHelper(driver);
	 waithelper.waitForElement(driver,BrowseOurCategory,new Config(TestBase.OR).getImplicitWait());
 }
 
 public static void clickonMyaccountMenu() {
	 MyAccountheader.click();
 }
 public void selectOptionsFromMyaccountMenuInHomePage(String data) {
	 clickonMyaccountMenu();
	 driver.findElement(By.xpath("//*[@id='header-account']//*[contains(text(),'"+data+"')]")).click();
 }
 public CreateAnAccountPage clickRegisterOption(String data) {
		selectOptionsFromMyaccountMenuInHomePage(data);
		System.out.println("CreateAnAccountPage");
		return new CreateAnAccountPage(driver);
	 }
 
 
 
 /* public AccountdashboardPage clickMyAccountOption(String data) {
		selectOptionsFromMyaccountMenuInHomePage(data);
		System.out.println("AccountdashboardPage");
	 	return new AccountdashboardPage(driver);
 }
 
 public CreateAnAccountPage clickLogInOption() {
		Homepage.selectOptionsFromMyaccountMenuInHomePage();
		 return new LogInPage(driver);
	 }
public CreateAnAccountPage clickMyCartOption() {
		Homepage.selectOptionsFromMyaccountMenuInHomePage();
		 return new CreateAnAccountPage(driver);
	 }
 public CreateAnAccountPage clickCheckoutOption() {
		Homepage.selectOptionsFromMyaccountMenuInHomePage();
		 return new CreateAnAccountPage(driver);
	 }
 
 public CreateAnAccountPage clickMyWishlistOption() {
		Homepage.selectOptionsFromMyaccountMenuInHomePage();
		 return new CreateAnAccountPage(driver);
	 }*/


}
