package com.qa.efe.automatizacion.steps;

import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CotifedLineaProductoPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CotifedLineaProductoSteps {
	private CotifedLineaProductoPage cotifedLineaProductoPage;
	private CotifedGeneralidadesPage generalidadesPage;

	public CotifedLineaProductoSteps(CotifedLineaProductoPage cotifedLineaProductoPage,
			CotifedGeneralidadesPage generalidadesPage) {
		this.cotifedLineaProductoPage = cotifedLineaProductoPage;
		this.generalidadesPage = generalidadesPage;
	}
	
	@Then("Selecciono categoria de linea de producto {string} {string}")
	public void selecciono_categoria_linea_producto(String lineaProducto, String opcion) {
		cotifedLineaProductoPage.getCategoriaLineaProducto(lineaProducto).click();
		cotifedLineaProductoPage.getOpcionCategoriaLineaProducto(lineaProducto,opcion).click();
	}
	
	@When("Selecciono linea de producto {string}")
	public void seleccionoLineaProducto(String lineaProducto) {
		cotifedLineaProductoPage.getLineaProducto(lineaProducto).click();
	}
	
	@When("Selecciono check {string}")
	public void seleccionoCheck(String opcion) {
		generalidadesPage.cargarDatos();
		cotifedLineaProductoPage.getCheckOption(opcion).click();
		generalidadesPage.cargarDatos();
	}
	
	@When("Doy click en continuar")
	public void clickContinuar() {
		generalidadesPage.cargarDatos();
		SeleniumWaiters.waitSeconds(2);
		cotifedLineaProductoPage.getBtnContinuar().click();
		generalidadesPage.cargarDatos();
	}
}
