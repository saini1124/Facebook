package com.fbp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fbp.qa.base.TestBase;

public class LoginPage extends TestBase{
	

	//Page Factory - OR:
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginButton;
	
	
	@FindBy(linkText = "Create new account")
	WebElement CreateNewAccount;
	
	@FindBy(xpath = "//img[@alt='Facebook']")
	WebElement FacebookLogo;
	
	//Initialize the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateFBLogo() {
		return FacebookLogo.isDisplayed();
	}
	public HomePage login(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage();
	}

}
