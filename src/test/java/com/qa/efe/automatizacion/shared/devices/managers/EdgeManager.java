package com.qa.efe.automatizacion.shared.devices.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.efe.automatizacion.config.ConfigProperties;

public class EdgeManager implements WebDriverManager {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public EdgeManager() {
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
		System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver, ConfigProperties.DEFAULT_TIMEOUT);
	}

	@Override
	public WebDriverWait getWait() {
		return wait;
	}

}
