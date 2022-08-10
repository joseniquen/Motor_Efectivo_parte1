package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CotifedFiltroPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CotifedFiltroPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



import com.qa.efe.automatizacion.pages.CotifedOfertaComercialPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Map;

public class CotifedOfertaComercialSteps {
	private CotifedOfertaComercialPage cotifedOfertaComercialPage;
	private WebDriver driver;

	public CotifedOfertaComercialSteps( WebDriverManager driverManager, CotifedOfertaComercialPage cotifedOfertaComercialPage
			 ) {
		this.driver = driverManager.getDriver();
		this.cotifedOfertaComercialPage = cotifedOfertaComercialPage;
	}
	@Then("Validar que se recupero ingreso vigente")
	public void validar_ingreso_vigente() {
		System.out.println("aca1");
		if(cotifedOfertaComercialPage.getValidaIngresoVigente().size()!=0) {
			System.out.println("aca2");
			cotifedOfertaComercialPage.getValidaIngresoVigenteButtonOk().click();
		}
	}
	@Then("Ingreso modelo de producto {string}")
	public void ingreso_modelo_producto(String modelo) {
		cotifedOfertaComercialPage.getTxtModeloProducto().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtModeloProducto().sendKeys(modelo);
	}

	@Then("seleciono coincidencia de modelo de producto")
	public void seleciono_coincidencia_modelo_producto( ){
		cotifedOfertaComercialPage.getModeloProductoSelect().click();
		SeleniumWaiters.waitSeconds(5);
	}
	
	@Then("Ingreso precio de venta de producto {string}")
	public void ingreso_precio_producto(String precio) {
		cotifedOfertaComercialPage.getTxPrecioProducto().click();
		cotifedOfertaComercialPage.getTxPrecioProducto().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxPrecioProducto().sendKeys(precio);
	}
	
	@Then("Validar seguros marcados")
	public void Validar_seguros_marcados() {
		cotifedOfertaComercialPage.validarSegurosMarcados();
	}
	
	@Then("Selecciono seguros")
	public void selecciono_seguros(DataTable seguros) {
		List<Map<String, String>> items = seguros.asMaps(String.class, String.class);
		for (int i = 0; i < items.size(); i++) {
			Map<String, String> item = items.get(i);
			System.out.println("item: "+item.get("seguros"));
			cotifedOfertaComercialPage.getSeleccionTipoSeguro(item.get("seguros")).click();
		}
	}
	
	@Then("Titular selecciono estado civil {string}")
	public void Titular_selecciono_estado_civil(String estado) {
		if (cotifedOfertaComercialPage.getCbxEstado_existe().size()!=0) {
			cotifedOfertaComercialPage.getCbxEstado().click();
			cotifedOfertaComercialPage.getOpcionEstado(estado).click();
		}
		else{
			System.out.println("campo deshabilitado");
		}
	}
	
	@Then("Titular selecciono pais {string}")
	public void Titular_selecciono_pais(String pais) {
		cotifedOfertaComercialPage.getCbxPais().click();
		cotifedOfertaComercialPage.getOpcionPais(pais).click();
	}
	
	@Then("Titular selecciono tipo de vivienda {string}")
	public void Titular_seleccionar_tipoVivienda(String tipoVivienda) {
		if (cotifedOfertaComercialPage.getCbxTipoVivienda_existe().size()!=0) {
			cotifedOfertaComercialPage.getCbxTipoVivienda().click();
			cotifedOfertaComercialPage.getOpcionTipoVivienda(tipoVivienda).click();
		}
		else{
			System.out.println("campo deshabilitado");
		}
	}
	
	@Then("Titular ingreso Ant Dom Años {string}")
	public void Titular_ingreso_Ant_Dom_Anios(String anios) {
		cotifedOfertaComercialPage.getTxtAntDomAnios().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtAntDomAnios().sendKeys(anios);
	}
	
	@Then("Titular ingreso Ant Dom Meses {string}")
	public void Titular_ingreso_Ant_Dom_meses(String meses) {
		cotifedOfertaComercialPage.getTxtAntDomMeses().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtAntDomMeses().sendKeys(meses);
	}
	
	@Then("Titular ingreso declarado {string}")
	public void Titular_ingreso_declarado(String ingresoDeclarado) {
		cotifedOfertaComercialPage.getTxtIngresoDeclarado().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtIngresoDeclarado().sendKeys(ingresoDeclarado);
	}
	
	@Then("Titular doy check a Usar Ingreso Declarado")
	public void Titular_doy_check_Usar_Ingreso_Declarado() {
		cotifedOfertaComercialPage.getCheckIngreso().click();
	}
	
	@Then("Titular ingreso situacion {string}")
	public void Titular_ingreso_situacion(String situacion) {
		if(cotifedOfertaComercialPage.getSituacion_existe().size()!=0) {
			if (cotifedOfertaComercialPage.getSituacion().isEnabled()) {
				cotifedOfertaComercialPage.getSituacion().click();
				cotifedOfertaComercialPage.getOpcionSituacion(situacion).click();
			}
			else{
				System.out.println("campo deshabilitado");
			}
		}else {
			System.out.println("campo no existe");
		}
		
	}
	
	@Then("Titular ingreso ocupacion {string}")
	public void Titular_ingreso_ocupacion(String ocupacion) {
		if(cotifedOfertaComercialPage.getOcupacion_existe().size()!=0) {
			if (cotifedOfertaComercialPage.getOcupacion().isEnabled()) {
				cotifedOfertaComercialPage.getOcupacion().click();
				cotifedOfertaComercialPage.getOpcionOcupacion(ocupacion).click();
			}
			else{
				System.out.println("campo deshabilitado");
			}
		}else {
			System.out.println("campo no existe");
		}
		
	}
	
	@Then("Titular ingreso Ant Lab Años {string}")
	public void Titular_ingreso_Ant_Lab_Anios(String LabAnios) {
		cotifedOfertaComercialPage.getTxtAntLabAnios().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtAntLabAnios().sendKeys(LabAnios);
	}
	
	@Then("Titular ingreso Ant Lab Meses {string}")
	public void Titular_ingreso_Ant_Lab_meses(String LabMeses) {
		cotifedOfertaComercialPage.getTxtAntLabMeses().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtAntLabMeses().sendKeys(LabMeses);
	}
	
	@Then("Titular ingreso inicial {string}")
	public void Titular_ingreso_inicial(String inicial) {
		cotifedOfertaComercialPage.getTxtInicial().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtInicial().sendKeys(inicial);
	}
	
	@Then("Titular ingreso cantidad a solicitar {string}")
	public void Titular_ingreso_cantidadASolicitar(String cantidadASolicitar) {
		cotifedOfertaComercialPage.getTxtCantidadASolicitar().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtCantidadASolicitar().sendKeys(cantidadASolicitar);
	}
	
	@Then("Titular fecha de pago {string}")
	public void Titular_fecha_pago(String fechaPago) {
		cotifedOfertaComercialPage.getCbxFechaPago().click();
		cotifedOfertaComercialPage.getOpcionFechaPago(fechaPago).click();
	}
	@Then("Doy click en el boton simular")
	public void Doy_click_simular() {
		cotifedOfertaComercialPage.getBtnSimular().click();
	}
	
	@When("Elijo campaña {string} con plazo {string}")
	public void elijo_campania(String campania,String plazo)
	{
		List<String> columns = cotifedOfertaComercialPage.getColumnas()
				.stream()
				.map(we -> we.getText())
				.collect(Collectors.toList());
		List<String> columnss =new ArrayList<String>();
		for (int i = 0; i < columns.size(); i++) {
		List<String> palabras =	Arrays.asList(columns.get(i).split("\\s+"));
		columnss.add(palabras.get(0));
		}
		
		int columnIndex = columnss.indexOf(campania);
		columnIndex=columnIndex+1;
		String xpathForCreditSelection = "//table/tbody/tr/td/p[text()='"+plazo+"']/parent::td/parent::tr/td["+columnIndex+"]/div";
		SeleniumWaiters.findElement(driver,By.xpath(xpathForCreditSelection),10000).click();
	}
	
	@Then("Doy click en el boton continuar")
	public void Doy_click_boton_continuar() {
		cotifedOfertaComercialPage.getBtnContinuar().click();
	}
}
