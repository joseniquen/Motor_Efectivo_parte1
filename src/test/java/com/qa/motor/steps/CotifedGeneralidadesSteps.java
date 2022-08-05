package com.qa.motor.steps;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.qa.motor.config.PropertiesManager;
import com.qa.motor.pages.CotifedGeneralidadesPage;
import com.qa.motor.shared.SeleniumWaiters;
import com.qa.motor.shared.devices.managers.WebDriverManager;

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
}