package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.WebDriver;

import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedObservacionesPage;
import com.qa.efe.automatizacion.pages.CredifedOfertaComercialPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.When;

public class CredifedObservacionesSteps {
	private WebDriver driver;
	private CredifedObservacionesPage credifedObservacionesPage;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	public CredifedObservacionesSteps(CredifedGeneralidadesPage credifedGeneralidadesPage, 
			WebDriverManager driverManager,
			CredifedObservacionesPage credifedObservacionesPage) {
		this.driver = driverManager.getDriver();
		this.credifedObservacionesPage = credifedObservacionesPage;
		this.credifedGeneralidadesPage=credifedGeneralidadesPage;
	}
	@When("Verifico que haya observaciones por edad del cliente")
	public void verificoHayaObservacionesEdadCliente()
	{
		credifedObservacionesPage.scrollObservaciones();
		int observaciones=	credifedObservacionesPage.listaObservaciones().size();
		for (int i = 0; i < observaciones; i++) {
			System.out.println("Observación "+(i+1)+" Mensaje: "+credifedObservacionesPage.getListaObservacion(i).getText());
		}
	}
	@When("Doy click en el boton habilitar aprobacion por excepcion")
	public void clickBtnHabilitarAprobacionExcepcion()
	{
		credifedObservacionesPage.doyClickHabilitarAprobacionExcepcion().click();
	}
	@When("Selecciono estado {string} e ingreso comentario {string}")
	public void seleccionoEstadoIngresoComentario(String estado, String comentario) {
		credifedObservacionesPage.scrollAprobacionExcepcion();
		credifedObservacionesPage.estadoExcepcion(estado).click();
		credifedObservacionesPage.ingresoComentario().sendKeys(comentario);
	}
	
	@When("Selecciono estado {string} e ingreso comentario aprobador {string}")
	public void seleccionoEstadoIngresoComentarioAprobador(String estado, String comentario) {
		credifedObservacionesPage.scrollAprobacionExcepcion();
		credifedObservacionesPage.estadoExcepcion(estado).click();
		credifedObservacionesPage.ingresoComentarioMesa().sendKeys(comentario);
	}
	
	@When("Doy click en el boton enviar aprobacion por excepcion")
	public void doyClickBotonEnviarAprobacionExcepcion() {
		credifedObservacionesPage.scrollBtnAprobacion();
		credifedObservacionesPage.enviarAprobacionExcepcion().click();
	}
	@When("Doy click en el boton responder aprobacion por excepcion")
	public void doyClickBotonResponderAprobacionExcepcion() {
		credifedObservacionesPage.scrollBtnResponderAprobacion();
		credifedObservacionesPage.responderAprobacionExcepcion().click();
	}
	@When("Doy click en aceptar aprobacion por excepcion")
	public void doyClickAceptarAprobacionExcepcion() {
		SeleniumWaiters.waitSeconds(3);
		credifedObservacionesPage.doyClickAceptarAprobacionExcepcion().click();
	}

	
}
