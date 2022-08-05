package com.qa.motor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.motor.shared.SeleniumWaiters;
import com.qa.motor.shared.devices.managers.WebDriverManager;

public class CotifedFiltroPage {
	private WebDriver driver;

	public CotifedFiltroPage(WebDriverManager driverManager) {
			this.driver = driverManager.getDriver();
	}
	
	public WebElement getCbxTienda()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Tiendas*']/parent::div/select"),20000);
	}
	public WebElement getOpcionTienda(String tienda)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Tiendas*']/parent::div/select/option[contains(.,'"+tienda+"')]"),10000);
	}
	public WebElement getCbxTipoDoc()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Tipo de documento*']/parent::div/select"),20000);
	}
	
	public WebElement getOpcionTipoDoc(String tipoDoc)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Tipo de documento*']/parent::div/select/option[contains(.,'"+tipoDoc+"')]"),10000);
	}
	public WebElement getTxtEmail()
	{
		return  SeleniumWaiters.findElement(driver,By.name("email"),20000);
	}
	public WebElement getTxtNumeroDoc()
	{
		return  SeleniumWaiters.findElement(driver,By.name("numberDoc"),20000);
	}
	public WebElement getTxtNumeroCell()
	{
		return  SeleniumWaiters.findElement(driver,By.name("cell"),20000);
	}
	public WebElement getBtnFiltrar()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//button[text()='FILTRAR']"),20000);
	}
}
