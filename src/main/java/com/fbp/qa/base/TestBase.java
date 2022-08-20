package com.fbp.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.fbp.qa.util.TestUtil;
import com.fbp.qa.util.WebEventListenerTest;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListenerTest eventListener;
	
	public TestBase() {
		
		try {
			
			prop = new Properties();
			FileInputStream ip  = new FileInputStream("C:\\SeleniumWorkSpace\\FaceBookProjectTest\\src\\main\\java\\com\\fbp\\qa\\config\\config.properties");
	       prop.load(ip);
		
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
		public static void initialization() {
			
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			        driver = new ChromeDriver();
			}else if(browserName.equals("Firefox")){
				System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
				  driver = new FirefoxDriver();
			}
			e_driver = new EventFiringWebDriver(driver);
			//Now create object of EventalistenerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListenerTest();
			e_driver.register(eventListener);
			driver = e_driver;
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}


}