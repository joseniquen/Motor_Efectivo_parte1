package com.qa.efe.automatizacion.steps;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;

import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;

import io.cucumber.java.en.When;


public class CredifedGeneralidadesSteps {
	
	private WebDriver driver;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	private CredifedOfertaComercialSteps credifedOfertaComercialSteps;
	
	public CredifedGeneralidadesSteps( WebDriverManager driverManager,CredifedGeneralidadesPage credifedGeneralidadesPage,
			CredifedOfertaComercialSteps credifedOfertaComercialSteps) {
		this.driver = driverManager.getDriver();
		this.credifedGeneralidadesPage = credifedGeneralidadesPage;
		this.credifedOfertaComercialSteps = credifedOfertaComercialSteps;
	}
	
	@When("Cambio de iframe a {string}")
	public void cambioIframeNuevo(String titleIframe) {
		SeleniumWaiters.waitSeconds(1);
		credifedGeneralidadesPage.cambioIframe(titleIframe);
	}

	@When("Cambio de iframe a default")
	public void cambioIframeDefault() {
		driver.switchTo().defaultContent();
	}
	
	@When("Verifico si existe error en consentimiento digital")
	public void veriricarConsentimientoDigital()
	{
		credifedGeneralidadesPage.verificarConsentimientoDigital();
	}
	
	@When("Verifico si existe error en normalizar direccion")
	public void verificoErrorNormalizarDireccion()
	{
		credifedGeneralidadesPage.verificarErrorNormalizarDireccion();
	}
	
	@When("Verifico si existe error en ejecución de servicio")
	public void veriricarErrorEjecucionServicio()
	{
		credifedGeneralidadesPage.verificarErrorEjecutarServicioDireccion();
	}
	
	@When("Verifico si existe error en filtro evaluar domicilio")
	public void veriricarErrorFiltroEvaluarDomicilio()
	{
		credifedGeneralidadesPage.verificarErrorEjecutarFiltroEvaluarDomicilio();
	}
	
	@When("Verifico si existe error en referencias telefonicas")
	public void veriricoErrorReferenciasTelefonicas()
	{
		credifedGeneralidadesPage.verificarErrorReferenciasTelefonicas();
	}
	
	@When("Verifico si existe error en filtro evaluacion financiera")
	public void verificoErrorFiltroEvaluacionFinanciera()
	{
		credifedGeneralidadesPage.verificarErrorFiltroInformacionFinanciera();
	}
	
	@When("Verifico si existe error en filtro evaluar personas")
	public void verificarErrorFiltroEvaluarPersonas()
	{
		credifedGeneralidadesPage.verificarErrorFiltroPersonas();
	}

	
	@When("Doy click en guardar datos")
	public void clickBtnGuardar()
	{
		credifedGeneralidadesPage.clickBtnGuardar().click();
	}
	
	@When("Acepto para sobreescribir datos originales")
	public void clickBtnSobreescribirDatos()
	{
		try {
			credifedGeneralidadesPage.clickBtnSobreescribirDatos().click();
		} catch (Exception e) {
			System.out.println("Pasa ok");
		}
	}
	
	@When("Doy click en boton continuar")
	public void clickBtnContinuar()
	{
		credifedGeneralidadesPage.clickBtnContinuar().click();
	}
	
	@When("Me dirijo a la pestaña de {string}")
	public void dirijoPestanaMenu(String opcion)
	{
		credifedGeneralidadesPage.pestañasMenu(opcion).click();
	}
	@When("Validar que el menu de aprobar sea el inicial")
	public void validarMenuInicialAprobar() {
		 if(credifedGeneralidadesPage.validarMenuInicialCambiar("Resumen Solicitud")!=null) {
			 	System.out.println("Resumen Solicitud");
			 	cambioIframeDefault();
				cambioIframeNuevo("Paso: Aprobar Solicitud de Crédito");
				cambioIframeNuevo("Resumen Solicitud");
				credifedOfertaComercialSteps.clickAceptarSolicitudCredito();
				cambioIframeDefault();
				cambioIframeNuevo("View Instance Details");
				credifedOfertaComercialSteps.verificarSolicitudAprobada();
				driver.close();
			}else if(credifedGeneralidadesPage.validarMenuInicialCambiar("07 Datos del Titular")==null) {
			 	System.out.println("validarMenuInicialCambiar");
				driver.switchTo().defaultContent();
				SeleniumWaiters.waitSeconds(1);
				credifedGeneralidadesPage.cambioIframe("Paso: Aprobar Solicitud de Crédito");
				int i = credifedGeneralidadesPage.validarMenuInicialIframe().size();
				driver.switchTo().frame(credifedGeneralidadesPage.validarMenuInicialIframe().get(i-1));
				veriricarConsentimientoDigital();
				SeleniumWaiters.waitSeconds(2);
				credifedGeneralidadesPage.clickMenuInicialAprobar().click();
		}
	}
	@When("Validar que el menu de analizar sea el inicial")
	public void validarMenuInicialAnalizar() {
		if(credifedGeneralidadesPage.validarMenuInicialCambiar("07 Datos del Titular")==null) {
			driver.switchTo().defaultContent();
			SeleniumWaiters.waitSeconds(1);
			credifedGeneralidadesPage.cambioIframe("Paso: Analizar Solicitud de Crédito");
			int i = credifedGeneralidadesPage.validarMenuInicialIframe().size();
			driver.switchTo().frame(credifedGeneralidadesPage.validarMenuInicialIframe().get(i-1));
			veriricarConsentimientoDigital();
			credifedGeneralidadesPage.clickMenuInicialAnalizar().click();
		}
	}
}
