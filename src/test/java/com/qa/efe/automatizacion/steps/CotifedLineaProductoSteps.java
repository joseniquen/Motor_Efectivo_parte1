package com.qa.efe.automatizacion.steps;

import java.io.IOException;

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
		generalidadesPage.cargarDatos();
		cotifedLineaProductoPage.getLineaProducto(lineaProducto).click();
		try {
			generalidadesPage.captura_pantalla_cotifed("target", "cotifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Selecciono check {string}")
	public void seleccionoCheck(String opcion) {
		generalidadesPage.cargarDatos();
		cotifedLineaProductoPage.getCheckOption(opcion).click();
		try {
			generalidadesPage.captura_pantalla_cotifed("target", "cotifed captura_6");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generalidadesPage.cargarDatos();
	}
	
	@When("Doy click en continuar")
	public void clickContinuar() {
		generalidadesPage.cargarDatos();
		SeleniumWaiters.waitSeconds(2);
		cotifedLineaProductoPage.getBtnContinuar().click();
		try {
			generalidadesPage.captura_pantalla_cotifed("target", "cotifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generalidadesPage.cargarDatos();
		
	}
}
