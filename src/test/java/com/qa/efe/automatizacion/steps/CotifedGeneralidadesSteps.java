package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CotifedGeneralidadesSteps {
	private CotifedGeneralidadesPage generalidadesPage;
	private WebDriver driver;
	private PropertiesManager propertiesManager;

	public CotifedGeneralidadesSteps(PropertiesManager propertiesManager, WebDriverManager driverManager, CotifedGeneralidadesPage generalidadesPage
			 ) {
		this.propertiesManager = propertiesManager;
		this.driver = driverManager.getDriver();
		this.generalidadesPage = generalidadesPage;
	}
	
	@Then("Confirmacion de alerta")
	public void Confirmacion_alerta() {
		generalidadesPage.ConfirmarAlerta();
	}
	
	@When("esperar {int} segundos")
	public void tiempoMuerto(int segundos) {
		SeleniumWaiters.waitSeconds(segundos);
	}
	
	@Then("Retornar al iframe por defecto")
	public void Retornar_al_iframe_por_defecto() {
		generalidadesPage.IrAIframePorDefecto();
	}
	@Then("Cargando datos espere...")
	public void pantalla_carga() {
		
		while(generalidadesPage.Pantalla_Carga().size() != 0) {
		}
		SeleniumWaiters.waitSeconds(2);
	}
	
}