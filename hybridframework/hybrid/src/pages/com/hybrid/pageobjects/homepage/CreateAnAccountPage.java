package com.hybrid.pageobjects.homepage;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hybrid.helper.Dropdowns.DropDownHelper;
import com.hybrid.helper.Javascript.JavaScriptHelper;
import com.hybrid.helper.Logger.LoggerHelper;
import com.hybrid.helper.waitHelper.WaitHelper;
import com.hybrid.testBase.Config;
import com.hybrid.testBase.TestBase;

public class CreateAnAccountPage {
	WebDriver driver;
	DropDownHelper ddhelp;
	private static final Logger log=LoggerHelper.getLogger(Homepage.class);
	WaitHelper waithelper;
/*-----------------------------------------------------------------------------------------------------------*/
	@FindBy(xpath="//*[@id='customer_group2']")
	public WebElement Individual;
	
	@FindBy(xpath="//*[@id='customer_group1']")
	public WebElement Company;

	@FindBy(name="firstname")
	public WebElement Enterfirstname;
	
	@FindBy(name="middlename")
	public WebElement Entermiddlename;
	
	@FindBy(name="lastname")
	public WebElement Enterlastname;
	
	@FindBy(name="email")
	public WebElement Enteremail;
	
	@FindBy(name="other_company")
	public WebElement EntercompanyRepresentative;
	
	@FindBy(name="company")
	public WebElement Entercompany;
	
	@FindBy(name="street")
	public WebElement Enterstreet;
	
	@FindBy(name="city")
	public WebElement Entercity;
	
	@FindBy(xpath="//select[@name='state']")
	public WebElement Selectstate;
	
	@FindBy(xpath="//select[@name='country']")
	public WebElement Selectcountry;
	
	@FindBy(name="postcode")
	public WebElement Enterpostcode;
	
	@FindBy(name="telephone")
	public WebElement Entertelephone;
	
	@FindBy(name="tin_number")
	public WebElement EnterGstnumber;
	
	@FindBy(name="tin_number_doc")
	public WebElement UploadGstdoc;
	
	@FindBy(name="password")
	public WebElement Enterpassword;
	
	@FindBy(name="confirmation")
	public WebElement EnterConfirmpassword;
	
	@FindBy(name="is_subscribed")
	public WebElement selectnewslettercheckbox;
	
	@FindBy(xpath="//button[@type='submit'][@title='Register']")
	public WebElement Registerbutton;
	
	@FindBy(xpath="//a[@class='back-link']")
	public WebElement Backlink;
/*-----------------------------------------------------------------------------------------------------------*/
	 public CreateAnAccountPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 waithelper=new WaitHelper(driver);
		 waithelper.waitForElement(driver,Registerbutton,new Config(TestBase.OR).getImplicitWait());
	 }
/*-----------------------------------------------------------------------------------------------------------*/
	
	 public void SelectCustomer_group1() {	
		Company.click();
	}
	 public void SelectCustomer_group2() {	
		 Individual.click();
		}
public void Enterfirstname(String Enterfirstname) {
	log.info("----Entering first name----");
	this.Enterfirstname.sendKeys(Enterfirstname);
}
public void Entermiddlename(String Entermiddlename) {
	log.info("----Entering Entermiddlename---");
	this.Entermiddlename.sendKeys(Entermiddlename);
}
public void Enterlastname(String Enterlastname) {
	log.info("----Entering Enterlastname----");
	this.Enterlastname.sendKeys(Enterlastname);
}
public void Enteremail(String Enteremail) {
	log.info("----Entering Enteremail----");
	this.Enteremail.sendKeys(Enteremail);
}
public void EntercompanyRepresentative(String companyRepresentative) {
	log.info("----Entering EntercompanyRepresentative----");
	EntercompanyRepresentative.sendKeys(companyRepresentative);
	
}
public void Entercompany(String company) {
	new JavaScriptHelper(driver).scrollIntoViewAndClick(driver.findElement(By.name("company")));
	log.info("----Entering company----");

	
	Entercompany.sendKeys(company);
}
public void Enterstreet(String Enterstreet) {
	log.info("----Entering street----");
	this.Enterstreet.sendKeys(Enterstreet);
}
public void Entercity(String Entercity) {
	log.info("----Entering rcity----");
	this.Entercity.sendKeys(Entercity);
}

public void Enterpostcode(String Enterpostcode) {
	log.info("----Entering postcode----");
	this.Enterpostcode.sendKeys(Enterpostcode);
}

public void Entertelephone(String Entertelephone) {
	log.info("----Entering telephone----");
	this.Entertelephone.sendKeys(Entertelephone);
}
public void EnterGstnumber(String Gstnumber) {
	log.info("----Entering Gstnumber----");
	EnterGstnumber.sendKeys(Gstnumber);
	new JavaScriptHelper(driver).scrollToElemetAndClick(Entercompany); 
}
public void UploadGstdoc(String uploadGstdoc) {
	log.info("----Uploading Gstdoc----");
	UploadGstdoc.sendKeys(uploadGstdoc);
}
public void Enterpassword(String Enterpassword) {
	log.info("----Entering password----");
	this.Enterpassword.sendKeys(Enterpassword);
}
public void EnterConfirmpassword(String EnterConfirmpassword) {
	log.info("----Entering Confirmpassword----");
	this.EnterConfirmpassword.sendKeys(EnterConfirmpassword);
}
public void selectnewslettercheckbox() {
	log.info("----selecting newslettercheckbox----");
	selectnewslettercheckbox.click();
}
public void Selectstate(String state) {
	Selectstate.click();
	log.info("----selecting state----");
	List<WebElement>statelist=driver.findElements(By.xpath("//select[@name='state']/option"));
	Iterator<WebElement>itr=statelist.iterator();
		while(itr.hasNext()) {
			WebElement statevalue=itr.next();
			String stateset=statevalue.getText().toString();
				if(stateset.equals(state)) {
					statevalue.click();
					System.out.println(stateset);
					break;
				}	
		}	
}
public void Selectcountry(String country) {
	Selectcountry.click();
	log.info("----Selecting country----");
	List<WebElement>countrylist=driver.findElements(By.xpath("//select[@name='country']/option"));
	Iterator<WebElement>itr=countrylist.iterator();
		while(itr.hasNext()) {
			WebElement countryvalue=itr.next();
			String stateset=countryvalue.getText().toString();
				if(stateset.equals(country)) {
					countryvalue.click();
					System.out.println(stateset);
					break;
				}	
		}	
}

public AccountdashboardPage Registerbutton(){
	log.info("----Entering Registerbutton----");
	this.Registerbutton.click();
	return new AccountdashboardPage(driver);
}
public Homepage Backlink() {
	log.info("----Entering Registerbutton----");
	this.Backlink.click();
	return new Homepage(driver);
}
/*-----------------------------------------------------------------------------------------------------------*/
public void  setregistrationdatatype1
(String Enterfirstname,String Entermiddlename,
String Enterlastname,String Enteremail,String companyRepresentative,String Enterpostcode,
String country,String Entertelephone,String Gstnumber,String uploadGstdoc, String company,
String Enterstreet,String Entercity,String state,String Enterpassword,String EnterConfirmpassword){
	SelectCustomer_group1();
	Enterfirstname(Enterfirstname);
	Entermiddlename(Entermiddlename);
	Enterlastname(Enterlastname);
	Enteremail(Enteremail);
	EntercompanyRepresentative(companyRepresentative);
	Entercompany(company);
	Enterstreet(Enterstreet);
	Entercity(Entercity);
	Enterpostcode(Enterpostcode);
	Entertelephone(Entertelephone);
	EnterGstnumber(Gstnumber);
	UploadGstdoc(uploadGstdoc);
	Enterpassword(Enterpassword);
	EnterConfirmpassword(EnterConfirmpassword);
	selectnewslettercheckbox();
	Selectstate(state);
	Selectcountry(country);
	}

public void setregistrationdatatype2
(String Enterfirstname,String Entermiddlename,
String Enterlastname,String Enteremail,String companyRepresentative,String Enterpostcode,
String country,String Entertelephone,String company,
String Enterstreet,String Entercity,String state,String Enterpassword,String EnterConfirmpassword){
	SelectCustomer_group2();
	Enterfirstname(Enterfirstname);
	Entermiddlename(Entermiddlename);
	Enterlastname(Enterlastname);
	Enteremail(Enteremail);
	EntercompanyRepresentative(companyRepresentative);
	Entercompany(company);
	Enterstreet(Enterstreet);
	Entercity(Entercity);
	Selectstate(state);
	Enterpostcode(Enterpostcode);
	Selectcountry(country);
	Entertelephone(Entertelephone);
	Enterpassword(Enterpassword);
	EnterConfirmpassword(EnterConfirmpassword);
	selectnewslettercheckbox();
	}

}
