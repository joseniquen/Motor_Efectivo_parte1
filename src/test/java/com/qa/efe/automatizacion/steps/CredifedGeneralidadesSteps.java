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
	@When("Cambio de iframe a {string}")
	public void cambioIframeNuevo(String titleIframe) {
		credifedGeneralidadesPage.cambioIframe(titleIframe);
	}

	@When("Cambio de iframe a default")
	public void cambioIframeDefault() {
		driver.switchTo().defaultContent();
	}
	
	@When("Verifico si existe error en consentimiento digital")
	public void veriricarConsentimientoDigital()
	{
		credifedGeneralidadesPage.verificar_consentimiento_digital();
	}
	
	@When("Verifico si existe error en normalizar direccion")
	public void verificoErrorNormalizarDireccion()
	{
		credifedGeneralidadesPage.verificar_error_normalizar_direccion();
	}
	
	@When("Verifico si existe error en ejecución de servicio")
	public void veriricarErrorEjecucionServicio()
	{
		credifedGeneralidadesPage.verificar_error_ejecutar_servicio_direccion();
	}
	
	@When("Verifico si existe error en filtro evaluar domicilio")
	public void veriricarErrorFiltroEvaluarDomicilio()
	{
		credifedGeneralidadesPage.verificar_error_ejecutar_filtro_evaluar_domicilio();
	}
	
	@When("Verifico si existe error en referencias telefonicas")
	public void veriricoErrorReferenciasTelefonicas()
	{
		credifedGeneralidadesPage.verificar_error_referencias_telefonicas();
	}
	
	@When("Verifico si existe error en filtro evaluacion financiera")
	public void verificoErrorFiltroEvaluacionFinanciera()
	{
		credifedGeneralidadesPage.verificar_error_filtro_informacion_financiera();
	}
	
	@When("Verifico si existe error en filtro evaluar personas")
	public void verificarErrorFiltroEvaluarPersonas()
	{
		credifedGeneralidadesPage.verificar_error_filtro_personas();
	}

	
	@When("Doy click en guardar datos")
	public void clickBtnGuardar()
	{
		credifedGeneralidadesPage.click_btn_guardar().click();
	}
	
	@When("Acepto para sobreescribir datos originales")
	public void clickBtnSobreescribirDatos()
	{
		try {
			credifedGeneralidadesPage.click_btn_sobreescribir_datos().click();
		} catch (Exception e) {
			System.out.println("Pasa ok");
		}
	}
	@When("Doy click en boton continuar")
	public void clickBtnContinuar()
	{
		credifedGeneralidadesPage.click_btn_continuar().click();
	}
	@When("me dirijo a la pestaña de {string}")
	public void pestañas_menu(String opcion)
	{
		credifedGeneralidadesPage.pestañas_menu(opcion).click();
	}
}
