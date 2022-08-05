package com.qa.motor.shared.devices.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.motor.config.ConfigProperties;

public class ChromeManager implements WebDriverManager {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public ChromeManager() {
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
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, ConfigProperties.DEFAULT_TIMEOUT);
	}

	@Override
	public WebDriverWait getWait() {
		return wait;
	}
}
