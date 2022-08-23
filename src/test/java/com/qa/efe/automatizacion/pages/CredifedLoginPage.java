package com.qa.efe.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedLoginPage {

	private WebDriver driver;

	public CredifedLoginPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}

	public WebElement getUsuarioBpm()
	{
		return SeleniumWaiters.findElement(driver,By.id("username"),10);
	}
	
	public WebElement gettxtContrasenaBpm ()
	{
		return SeleniumWaiters.findElement(driver,By.id("password"),10);
	}
	
	public WebElement getbtnContinuar ()
	{
		return driver.findElement(By.xpath("//span[text()='Continuar']"));
	}
	public void conexionSeguraBpm ()
	{
		driver.findElement(By.id("details-button")).click();
		SeleniumWaiters.findElement(driver, By.id("proceed-link"), 10).click();
	}
	public WebElement cerrarSesion() {
		return driver.findElement(By.xpath("//*[@id=\"div_1_2_1_1\"]/div/div/div/div[1]/a"));
	}
	public WebElement clickBtnCerrarSesion() {
		return driver.findElement(By.xpath("//a[contains(.,'Log Out')]"));
	}

	
}
