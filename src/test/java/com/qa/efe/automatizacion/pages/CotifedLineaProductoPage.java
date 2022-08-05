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
	public void ConfirmarSolicitudesPendientes()
	{
		List<WebElement> solicitudes = driver.findElements(By.xpath("//*[@id='swal2-title']"));	
		if (solicitudes.size()!=0) {
			
			SeleniumWaiters.findElement(driver,By.xpath("//button[text()='OK']"),20000).click();
		}
		else {
			System.out.println("No se encontraron encontraron solicitudes pendientes");
		}	
	}
	public WebElement getCategoriaLineaProducto(String lineaProducto)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//app-product-line//table/tbody/tr/div/td[contains(.,'"+lineaProducto+"')]/parent::div/parent::tr/td/select"),20000);
	}
	public WebElement getOpcionCategoriaLineaProducto(String lineaProducto, String opcion)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//app-product-line//table/tbody/tr/div/td[contains(.,'"+lineaProducto+"')]/parent::div/parent::tr/td/select/option[contains(.,'"+opcion+"')]"),20000);
	}
	public WebElement getLineaProducto(String lineaProducto)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//app-product-line//table/tbody/tr/div/td[contains(.,'"+lineaProducto+"')]/parent::div/parent::tr/td[2]/div/p/parent::div"),20000);
	}
	public WebElement getBtnContinuar()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//button[text()='CONTINUAR']"),20000);
	}
}
