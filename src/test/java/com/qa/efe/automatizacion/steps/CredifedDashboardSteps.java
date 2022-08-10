package com.qa.efe.automatizacion.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CredifedDashboardPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CredifedDashboardSteps {

	private CredifedDashboardPage credifedDashboardPage;
	private WebDriver driver;
	private PropertiesManager propertiesManager;
	
	public CredifedDashboardSteps(PropertiesManager propertiesManager, WebDriverManager driverManager, CredifedDashboardPage credifedDashboardPage
			 ) {
		this.propertiesManager = propertiesManager;
		this.driver = driverManager.getDriver();
		this.credifedDashboardPage = credifedDashboardPage;
	}
	@When("dar click en procesos")
	public void click_procesos()
	{
		credifedDashboardPage.click_procesos().click();
		
	}
	@When("ingresar instancia de proceso {string}")
	public void ingresar_proceso(String instancia)
	{
		credifedDashboardPage.ingresar_proceso().sendKeys(instancia);
		credifedDashboardPage.ingresar_proceso().sendKeys(Keys.ENTER);

	}
	@When("dar click en pulsar para ver instancia")
	public void ver_instancia()
	{
		try {
			credifedDashboardPage.ver_instancia().click();
		}catch (Exception e) {
			credifedDashboardPage.ver_instancia_en().click();
		}
		
	}
	@Then("validar datos de la solicitud de credito")
	public void validar_datos_solicitud(DataTable seguros) {
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
			credifedDashboardPage.mostrar_mas().click();
			assertTrue(credifedDashboardPage.compruebo_agencia().getText().equals(agencia));
			System.out.println("aca1");
			assertTrue(credifedDashboardPage.compruebo_nroDoc().getText().equals(doc_titular));
			System.out.println("aca2");

			assertTrue(credifedDashboardPage.compruebo_linea_producto().getText().equals(linea_producto));	
			System.out.println("aca3");

			assertTrue(credifedDashboardPage.compruebo_nro_sol().getText().equals(nro_solicitud));
			System.out.println("aca4");

	}
	@When("doy click en analizar solicitud de credito")
	public void click_analizar_sol_credito()
	{
		try {
			credifedDashboardPage.click_analizar_sol_credito().click();
		}catch (Exception e) {
			credifedDashboardPage.click_analizar_sol_credito_en().click();
		}
	}
	@When("doy click en aprobar solicitud de credito")
	public void click_aprobar_sol_credito()
	{
		credifedDashboardPage.click_analizar_sol_credito().click();
	}
	@When("doy click en reclamar tarea")
	public void click_reclamar_tarea()
	{
		SeleniumWaiters.waitSeconds(8);
		if (credifedDashboardPage.valida_existe_reclamar_tarea().size()!=0) {
			System.out.println("existe el reclamar tarea");
			credifedDashboardPage.click_reclamar_tarea().click();
		}	
	}
}
