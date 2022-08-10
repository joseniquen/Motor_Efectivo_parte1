package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

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
	public List<WebElement> getTextSesionAbierta() {
		return driver.findElements(By.xpath("//h2[contains(.,'EXCEDIO CANTIDAD SESIONES ACTIVAS')]/parent::div/parent::div[@style='display: flex;']"));
	}
	public WebElement getbtnSesionesAbiertas()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//button[text()='ACEPTAR']"),10000);
	}
}
