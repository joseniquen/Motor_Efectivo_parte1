package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CotifedGeneralidadesPage {
	private WebDriver driver;

	public CotifedGeneralidadesPage(WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public void ConfirmarAlerta()
	{
		WebElement Alerta = SeleniumWaiters.findElement(driver,By.xpath("//*[@id='swal2-title']"),10000);	
		if (Alerta.isDisplayed()) {
			
			SeleniumWaiters.findElement(driver,By.xpath("//button[text()='OK']"),20000).click();
		}
		else {
			System.out.println("No se mostró alerta");
		}	
	}
	
	public void IrAIframePorDefecto()
	{
		driver.switchTo().defaultContent();
	}
}