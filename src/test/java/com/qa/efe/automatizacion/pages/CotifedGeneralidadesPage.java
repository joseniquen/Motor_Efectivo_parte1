package com.qa.efe.automatizacion.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.NavigationHelpers;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;
import com.qa.efe.automatizacion.stores.IntegracionStore;

public class CotifedGeneralidadesPage {
	private WebDriver driver;
	private IntegracionStore integracionStore;

	public CotifedGeneralidadesPage(WebDriverManager driverManager,IntegracionStore integracionStore) {
		this.driver = driverManager.getDriver();
		this.integracionStore=integracionStore;

	}
	public void ConfirmarAlerta()
	{
		try {
			SeleniumWaiters.findElement(driver,By.xpath("//*[@id='swal2-title']"),5);
			SeleniumWaiters.findElement(driver,By.xpath("//button[contains(.,'OK')]"),10).click();
			
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
	public void ClickenMenuBar()
	{
		try {
			SeleniumWaiters.findElement(driver,By.xpath("/html/body/app-root/app-modules/app-products"),10).click();
		} catch (Exception e) {
			System.out.println("No se dio click");
		}
		
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
	public void captura_pantalla_cotifed(String ruta, String nombre) throws IOException {
		//SeleniumWaiters.waitSeconds(5);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String newString1 = ruta.replace("\\", "\\\\");
		FileUtils.copyFile(scrFile, new File(newString1+"\\cotifed\\"+nombre+integracionStore.captura_incremental_cotifed+".png"));
		integracionStore.captura_incremental_cotifed = integracionStore.captura_incremental_cotifed+1;
	}
}