package com.qa.motor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.motor.shared.devices.managers.WebDriverManager;

public class CotifedLoginPage {
	private WebDriver driver;

	public CotifedLoginPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}

	public WebElement gettxtUsuario()
	{
		return driver.findElement(By.id("email"));
	}
	
	public WebElement gettxtContrasena ()
	{
		return driver.findElement(By.id("password"));
	}
	
	public WebElement getbtnIngresar ()
	{
		return driver.findElement(By.xpath("//button[@type='submit']"));
	}
}
