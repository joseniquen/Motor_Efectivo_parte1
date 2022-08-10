package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CredifedGeneralidadesSteps {
	
	private WebDriver driver;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	
	public CredifedGeneralidadesSteps( WebDriverManager driverManager,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.driver = driverManager.getDriver();
		this.credifedGeneralidadesPage = credifedGeneralidadesPage;
	}
	@Then("cambio de iframe a {string}")
	public void cambio_iframe(String titleIframe) {
		driver.switchTo().frame(credifedGeneralidadesPage.cambio_iframe(titleIframe));	
		System.out.println("cambio de inframe a default 2");
	}

	@Then("cambio de inframe a default")
	public void cambio_iframe_Default() {
		driver.switchTo().defaultContent();
		System.out.println("cambio de inframe a default");
	}
	
	@When("verifica si existe error en consentimiento digital")
	public void veriricar_consentimiento_digital()
	{
		credifedGeneralidadesPage.verificar_consentimiento_digital();
	}
	
	@When("verifica si existe error en ejecución de servicio")
	public void veriricar_error_ejecucion_servicio()
	{
		credifedGeneralidadesPage.verificar_error_ejecutar_servicio();
	}

	
	@When("doy click en guardar datos")
	public void click_btn_guardar()
	{
		credifedGeneralidadesPage.click_btn_guardar().click();
	}
	
	@When("acepto para sobreescribir datos originales")
	public void click_btn_sobreescribir_datos()
	{
		try {
			credifedGeneralidadesPage.click_btn_sobreescribir_datos().click();
		} catch (Exception e) {
			System.out.println("Pasa ok");
		}
		
	}
	@When("doy click en continuar")
	public void click_btn_continuar()
	{
		credifedGeneralidadesPage.click_btn_continuar().click();
	}
	@When("me dirijo a la pestaña de {string}")
	public void pestañas_menu(String opcion)
	{
		credifedGeneralidadesPage.pestañas_menu(opcion).click();
	}
}
