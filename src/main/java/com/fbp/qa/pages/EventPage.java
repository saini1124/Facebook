package com.fbp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fbp.qa.base.TestBase;

public class EventPage extends TestBase {

	@FindBy(linkText = "Events")
	WebElement eventLabel;
	
	@FindBy(xpath = "//a[@aria-label='Notifications']")
	WebElement notify;
	
	
	public EventPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyEventLabel() {
		return eventLabel.isDisplayed();
	}
	
	public void notification() {
		notify.click();
		
		
	}
}
 