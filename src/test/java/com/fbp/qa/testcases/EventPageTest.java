package com.fbp.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fbp.qa.pages.EventPage;
import com.fbp.qa.pages.HomePage;
import com.fbp.qa.pages.LoginPage;
import com.fbp.qa.base.TestBase;

public class EventPageTest extends TestBase {

	LoginPage loginpage;
    HomePage homePage;
    EventPage eventPage;
    
	public EventPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		 loginpage = new LoginPage();
		 eventPage = new EventPage();
		 homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 eventPage = homePage.clickOnEvents();
	}
	
	@Test(priority = 1)
	public void verifyEventsPageLabel() {
		Assert.assertTrue(eventPage.verifyEventLabel(),"Contact Label is Missing on the page");
	}
	
	@Test(priority = 2)
	public void selectNotificationsTest() throws InterruptedException{
		
		eventPage.notification();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void teraDown() {
		driver.quit();
	}

}

