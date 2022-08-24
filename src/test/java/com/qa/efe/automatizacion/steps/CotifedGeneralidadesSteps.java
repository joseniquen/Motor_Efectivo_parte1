package com.qa.efe.automatizacion.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;

public class CotifedGeneralidadesSteps {
	private CotifedGeneralidadesPage generalidadesPage;

	public CotifedGeneralidadesSteps(CotifedGeneralidadesPage generalidadesPage
			 ) {
		this.generalidadesPage = generalidadesPage;
	}
	
	@And("Confirmo alerta")
	public void confirmacionAlerta() {
		generalidadesPage.ConfirmarAlerta();
	}
	
	@When("Espero {int} segundos")
	public void esperoTiempo(int segundos) {
		SeleniumWaiters.waitSeconds(segundos);
	}
	
	@Then("Retornar al iframe por defecto")
	public void Retornar_al_iframe_por_defecto() {
		generalidadesPage.IrAIframePorDefecto();
	}	
}