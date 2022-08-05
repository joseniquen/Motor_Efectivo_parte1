package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.WebDriver;

import com.qa.efe.automatizacion.pages.CotifedLineaProductoPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.Then;

public class CotifedLineaProductoSteps {
	private WebDriver driver;
	private CotifedLineaProductoPage cotifedLineaProductoPage;
	public CotifedLineaProductoSteps(WebDriverManager driverManager,CotifedLineaProductoPage cotifedLineaProductoPage) {
		this.driver = driverManager.getDriver();
		this.cotifedLineaProductoPage = cotifedLineaProductoPage;
	}
	
	@Then("Selecciono categoria de linea de producto {string} {string}")
	public void selecciono_categoria_linea_producto(String lineaProducto, String opcion) {
		cotifedLineaProductoPage.getCategoriaLineaProducto(lineaProducto).click();
		cotifedLineaProductoPage.getOpcionCategoriaLineaProducto(lineaProducto,opcion).click();
	}
	
	@Then("selecciono linea de producto {string}")
	public void selecciono_Linea_Producto(String lineaProducto) {
		cotifedLineaProductoPage.getLineaProducto(lineaProducto).click();
		//SeleniumWaiters.waitSeconds(10);
	}
	@Then("dar click en Continuar")
	public void click_filtrar() {
		cotifedLineaProductoPage.getBtnContinuar().click();
	}
}
