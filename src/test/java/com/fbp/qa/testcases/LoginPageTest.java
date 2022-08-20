package com.fbp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fbp.qa.pages.HomePage;
import com.fbp.qa.pages.LoginPage;
import com.fbp.qa.base.TestBase;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
    HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		 loginpage = new LoginPage();
	}
	

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook - log in or sign up");
	
}
	@Test(priority = 2)
	public void fblogoImgTest() {
		boolean flag = loginpage.validateFBLogo();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority = 3)
	public void loginTest() {
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}



