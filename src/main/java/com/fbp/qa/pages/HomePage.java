package com.fbp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fbp.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(linkText= "Hardeep Singh")
	WebElement userNameLabel;
	
	@FindBy(xpath= "//a[@aria-label='Marketplace']")
	WebElement marketPlace;
	
	@FindBy(xpath= "//a[@aria-label='Groups']")
	WebElement groups;

	@FindBy(linkText= "Events")
	@CacheLookup
	WebElement events;
	
	@FindBy(linkText= "Watch")
	WebElement watch;
	
	@FindBy(xpath= "//span[contains(text(),\"What's on your mind, Kapil?\")]")
	WebElement status;
	
	@FindBy(xpath= "//div[@role='textbox']")
	WebElement newstatus;
	
	@FindBy(xpath="//a[@aria-label='Facebook']")
	WebElement fb;
	
	@FindBy(xpath="//div[@class='notranslate _5rpu']")
	WebElement update;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String  validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public EventPage clickOnEvents() {
		events.click();
		return new EventPage();
	
	}
	
	public GroupPage clickOnGroups() {
		groups.click();
		return new GroupPage();
	}
}

