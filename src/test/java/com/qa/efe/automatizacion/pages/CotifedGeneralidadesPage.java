package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.NavigationHelpers;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CotifedGeneralidadesPage {
	private WebDriver driver;

	public CotifedGeneralidadesPage(WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public void ConfirmarAlerta()
	{
		try {
			SeleniumWaiters.findElement(driver,By.xpath("//*[@id='swal2-title']"),5);
			SeleniumWaiters.findElement(driver,By.xpath("//button[text()='OK']"),10).click();
			
		} catch (Exception e) {
			System.out.println("No se mostró alerta");
		}
		
	}
	
	public void ConfirmarAlertaSharepoint()
	{
		try {
			SeleniumWaiters.findElement(driver,By.xpath("//*[@id='swal2-title']"),5);
			SeleniumWaiters.findElement(driver,By.xpath("//button[text()='OK']"),10).click();
			
		} catch (Exception e) {
			System.out.println("No se mostró alerta");
		}
		
	}
	
	public void IrAIframePorDefecto()
	{
		driver.switchTo().defaultContent();
	}
	public List<WebElement> Pantalla_Carga()
	{
		return  driver.findElements(By.xpath("//app-loading-cot/div"));
	}
	
	public WebElement Pantalla_Carga2()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='loading'][@style='display: block;']"),10);
	}
	
	public WebElement Pantalla_Carga3()
	{
		try {
			return SeleniumWaiters.findElement(driver,By.className("modl-overlay"),2);
		} catch (Exception e) {
			return null;
		}
	}
	
	public void scrollTo(WebElement element) {
		NavigationHelpers.scrollToElement(driver, element);
	}
	
	public void cargarDatos() {
		try {
			while(Pantalla_Carga().size()!=0) {
				//System.out.println("cargarDatos");
			}
			SeleniumWaiters.waitSeconds(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void cargarDatos2() {
		try {
			while(Pantalla_Carga2().isDisplayed()) {
				//System.out.println("cargarDatos2");
			}
			SeleniumWaiters.waitSeconds(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void cargarDatos3() {
		//int j=1;
		while(Pantalla_Carga3()!=null) {
			//System.out.println("cargarDatos3: "+j);
			SeleniumWaiters.waitSeconds(1);
			//j=j+1;
		}
		//System.out.println("fuera de cargarDatos3");
		SeleniumWaiters.waitSeconds(1);
	}
	
}