package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CotifedFiltroPage;
import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;

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
	private CotifedGeneralidadesPage generalidadesPage;

	public CotifedOfertaComercialSteps( WebDriverManager driverManager,CotifedGeneralidadesPage generalidadesPage, CotifedOfertaComercialPage cotifedOfertaComercialPage
			 ) {
		this.driver = driverManager.getDriver();
		this.cotifedOfertaComercialPage = cotifedOfertaComercialPage;
		this.generalidadesPage=generalidadesPage;
	}
	@Then("Valido que se recupero ingreso vigente")
	public void validoIngresoVigente() {
		if(cotifedOfertaComercialPage.getValidaIngresoVigente().size()!=0) {
			cotifedOfertaComercialPage.getValidaIngresoVigenteButtonOk().click();
		}
		while(generalidadesPage.Pantalla_Carga().size() != 0) {
		}
		SeleniumWaiters.waitSeconds(2);
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
	
	@When("Valido seguros marcados")
	public void validoSegurosMarcados() {
		cotifedOfertaComercialPage.validarSegurosMarcados();
	}
	
	@When("Selecciono seguros")
	public void seleccionoSeguros(DataTable seguros) {
		List<Map<String, String>> items = seguros.asMaps(String.class, String.class);
		for (int i = 0; i < items.size(); i++) {
			Map<String, String> item = items.get(i);
			cotifedOfertaComercialPage.getSeleccionTipoSeguro(item.get("seguros")).click();
		}
	}
	
	@When("Titular selecciono estado civil {string}")
	public void titularSeleccionoEstadoCivil(String estado) {
		if (cotifedOfertaComercialPage.getCbxEstado_existe().size()!=0) {
			cotifedOfertaComercialPage.getCbxEstado().click();
			cotifedOfertaComercialPage.getOpcionEstado(estado).click();
		}
		else{
			System.out.println("Campo deshabilitado");
		}
	}
	
	@When("Titular selecciono pais {string}")
	public void titularSeleccionoPais(String pais) {
		cotifedOfertaComercialPage.getCbxPais().click();
		cotifedOfertaComercialPage.getOpcionPais(pais).click();
	}
	
	@When("Titular selecciono tipo de vivienda {string}")
	public void titularSeleccionoTipoVivienda(String tipoVivienda) {
		if (cotifedOfertaComercialPage.getCbxTipoVivienda_existe().size()!=0) {
			cotifedOfertaComercialPage.getCbxTipoVivienda().click();
			cotifedOfertaComercialPage.getOpcionTipoVivienda(tipoVivienda).click();
		}
		else{
			System.out.println("campo deshabilitado");
		}
	}
	
	@When("Titular ingreso antiguedad domicialiaria en años {string}")
	public void titularIngresoAntiguedadDomicialiariaAnios(String anios) {
		cotifedOfertaComercialPage.getTxtAntDomAnios().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtAntDomAnios().sendKeys(anios);
	}
	
	@When("Titular ingreso antiguedad domicialiaria en meses {string}")
	public void titularIngresoAntiguedadDomicialiariaMeses(String meses) {
		cotifedOfertaComercialPage.getTxtAntDomMeses().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtAntDomMeses().sendKeys(meses);
	}
	
	@When("Titular ingreso declarado {string}")
	public void titularIngresoDeclarado(String ingresoDeclarado) {	
		if (cotifedOfertaComercialPage.getTxtIngresoDeclaradoReadOnly()==null) {
			cotifedOfertaComercialPage.getTxtIngresoDeclarado().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			cotifedOfertaComercialPage.getTxtIngresoDeclarado().sendKeys(ingresoDeclarado);	
		}else if(cotifedOfertaComercialPage.getTxtIngresoDeclaradoReadOnly().equals("true")) {
			System.out.println("EL CHECK ESTÁ MARCADO");
		}
		while(generalidadesPage.Pantalla_Carga().size() != 0) {
		}
		SeleniumWaiters.waitSeconds(2);
	}
	
	@When("Titular doy check a usar ingreso declarado")
	public void titularDoyCheckUsarIngresoDeclarado() {
		if (cotifedOfertaComercialPage.getTxtIngresoDeclaradoReadOnly()==null) {
			cotifedOfertaComercialPage.getCheckIngreso().click();
		}else if(cotifedOfertaComercialPage.getTxtIngresoDeclaradoReadOnly().equals("true")) {
				System.out.println("EL CHECK ESTÁ SELECCIONADO");	
		}
		
	}
	
	@When("Titular ingreso situacion {string}")
	public void titularIngresoSituacion(String situacion) {
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
		while(generalidadesPage.Pantalla_Carga().size() != 0) {
		}
		SeleniumWaiters.waitSeconds(2);
		
	}
	
	@When("Titular ingreso ocupacion {string}")
	public void TitularIngresoOcupacion(String ocupacion) {
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
		while(generalidadesPage.Pantalla_Carga().size() != 0) {
		}
		SeleniumWaiters.waitSeconds(2);
		
	}
	
	@When("Titular ingreso antiguedad laboral en años {string}")
	public void titularIngresoAntiguedadLaboralAnios(String LabAnios) {
		cotifedOfertaComercialPage.getTxtAntLabAnios().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtAntLabAnios().sendKeys(LabAnios);
	}
	
	@When("Titular ingreso antiguedad laboral en meses {string}")
	public void titularIngresoAntiguedadLaboralMeses(String LabMeses) {
		cotifedOfertaComercialPage.getTxtAntLabMeses().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtAntLabMeses().sendKeys(LabMeses);
	}
	
	@When("Titular ingreso inicial {string}")
	public void Titular_ingreso_inicial(String inicial) {
		cotifedOfertaComercialPage.getTxtInicial().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtInicial().sendKeys(inicial);
	}
	
	@When("Titular ingreso cantidad a solicitar {string}")
	public void titularIngresoCantidadASolicitar(String cantidadASolicitar) {
		cotifedOfertaComercialPage.getTxtCantidadASolicitar().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtCantidadASolicitar().sendKeys(cantidadASolicitar);
	}
	
	@When("Titular selecciono fecha de pago {string}")
	public void Titular_fecha_pago(String fechaPago) {
		SeleniumWaiters.waitSeconds(3);
		cotifedOfertaComercialPage.getCbxFechaPago().click();
		SeleniumWaiters.waitSeconds(2);
		cotifedOfertaComercialPage.getOpcionFechaPago(fechaPago).click();
		while(generalidadesPage.Pantalla_Carga().size() != 0) {
		}
		SeleniumWaiters.waitSeconds(2);
	}
	@When("Doy click en el boton simular")
	public void doyClickBotonSimular() {
		cotifedOfertaComercialPage.getBtnSimular().click();
		while(generalidadesPage.Pantalla_Carga().size() != 0) {
		}
		SeleniumWaiters.waitSeconds(2);
	}
	
	@When("Elijo campaña {string} con plazo {string}")
	public void elijoCampaniaConPlazo(String campania,String plazo)
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
		String xpathForCreditSelection = "//table/tbody/tr/td/p[text()='"+plazo+"']/parent::td/parent::tr/td['"+columnIndex+"']/div";
		SeleniumWaiters.findElement(driver,By.xpath(xpathForCreditSelection),10).click();
		while(generalidadesPage.Pantalla_Carga().size() != 0) {
		}
		SeleniumWaiters.waitSeconds(2);
	}
	
	@When("Doy click en el boton continuar")
	public void doyClickBotonContinuar() {
		cotifedOfertaComercialPage.getBtnContinuar().click();
		while(generalidadesPage.Pantalla_Carga().size() != 0) {
		}
		SeleniumWaiters.waitSeconds(2);
	}
}
