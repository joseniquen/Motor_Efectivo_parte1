package com.qa.efe.automatizacion.steps;

import java.io.IOException;

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
			System.out.println("Observación "+(i+1));
		}
	}
	@When("Doy click en el boton habilitar aprobacion por excepcion")
	public void clickBtnHabilitarAprobacionExcepcion()
	{
		credifedObservacionesPage.doyClickHabilitarAprobacionExcepcion().click();
	}
	@When("Selecciono estado {string} e ingreso comentario {string}")
	public void seleccionoEstadoIngresoComentario(String estado, String comentario) {
		SeleniumWaiters.waitSeconds(3);
		credifedObservacionesPage.scrollAprobacionExcepcion();
		SeleniumWaiters.waitSeconds(3);
		credifedObservacionesPage.estadoExcepcion(estado).click();
		credifedObservacionesPage.ingresoComentario().sendKeys(comentario);
	}
	
	@When("Selecciono estado {string} e ingreso comentario aprobador {string}")
	public void seleccionoEstadoIngresoComentarioAprobador(String estado, String comentario) {
		SeleniumWaiters.waitSeconds(3);
		credifedObservacionesPage.scrollAprobacionExcepcion();
		SeleniumWaiters.waitSeconds(3);
		credifedObservacionesPage.estadoExcepcion(estado).click();
		credifedObservacionesPage.ingresoComentarioMesa().sendKeys(comentario);
	}
	
	@When("Doy click en el boton enviar aprobacion por excepcion")
	public void doyClickBotonEnviarAprobacionExcepcion() {
		credifedObservacionesPage.scrollBtnAprobacion();
		credifedObservacionesPage.enviarAprobacionExcepcion().click();
	}
	@When("Doy click en el boton responder aprobacion por excepcion {int}")
	public void doyClickBotonResponderAprobacionExcepcion(int a) {
		credifedObservacionesPage.scrollBtnResponderAprobacion();
		credifedObservacionesPage.responderAprobacionExcepcion().click();
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
	@When("Doy click en aceptar aprobacion por excepcion")
	public void doyClickAceptarAprobacionExcepcion() {
		SeleniumWaiters.waitSeconds(3);
		credifedObservacionesPage.doyClickAceptarAprobacionExcepcion().click();
	}
	@When ("Doy click en boton actualizar")
	public void doyClickBotonActualizar() {
		credifedObservacionesPage.scrollObservaciones();
		credifedObservacionesPage.doyClickBtnActualizar().click();
		SeleniumWaiters.waitSeconds(10);
	}

	@When("Tomo captura de la pagina de Obs {int} {string}")
	public void extraerAreaAprobadora(int a,String opcion) throws IOException {
		SeleniumWaiters.waitSeconds(3);
		credifedObservacionesPage.captura_pantalla("target", "Obs caso "+opcion);
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
	}
	
}
