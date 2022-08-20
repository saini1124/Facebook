package com.fbp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fbp.qa.pages.EventPage;
import com.fbp.qa.pages.HomePage;
import com.fbp.qa.pages.LoginPage;
import com.fbp.qa.base.TestBase;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
    HomePage homePage;
	EventPage eventPage;
 
    
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		 loginpage = new LoginPage();
		eventPage = new EventPage();
		 homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook - log in or sign up","Home Page Title not matched");
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	
	}
	
	@Test(priority = 3)
	public void verifyEventTest() throws InterruptedException {
		Thread.sleep(3000);
		eventPage = homePage.clickOnEvents();
		
	}
	
	
	@AfterMethod
	public void teraDown() {
		driver.quit();
	}

}
