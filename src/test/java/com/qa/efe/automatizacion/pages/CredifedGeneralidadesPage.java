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
		return  SeleniumWaiters.findElement(driver,By.xpath("//iframe[@title='"+titleIframe+"']"),20000);
	}

	public void verificar_consentimiento_digital()
	{
		List<WebElement> verificar = driver.findElements(By.xpath("//*[@id=\"div_19_1_5_2_2\"]/div[@style='display: block;']"));
		//WebElement verificar = SeleniumWaiters.findElement(driver,By.id("div_4"),10000);
		if (verificar.size()!=0) {
			System.out.println("esta abierto el cuadro");
			SeleniumWaiters.findElement(driver,By.id("button-button-informacionPersonalTitularCV:dialogConsentimiento:Button1"),10000).click();
		} 
	}
	public WebElement click_btn_guardar()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-MenuEditarCV1:buttonGuardar"),10000);
	}
	public WebElement click_btn_sobreescribir_datos()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-ModalMenuEditarGuardar:buttonAceptar"),10000);
	}
	public WebElement click_btn_continuar()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//button[text()='Continuar >>']"),10000);
	}
	public void scrollTo(WebElement element) {
		NavigationHelpers.scrollToElement(driver, element);
	}
	public WebElement pestañas_menu(String opcion)
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//button[text()='"+opcion+"']"),10000);
	}
	
}
