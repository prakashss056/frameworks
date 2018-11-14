package com.hybrid.testscipts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybrid.pageobjects.homepage.AccountdashboardPage;
import com.hybrid.pageobjects.homepage.CreateAnAccountPage;
import com.hybrid.pageobjects.homepage.Homepage;
import com.hybrid.testBase.Config;
import com.hybrid.testBase.TestBase;

public class RegistrationTest extends TestBase {

	Homepage home;
	CreateAnAccountPage create;
	AccountdashboardPage dashboard;

	@DataProvider(name="readdata")
	public Object[][] datapass() {
		Object[][] data=getData("testdata.xlsx","registerdata");
		return data;
		}

	@BeforeClass
	public void homelunch() {
		driver.get(new Config(TestBase.OR).getWebsite());
		home = new Homepage(driver);		
	}

	@Test(dataProvider="readdata")
	public void getregdata(String Enterfirstname, String Entermiddlename,
			String Enterlastname, String Enteremail, String companyRepresentative, String Enterpostcode, String country,
			String Entertelephone, String Gstnumber, String uploadGstdoc, String company, String Enterstreet,
			String Entercity, String state, String Enterpassword, String EnterConfirmpassword, String runmode) {
		if (runmode.equalsIgnoreCase("n")) {
			System.out.println("for this test case runmode setted as :N");
		}
		create=home.clickRegisterOption("Register");
		create.setregistrationdatatype2(Enterfirstname,Entermiddlename,Enterlastname,Enteremail,
			companyRepresentative,company,Enterstreet,Entercity,state,Enterpostcode,country,Entertelephone,
			Enterpassword,EnterConfirmpassword);
			dashboard = create.Registerbutton();
		
	}
}
