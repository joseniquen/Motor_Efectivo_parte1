package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CotifedLineaProductoPage {
	private WebDriver driver;

	public CotifedLineaProductoPage(WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public WebElement getCategoriaLineaProducto(String lineaProducto)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//app-product-line//table/tbody/tr/div/td[contains(.,'"+lineaProducto+"')]/parent::div/parent::tr/td/select"),10);
	}
	public WebElement getOpcionCategoriaLineaProducto(String lineaProducto, String opcion)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//app-product-line//table/tbody/tr/div/td[contains(.,'"+lineaProducto+"')]/parent::div/parent::tr/td/select/option[contains(.,'"+opcion+"')]"),10);
	}
	public WebElement getLineaProducto(String lineaProducto)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//app-product-line//table/tbody/tr/div/td[contains(.,'"+lineaProducto+"')]/parent::div/parent::tr/td[2]/div/p/parent::div"),10);
	}
	public WebElement getBtnContinuar()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//button[text()='CONTINUAR']"),10);
	}
}
