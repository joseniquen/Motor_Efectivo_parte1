package com.qa.motor.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.motor.config.PropertiesManager;
import com.qa.motor.pages.CredifedDashboardPage;
import com.qa.motor.shared.devices.managers.WebDriverManager;

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
		credifedDashboardPage.ver_instancia().click();
	}
	@Then("validar datos de la solicitud de credito")
	public void validar_datos_solicitud(DataTable seguros) {
		List<Map<String, String>> items = seguros.asMaps(String.class, String.class);
			Map<String, String> item = items.get(0);
			System.out.println("item: "+item.get("seguros"));
			String agencia = item.get("agencia");
			String doc_titular = item.get("doc_titular");
			String linea_producto = item.get("linea_producto");
			String nro_solicitud = item.get("nro_solicitud");
			//credifedDashboardPage.getSeleccionTipoSeguro().click();
			credifedDashboardPage.mostrar_mas().click();
			credifedDashboardPage.compruebo_agencia().getText().equals(agencia);
			credifedDashboardPage.compruebo_nroDoc().getText().equals(doc_titular);
			credifedDashboardPage.compruebo_linea_producto().getText().equals(linea_producto);	
			credifedDashboardPage.compruebo_nro_sol().getText().equals(nro_solicitud);

	}
	@When("doy click en analizar solicitud de credito")
	public void click_analizar_sol_credito()
	{
		credifedDashboardPage.click_analizar_sol_credito().click();
	}
	@When("doy click en aprobar solicitud de credito")
	public void click_aprobar_sol_credito()
	{
		credifedDashboardPage.click_analizar_sol_credito().click();
	}
	@When("doy click en reclamar tarea")
	public void click_reclamar_tarea()
	{
		credifedDashboardPage.click_reclamar_tarea().click();
	}
}
