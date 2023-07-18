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
	
	@When("Verifico si existe error en consentimiento digital {int}")
	public void veriricarConsentimientoDigital(int a)
	{
		//funcion para revisar si sale algun popup de consentimiento, de domicilio, de info laboral, de malla, etc
		credifedGeneralidadesPage.verificarAlertaRoja();
		try {
			 switch (a) {
		        case 1:
					credifedGeneralidadesPage.captura_pantalla_credifed_analizar("target", "credifed captura_");
		            break;
		        case 2:
					credifedGeneralidadesPage.captura_pantalla_credifed_enviar_obs("target", "credifed captura_");
		            break;
		        case 3:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar_obs("target", "credifed captura_");
		            break;
		        default:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar("target", "credifed captura_");
		            break;
		    }		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
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
	
	@When("Verifico si existe error en filtro evaluar domicilio {int}")
	public void veriricarErrorFiltroEvaluarDomicilio(int a)
	{
		credifedGeneralidadesPage.verificarAlertaRoja();
		try {
			 switch (a) {
		        case 1:
					credifedGeneralidadesPage.captura_pantalla_credifed_analizar("target", "credifed captura_");
		            break;
		        case 2:
					credifedGeneralidadesPage.captura_pantalla_credifed_enviar_obs("target", "credifed captura_");
		            break;
		        case 3:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar_obs("target", "credifed captura_");
		            break;
		        default:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar("target", "credifed captura_");
		            break;
		    }		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Verifico si existe error en referencias telefonicas {int}")
	public void veriricoErrorReferenciasTelefonicas(int a)
	{
		credifedGeneralidadesPage.verificarErrorReferenciasTelefonicas();
		try {
			 switch (a) {
		        case 1:
					credifedGeneralidadesPage.captura_pantalla_credifed_analizar("target", "credifed captura_");
		            break;
		        case 2:
					credifedGeneralidadesPage.captura_pantalla_credifed_enviar_obs("target", "credifed captura_");
		            break;
		        case 3:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar_obs("target", "credifed captura_");
		            break;
		        default:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar("target", "credifed captura_");
		            break;
		    }		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Verifico si existe error en filtro evaluacion financiera")
	public void verificoErrorFiltroEvaluacionFinanciera()
	{
		credifedGeneralidadesPage.verificarErrorFiltroInformacionFinanciera();
	}
	
	@When("Verifico si existe error en filtro evaluar personas {int}")
	public void verificarErrorFiltroEvaluarPersonas(int a)
	{
		//funcion para revisar si sale algun popup de consentimiento, de domicilio, de info laboral, de malla, etc
		credifedGeneralidadesPage.verificarAlertaRoja();
		try {
			 switch (a) {
		        case 1:
					credifedGeneralidadesPage.captura_pantalla_credifed_analizar("target", "credifed captura_");
		            break;
		        case 2:
					credifedGeneralidadesPage.captura_pantalla_credifed_enviar_obs("target", "credifed captura_");
		            break;
		        case 3:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar_obs("target", "credifed captura_");
		            break;
		        default:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar("target", "credifed captura_");
		            break;
		    }		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@When("Doy click en guardar datos {int}")
	public void clickBtnGuardar(int a)
	{
		credifedGeneralidadesPage.clickBtnGuardar().click();
		try {
			 switch (a) {
		        case 1:
					credifedGeneralidadesPage.captura_pantalla_credifed_analizar("target", "credifed captura_");
		            break;
		        case 2:
					credifedGeneralidadesPage.captura_pantalla_credifed_enviar_obs("target", "credifed captura_");
		            break;
		        case 3:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar_obs("target", "credifed captura_");
		            break;
		        default:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar("target", "credifed captura_");
		            break;
		    }
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
			 switch (a) {
		        case 1:
					credifedGeneralidadesPage.captura_pantalla_credifed_analizar("target", "credifed captura_");
		            break;
		        case 2:
					credifedGeneralidadesPage.captura_pantalla_credifed_enviar_obs("target", "credifed captura_");
		            break;
		        case 3:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar_obs("target", "credifed captura_");
		            break;
		        default:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar("target", "credifed captura_");
		            break;
		    }
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
			 switch (a) {
		        case 1:
					credifedGeneralidadesPage.captura_pantalla_credifed_analizar("target", "credifed captura_");
		            break;
		        case 2:
					credifedGeneralidadesPage.captura_pantalla_credifed_enviar_obs("target", "credifed captura_");
		            break;
		        case 3:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar_obs("target", "credifed captura_");
		            break;
		        default:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar("target", "credifed captura_");
		            break;
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			 switch (a) {
		        case 1:
					credifedGeneralidadesPage.captura_pantalla_credifed_analizar("target", "credifed captura_");
		            break;
		        case 2:
					credifedGeneralidadesPage.captura_pantalla_credifed_enviar_obs("target", "credifed captura_");
		            break;
		        case 3:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar_obs("target", "credifed captura_");
		            break;
		        default:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar("target", "credifed captura_");
		            break;
		    }
			 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
