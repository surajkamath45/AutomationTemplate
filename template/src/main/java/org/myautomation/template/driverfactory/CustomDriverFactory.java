package org.myautomation.template.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CustomDriverFactory {
	
	WebDriver driver;
	DesiredCapabilities caps;
	
	public CustomDriverFactory(){
		System.setProperty("webdriver.chrome.driver", "F:\\My_Workspace\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "F:\\My_Workspace\\drivers\\geckodriver.exe");
		System.setProperty("webdriver.edge.driver", "F:\\My_Workspace\\drivers\\MicrosoftWebDriver.exe");
		caps= new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setAcceptInsecureCerts(true);
	}
	
	public WebDriver getChromeDriver(){
		if(driver==null){
			driver= new ChromeDriver(new ChromeOptions().merge(caps));
		}
		return driver;
	}
	
	public WebDriver gerFirefoxDriver(){
		if(driver==null){
			driver= new FirefoxDriver(new FirefoxOptions(caps));
		}
		return driver;
	}
	
	public WebDriver getEdgeDriver(){
		if(driver==null){
			driver= new EdgeDriver(new EdgeOptions().merge(caps));
		}
		return driver;
	}

}
