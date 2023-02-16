package com.qa.efe.automatizacion.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedDashboardPage;
import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.stores.IntegracionStore;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class CredifedDashboardSteps {

	private CredifedDashboardPage credifedDashboardPage;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	private IntegracionStore integracionStore;
	
	public CredifedDashboardSteps(CredifedGeneralidadesPage credifedGeneralidadesPage,
			CredifedDashboardPage credifedDashboardPage,IntegracionStore integracionStore
			 ) {
		this.credifedDashboardPage = credifedDashboardPage;
		this.credifedGeneralidadesPage=credifedGeneralidadesPage;
		this.integracionStore=integracionStore;
	}
	
	@When("Doy click en procesos")
	public void doyClickProcesos()
	{
		credifedDashboardPage.clickProcesos().click();
		
	}
	
	@When("Ingreso instancia de proceso {string}")
	public void ingresoInstanciaProceso(String instancia)
	{
		credifedGeneralidadesPage.cambioIframe("Search Results");
		integracionStore.cuenta=instancia;
		credifedDashboardPage.ingresarProceso().sendKeys(instancia);
		credifedDashboardPage.ingresarProceso().sendKeys(Keys.ENTER);

	}
	
	@When("Doy click en pulsar para ver instancia")
	public void doyClickPulsarParaVerInstancia()
	{
		try {
			credifedDashboardPage.verInstanciaEn().click();
		}catch (Exception e) {
			credifedDashboardPage.verInstancia().click();
		}
		
	}
	
	@When("Doy click en aprobar observaciones")
	public void doyClickAprobarObservaciones() {
		//credifedDashboardPage.listVerInstancia().get(0).click();
		try {
			credifedDashboardPage.verInstanciaEn().click();
		}catch (Exception e) {
			credifedDashboardPage.verInstancia().click();
		}
	}
	@When("Doy click en pulsar para ver obs")
	public void doyClickPulsarParaVerObs()
	{
		try {
			credifedDashboardPage.verObsEn().click();
		}catch (Exception e) {
			credifedDashboardPage.verObs().click();
		}
		
	}
	@When("Valido datos de la solicitud de credito")
	public void validoDatosSolicitudCredito(DataTable seguros) {
		credifedGeneralidadesPage.iframeDefecto();
		SeleniumWaiters.waitSeconds(1);
		credifedGeneralidadesPage.cambioIframe("View Instance Details");
		List<Map<String, String>> items = seguros.asMaps(String.class, String.class);
			Map<String, String> item = items.get(0);
			System.out.println("agencia: "+item.get("agencia"));
			System.out.println("doc_titular: "+item.get("doc_titular"));
			System.out.println("linea_producto: "+item.get("linea_producto"));
			System.out.println("nro_solicitud: "+item.get("nro_solicitud"));
			String agencia = item.get("agencia");
			String doc_titular = item.get("doc_titular");
			String linea_producto = item.get("linea_producto");
			String nro_solicitud = item.get("nro_solicitud");
			try {
				credifedDashboardPage.mostrarMas().click();
			} catch (Exception e) {
				System.out.println("No hay mostrar más");
			}
			assertTrue(credifedDashboardPage.comprueboAgencia().getText().equals(agencia));
			assertTrue(credifedDashboardPage.comprueboNroDoc().getText().equals(doc_titular));
			assertTrue(credifedDashboardPage.comprueboLineaProducto().getText().equals(linea_producto));	
			assertTrue(credifedDashboardPage.comprueboNroSol().getText().equals(nro_solicitud));
	}
	
	@When("Doy click en analizar solicitud de credito")
	public void doyClickAnalizarSolicitudCredito()
	{
		try {
			credifedDashboardPage.clickAnalizarSolCreditoEn().click();
		}catch (Exception e) {
			credifedDashboardPage.clickAnalizarSolCredito().click();
		}
	}
	
	@When("Doy click en aprobacion por excepcion")
	public void doyClickAprobacionExcepcion() {
		credifedGeneralidadesPage.iframeDefecto();
		credifedGeneralidadesPage.cambioIframe("View Instance Details");
		credifedDashboardPage.aprobacionExcepcion().click();
	}
	
	@When("Doy click en aprobar solicitud de credito")
	public void doyClickAprobarSolicitudCredito()
	{
		credifedGeneralidadesPage.iframeDefecto();
        credifedGeneralidadesPage.cambioIframe("View Instance Details");
		try {
			credifedDashboardPage.clickAprobarSolCreditoEn().click();
		}catch (Exception e) {
			credifedDashboardPage.clickAprobarSolCredito().click();
		}
	}
	@When("Doy click en aprobar excepcion de credito")
	public void doyClickAprobarExcepcion()
	{
		credifedGeneralidadesPage.iframeDefecto();
        credifedGeneralidadesPage.cambioIframe("View Instance Details");
		try {
			credifedDashboardPage.clickAprobarSolCreditoEn().click();
		}catch (Exception e) {
			credifedDashboardPage.clickAprobarSolCredito().click();
		}
	}
	@When("doy click en aprobar solicitud de credito")
	public void click_aprobar_sol_credito()
	{
		credifedDashboardPage.clickAnalizarSolCredito().click();
	}
	
	@When ("Ingreso instancia de proceso anterior")
	public void ingresoInstanciaProcesoAnterior() {
		credifedGeneralidadesPage.cambioIframe("Search Results");
		credifedDashboardPage.ingresarProceso().sendKeys(integracionStore.cuenta);
		credifedDashboardPage.ingresarProceso().sendKeys(Keys.ENTER);
	}
	
	@When("Doy click en reclamar tarea")
	public void doyClickEnReclamarTarea()
	{
		if (credifedDashboardPage.validaExisteReclamarTarea().size()!=0) {
			credifedDashboardPage.clickReclamarTarea().click();
		}	
	}
	
	@When ("Ingreso instancia de proceso anterior sin observaciones")
	public void ingresoInstanciaProcesoAnteriorSinObservaciones() {
		credifedGeneralidadesPage.cambioIframe("Search Results");
		credifedDashboardPage.ingresarProceso().sendKeys(integracionStore.cuenta);
		do {
			SeleniumWaiters.waitSeconds(5);
			credifedDashboardPage.ingresarProceso().sendKeys(Keys.ENTER);
		} while (credifedDashboardPage.listVerInstancia().size()!=1);
		
	}
}
