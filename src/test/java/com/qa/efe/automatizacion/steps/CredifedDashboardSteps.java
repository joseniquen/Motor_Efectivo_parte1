package com.qa.efe.automatizacion.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CredifedDashboardPage;
import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CredifedDashboardSteps {

	private CredifedDashboardPage credifedDashboardPage;
	private WebDriver driver;
	private PropertiesManager propertiesManager;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	
	public CredifedDashboardSteps(PropertiesManager propertiesManager, CredifedGeneralidadesPage credifedGeneralidadesPage,WebDriverManager driverManager, CredifedDashboardPage credifedDashboardPage
			 ) {
		this.propertiesManager = propertiesManager;
		this.driver = driverManager.getDriver();
		this.credifedDashboardPage = credifedDashboardPage;
		this.credifedGeneralidadesPage=credifedGeneralidadesPage;
	}
	@When("Doy click en procesos")
	public void doyClickProcesos()
	{
		credifedDashboardPage.click_procesos().click();
		
	}
	@When("Ingreso instancia de proceso {string}")
	public void ingresoInstanciaProceso(String instancia)
	{
		credifedGeneralidadesPage.cambioIframe("Search Results");
		credifedDashboardPage.ingresar_proceso().sendKeys(instancia);
		credifedDashboardPage.ingresar_proceso().sendKeys(Keys.ENTER);

	}
	@When("Doy click en pulsar para ver instancia")
	public void doyClickPulsarParaVerInstancia()
	{
		try {
			credifedDashboardPage.ver_instancia().click();
		}catch (Exception e) {
			credifedDashboardPage.ver_instancia_en().click();
		}
		
	}
	@When("Valido datos de la solicitud de credito")
	public void validoDatosSolicitudCredito(DataTable seguros) {
		credifedGeneralidadesPage.iframeDefecto();
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
			//credifedDashboardPage.getSeleccionTipoSeguro().click();
			try {
				credifedDashboardPage.mostrar_mas().click();
			} catch (Exception e) {
				System.out.println("No hay mostrar más");
			}
			assertTrue(credifedDashboardPage.compruebo_agencia().getText().equals(agencia));
			assertTrue(credifedDashboardPage.compruebo_nroDoc().getText().equals(doc_titular));
			assertTrue(credifedDashboardPage.compruebo_linea_producto().getText().equals(linea_producto));	
			assertTrue(credifedDashboardPage.compruebo_nro_sol().getText().equals(nro_solicitud));
	}
	@When("Doy click en analizar solicitud de credito")
	public void doyClickAnalizarSolicitudCredito()
	{
		try {
			credifedDashboardPage.click_analizar_sol_credito_en().click();
		}catch (Exception e) {
			credifedDashboardPage.click_analizar_sol_credito().click();
		}
	}
	@When("Doy click en aprobar solicitud de credito")
	public void doyClickAprobarSolicitudCredito()
	{
		credifedGeneralidadesPage.iframeDefecto();
        credifedGeneralidadesPage.cambioIframe("View Instance Details");
		try {
			credifedDashboardPage.click_aprobar_sol_credito_en().click();
		}catch (Exception e) {
			credifedDashboardPage.click_aprobar_sol_credito().click();
		}
	}
	@When("doy click en aprobar solicitud de credito")
	public void click_aprobar_sol_credito()
	{
		credifedDashboardPage.click_analizar_sol_credito().click();
	}
	@When("Doy click en reclamar tarea")
	public void doyClickEnReclamarTarea()
	{
		SeleniumWaiters.waitSeconds(8);
		if (credifedDashboardPage.valida_existe_reclamar_tarea().size()!=0) {
			credifedDashboardPage.click_reclamar_tarea().click();
		}	
	}
}
