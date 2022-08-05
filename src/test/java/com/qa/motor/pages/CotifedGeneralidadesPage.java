package com.qa.motor.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.motor.shared.SeleniumWaiters;
import com.qa.motor.shared.devices.managers.WebDriverManager;

public class CotifedGeneralidadesPage {
	private WebDriver driver;

	public CotifedGeneralidadesPage(WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public void ConfirmarAlerta()
	{
		List<WebElement> Alerta = driver.findElements(By.xpath("//*[@id='swal2-title']"));	
		if (Alerta.size()!=0) {
			
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