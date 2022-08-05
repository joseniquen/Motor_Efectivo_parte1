package com.qa.motor.shared.devices.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.motor.config.ConfigProperties;

public class FirefoxManager implements WebDriverManager {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public FirefoxManager() {
		this.setupManager();
	}
	
	@Override
	public WebDriver getDriver() {
		return driver;
	}

	@Override
	public void setDriver(WebDriver driver) {
		this.driver = driver;
		
	}

	@Override
	public void setupManager() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, ConfigProperties.DEFAULT_TIMEOUT);
	}

	@Override
	public WebDriverWait getWait() {
		return wait;
	}
}
