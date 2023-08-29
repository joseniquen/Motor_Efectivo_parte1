package com.qa.efe.automatizacion.steps;

import java.io.IOException;
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
	
	@When("Verifico alerta de servicio {int}")
	public void veriricarConsentimientoDigital(int a)
	{
		//funcion para revisar si sale algun popup de consentimiento, de domicilio, de info laboral, de malla, etc
		credifedGeneralidadesPage.verificarAlertaRoja();
		try {
			 
			 credifedGeneralidadesPage.captura_pantalla(a);
		    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
		
	@When("Doy click en guardar datos {int}")
	public void clickBtnGuardar(int a)
	{
		credifedGeneralidadesPage.clickBtnGuardar().click();
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
			 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Acepto para sobreescribir datos originales {int}")
	public void clickBtnSobreescribirDatos(int a)
	{
		try {
			credifedGeneralidadesPage.clickBtnSobreescribirDatos().click();
		} catch (Exception e) {
			System.out.println("Pasa ok");
		}
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Doy click en boton continuar {int}")
	public void clickBtnContinuar(int a)
	{
		credifedGeneralidadesPage.clickBtnContinuar().click();
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@When("Doy click en boton cancelar")
	public void clickBtnCancelar()
	{
		credifedGeneralidadesPage.clickBtnCancelar().click();
	}
	
	@When("Me dirijo a la pestaña de {string}")
	public void dirijoPestanaMenu(String opcion)
	{
		credifedGeneralidadesPage.pestañasMenu(opcion).click();
	}
	@When("Validar que el menu de aprobar sea el inicial {int}")
	public void validarMenuInicialAprobar(int a) {
		 if(credifedGeneralidadesPage.validarMenuInicialCambiar("Resumen Solicitud")!=null) {
			 	System.out.println("Resumen Solicitud");
			 	cambioIframeDefault();
				cambioIframeNuevo("Paso: Aprobar Solicitud de Crédito");
				cambioIframeNuevo("Resumen Solicitud");
				credifedOfertaComercialSteps.clickAceptarSolicitudCredito(a);
				cambioIframeDefault();
				cambioIframeNuevo("View Instance Details");
				credifedOfertaComercialSteps.verificarSolicitudAprobada(a);
				driver.close();
			}else if(credifedGeneralidadesPage.validarMenuInicialCambiar("20 Validación Requisitos")==null) {
			 	System.out.println("validarMenuInicialCambiar");
				driver.switchTo().defaultContent();
				SeleniumWaiters.waitSeconds(1);
				credifedGeneralidadesPage.cambioIframe("Paso: Aprobar Solicitud de Crédito");
				int i = credifedGeneralidadesPage.validarMenuInicialIframe().size();
				driver.switchTo().frame(credifedGeneralidadesPage.validarMenuInicialIframe().get(i-1));
				veriricarConsentimientoDigital(a);
				SeleniumWaiters.waitSeconds(2);
			 	System.out.println("antes del click de requisitos");
				credifedGeneralidadesPage.clickMenuInicialAprobar().click();
			 	System.out.println("despues del click de requisitos");

		}
	}
	@When("Validar que el menu de exepciones sea el inicial")
	public void validarMenuInicialExepcion() {
		if(credifedGeneralidadesPage.validarMenuInicialCambiar("21 Observaciones")==null) {
		 	System.out.println("validarMenuInicialCambiar");
			driver.switchTo().defaultContent();
			SeleniumWaiters.waitSeconds(1);
			credifedGeneralidadesPage.cambioIframe("Aprobación por Excepción");
			int i = credifedGeneralidadesPage.validarMenuInicialIframe().size();
			driver.switchTo().frame(credifedGeneralidadesPage.validarMenuInicialIframe().get(i-1));
			SeleniumWaiters.waitSeconds(2);
		 	System.out.println("antes del click de requisitos");
			credifedGeneralidadesPage.clickMenuInicialExepcion().click();
		 	System.out.println("despues del click de requisitos");

		}else {
			driver.switchTo().defaultContent();
			credifedGeneralidadesPage.cambioIframe("Aprobación por Excepción");
			credifedGeneralidadesPage.cambioIframe("21 Observaciones");

		}
	}
	@When("Validar que el menu de analizar sea el inicial {int}")
	public void validarMenuInicialAnalizar(int a) {
		SeleniumWaiters.waitSeconds(5);
		if(credifedGeneralidadesPage.validarMenuInicialCambiar("07 Datos del Titular")==null) {
			driver.switchTo().defaultContent();
			SeleniumWaiters.waitSeconds(1);
			credifedGeneralidadesPage.cambioIframe("Paso: Analizar Solicitud de Crédito");
			int i = credifedGeneralidadesPage.validarMenuInicialIframe().size();
			driver.switchTo().frame(credifedGeneralidadesPage.validarMenuInicialIframe().get(i-1));
			veriricarConsentimientoDigital(a);
			credifedGeneralidadesPage.clickMenuInicialAnalizar().click();
		}
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
			 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@When("Validar que el menu de aprobar obs sea el inicial {int}")
	public void validarMenuInicialAnalizarAval(int a) {
		SeleniumWaiters.waitSeconds(5);
		if(credifedGeneralidadesPage.validarMenuInicialCambiar("21 Observaciones")==null) {
			driver.switchTo().defaultContent();
			SeleniumWaiters.waitSeconds(1);
			credifedGeneralidadesPage.cambioIframe("Paso: Aprobar Solicitud de Crédito");
			int i = credifedGeneralidadesPage.validarMenuInicialIframe().size();
			driver.switchTo().frame(credifedGeneralidadesPage.validarMenuInicialIframe().get(i-1));
			veriricarConsentimientoDigital(a);
			credifedGeneralidadesPage.clickMenuInicialExepcion().click();
		}
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
			 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@When("Validar que el menu de analizar aval sea el inicial {int}")
	public void validarMenuInicialAprobarObs(int a) {
		SeleniumWaiters.waitSeconds(5);
		if(credifedGeneralidadesPage.validarMenuInicialCambiar("15 Datos Aval")==null) {
			driver.switchTo().defaultContent();
			SeleniumWaiters.waitSeconds(1);
			credifedGeneralidadesPage.cambioIframe("Paso: Analizar Solicitud de Crédito");
			int i = credifedGeneralidadesPage.validarMenuInicialIframe().size();
			driver.switchTo().frame(credifedGeneralidadesPage.validarMenuInicialIframe().get(i-1));
			veriricarConsentimientoDigital(a);
			credifedGeneralidadesPage.clickMenuInicialAnalizarAval().click();
		}
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
			 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
