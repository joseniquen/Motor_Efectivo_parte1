package com.qa.efe.automatizacion.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.NavigationHelpers;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.Then;

public class CredifedGeneralidadesPage {
	private WebDriver driver;
	private NavigationHelpers navigationHelpers;
	public CredifedGeneralidadesPage( WebDriverManager driverManager,NavigationHelpers navigationHelpers) {
		this.driver = driverManager.getDriver();
		this.navigationHelpers = navigationHelpers;
	}
	
	public WebElement cambio_iframe(String titleIframe)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//iframe[@title='"+titleIframe+"']"),10);
	}

	public void verificar_consentimiento_digital()
	{
		List<WebElement> verificar = driver.findElements(By.xpath("//*[@id=\"div_19_1_5_2_2\"]/div[@style='display: block;']"));
		//WebElement verificar = SeleniumWaiters.findElement(driver,By.id("div_4"),10);
		if (verificar.size()!=0) {
			System.out.println("esta abierto el cuadro");
			SeleniumWaiters.findElement(driver,By.id("button-button-informacionPersonalTitularCV:dialogConsentimiento:Button1"),10).click();
		} 
	}
	
	public void verificar_error_ejecutar_servicio_direccion()
	{
		try {
			List<WebElement> verificar = driver.findElements(By.xpath("//*[@id=\"div_8_1_3_2_1\"]"));
			//WebElement verificar = SeleniumWaiters.findElement(driver,By.id("div_4"),10);
			if (verificar.size()!=0) {
				System.out.println("esta abierto el cuadro");
				SeleniumWaiters.findElement(driver,By.id("button-button-InformacionDomiciliariaCV:direccionDisplay:Button1"),10).click();
			} 
		} catch (Exception e) {
			System.out.println("No hay error en servicio dirección");
		}
		
	}
	
	public void verificar_error_normalizar_direccion()
	{
		try {
			List<WebElement> verificar = driver.findElements(By.xpath("//*[@id=\"div_5_1_3_2_1\"]"));
			//WebElement verificar = SeleniumWaiters.findElement(driver,By.id("div_4"),10);
			if (verificar.size()!=0) {
				System.out.println("esta abierto el cuadro");
				SeleniumWaiters.findElement(driver,By.id("button-button-UbicacionGeograficaCV1:direccionPrincipalDisplay:Button1"),10).click();
			} 
		} catch (Exception e) {
			System.out.println("No hay error en servicio dirección");
		}
		
	}
	
	public void verificar_error_ejecutar_filtro_evaluar_domicilio()
	{
		try {
			List<WebElement> verificar = driver.findElements(By.xpath("//*[@id=\"div_10_1_5_4_1_4_2_1\"]"));
			//WebElement verificar = SeleniumWaiters.findElement(driver,By.id("div_4"),10);
			if (verificar.size()!=0) {
				System.out.println("esta abierto el cuadro");
				SeleniumWaiters.findElement(driver,By.id("button-button-InformacionDomiciliariaCV:DisplayServiceErrorCV1:Button1"),10).click();
			} 
		} catch (Exception e) {
			System.out.println("No hay error en filtro evaluar domicilio");
		}
		
	}
	
	
	public void verificar_error_filtro_personas()
	{
		try {
			List<WebElement> verificar = driver.findElements(By.xpath("//*[@id=\"div_19_1_5_13_2_1\"]"));
			//WebElement verificar = SeleniumWaiters.findElement(driver,By.id("div_4"),10);
			if (verificar.size()!=0) {
				System.out.println("esta abierto el cuadro");
				SeleniumWaiters.findElement(driver,By.id("button-button-informacionPersonalTitularCV:displayEDP:Button1"),10).click();
			} 
		} catch (Exception e) {
			System.out.println("No hay error en filtro personas");
		}
		
	}
	
	public void verificar_error_filtro_informacion_financiera()
	{
		try {
			List<WebElement> verificar = driver.findElements(By.xpath("//*[@id=\"div_16_1_6_4_1_3_2_1\"]"));
			//WebElement verificar = SeleniumWaiters.findElement(driver,By.id("div_4"),10);
			if (verificar.size()!=0) {
				System.out.println("esta abierto el cuadro");
				SeleniumWaiters.findElement(driver,By.id("button-button-InformacionAdicionalLaboralCV2:displayFiltroFinanciero:Button1"),10).click();
			} 
		} catch (Exception e) {
			System.out.println("No hay error en filtro personas");
		}
		
	}
	
	public void verificar_error_referencias_telefonicas()
	{
		try {
			List<WebElement> verificar = driver.findElements(By.xpath("//*[@id=\"div_9_1_5_2_2_1\"]"));
			//WebElement verificar = SeleniumWaiters.findElement(driver,By.id("div_4"),10);
			if (verificar.size()!=0) {
				System.out.println("esta abierto el cuadro");
				SeleniumWaiters.findElement(driver,By.id("button-button-RegistroReferenciasCV1:minRefTelfErrorCV:Button1"),10).click();
			} 
		} catch (Exception e) {
			System.out.println("No hay error en referencias telefonicas");
		}
		
	}
	
	public WebElement click_btn_guardar()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-MenuEditarCV1:buttonGuardar"),10);
	}
	public WebElement click_btn_sobreescribir_datos()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-ModalMenuEditarGuardar:buttonAceptar"),10);
	}
	public WebElement click_btn_continuar()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//button[text()='Continuar >>']"),10);
	}
	public void scrollTo(WebElement element) {
		NavigationHelpers.scrollToElement(driver, element);
	}
	public WebElement pestañas_menu(String opcion)
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//button[text()='"+opcion+"']"),10);
	}
	
}
