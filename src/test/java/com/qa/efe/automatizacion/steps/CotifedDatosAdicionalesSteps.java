package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CotifedDatosAdicionalesPage;
import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CotifedDatosAdicionalesSteps {
	private CotifedDatosAdicionalesPage cotifedDatosAdicionalesPage;
	private CotifedGeneralidadesPage cotifedGeneralidadesPage;
	private WebDriver driver;

	public CotifedDatosAdicionalesSteps( WebDriverManager driverManager, CotifedDatosAdicionalesPage cotifedDatosAdicionalesPage, CotifedGeneralidadesPage cotifedGeneralidadesPage
			 ) {
		this.driver = driverManager.getDriver();
		this.cotifedDatosAdicionalesPage = cotifedDatosAdicionalesPage;
		this.cotifedGeneralidadesPage=cotifedGeneralidadesPage;
	}
	
	@Then("Doy click en el boton continuar datos adicionales")
	public void Doy_click_boton_continuar_datos_adicionales() {
		cotifedDatosAdicionalesPage.getBtnContinuarDatosAdicionales().click();
	}
	
	@Then("Ingreso correo de datos principales {string}")
	public void Ingreso_correo_persona(String correo) {
		cotifedDatosAdicionalesPage.getTxtCorreoPersona().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtCorreoPersona().sendKeys(correo);
	}
	
	@Then("Ingreso numero de celular de datos principales {string}")
	public void Ingreso_numero_celular_persona(String celular) {
		cotifedDatosAdicionalesPage.getTxtCelularPersona().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtCelularPersona().sendKeys(celular);
	}
	
	@Then("Selecciono prefijo de datos principales {string}")
	public void Selecciono_prefijo_persona(String prefijo) {
		cotifedDatosAdicionalesPage.getCbxPrefijoPersona().click();
		cotifedDatosAdicionalesPage.getOpcionCbxPrefijoPersona(prefijo).click();
	}
	
	@Then("Ingreso numero de telefono fijo de datos principales {string}")
	public void Ingreso_numero_telefono_fijo_persona(String telefono) {
		cotifedDatosAdicionalesPage.getTxtTelefonoPersona().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtTelefonoPersona().sendKeys(telefono);
	}
	
	@Then("Selecciono departamento de info domiciliaria {string}")
	public void Selecciono_departamento_info_domiciliaria(String departamento) {
		cotifedDatosAdicionalesPage.buscar_titulo_dom();
		cotifedDatosAdicionalesPage.getCbxDepartamentoInfoDomiciliaria().click();
		cotifedDatosAdicionalesPage.getOpcionCbxDepartamentoInfoDomiciliaria(departamento).click();
	}
	
	@Then("Selecciono provincia de info domiciliaria {string}")
	public void Selecciono_provincia_info_domiciliaria(String provincia) {
		cotifedDatosAdicionalesPage.getCbxProvinciaInfoDomiciliaria().click();
		cotifedDatosAdicionalesPage.getOpcionCbxProvinciaInfoDomiciliaria(provincia).click();
	}
	
	@Then("Selecciono distrito de info domiciliaria {string}")
	public void Selecciono_distrito_info_domiciliaria(String distrito) {
		cotifedDatosAdicionalesPage.getCbxDistritoInfoDomiciliaria().click();
		cotifedDatosAdicionalesPage.getOpcionCbxDistritoInfoDomiciliaria(distrito).click();
	}
	
	@Then("Ingreso avenida de info domiciliaria {string}")
	public void Ingreso_avenida_info_domiciliaria(String avenida) {
		cotifedDatosAdicionalesPage.getTxtAvenidaInfoDomiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtAvenidaInfoDomiciliaria().sendKeys(avenida);
		cotifedDatosAdicionalesPage.getTxtAvenidaInfoDomiciliaria().sendKeys(Keys.ENTER);
	}
	
	@Then("Doy click en confirmar geopoint de info domiciliaria")
	public void Doy_click_confirmar_geopoint_info_domiciliaria() {
		cotifedDatosAdicionalesPage.getBtnConfirmarInfoDomiciliaria().sendKeys(Keys.ENTER);
		System.out.println("click en aceptar coordenadas");
	}
	
	@Then("Selecciono referencia de info domiciliaria {string}")
	public void Selecciono_referencia_info_domiciliaria(String referencia) {
		cotifedDatosAdicionalesPage.getCbxReferenciaInfoDomiciliaria().click();
		cotifedDatosAdicionalesPage.getOpcionCbxReferenciaInfoDomiciliaria(referencia).click();
	}
	
	@Then("Ingreso descripcion de info domiciliaria {string}")
	public void Ingreso_descripcion_info_domiciliaria(String descripcion) {
		cotifedDatosAdicionalesPage.getTxtDescripcionInfoDomiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtDescripcionInfoDomiciliaria().sendKeys(descripcion);
	}
	
	@Then("Ingreso nombre centro de info laboral {string}")
	public void Ingreso_nombre_centro_info_laboral(String centro) {
		cotifedDatosAdicionalesPage.buscar_titulo_lab();
		cotifedDatosAdicionalesPage.getTxtCentroInfoLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtCentroInfoLaboral().sendKeys(centro);
	}
	
	@Then("Selecciono prefijo de info laboral {string}")
	public void Selecciono_prefijo_info_laboral(String prefijo) {
		cotifedDatosAdicionalesPage.getCbxPrefijoInfoLaboral().click();
		cotifedDatosAdicionalesPage.getOpcionCbxPrefijoInfoLaboral(prefijo).click();
	}
	
	@Then("Ingreso numero de telefono fijo de info laboral {string}")
	public void Ingreso_numero_telefono_fijo_info_laboral(String telefono) {
		cotifedDatosAdicionalesPage.getTxtTelefonoInfoLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtTelefonoInfoLaboral().sendKeys(telefono);
	}
	
	@Then("Ingreso celular de info laboral {string}")
	public void Ingreso_celular_info_laboral(String celular) {
		cotifedDatosAdicionalesPage.getTxtCelularInfoLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtCelularInfoLaboral().sendKeys(celular);
	}
	
	@Then("Ingreso ruc de centro de info laboral {string}")
	public void Ingreso_ruc_centro_info_laboral(String ruc) {
		cotifedDatosAdicionalesPage.getTxtRucInfoLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtRucInfoLaboral().sendKeys(ruc);
	}
	
	@Then("Selecciono departamento de info laboral {string}")
	public void Selecciono_departamento_info_laboral(String departamento) {
		cotifedDatosAdicionalesPage.getCbxDepartamentoInfoLaboral().click();
		cotifedDatosAdicionalesPage.getOpcionCbxDepartamentoInfoLaboral(departamento).click();
	}
	
	@Then("Selecciono provincia de info laboral {string}")
	public void Selecciono_provincia_info_laboral(String provincia) {
		cotifedDatosAdicionalesPage.getCbxProvinciaInfoLaboral().click();
		cotifedDatosAdicionalesPage.getOpcionCbxProvinciaInfoLaboral(provincia).click();
	}
	
	@Then("Selecciono distrito de info laboral {string}")
	public void Selecciono_distrito_info_laboral(String distrito) {
		cotifedDatosAdicionalesPage.getCbxDistritoInfoLaboral().click();
		cotifedDatosAdicionalesPage.getOpcionCbxDistritoInfoLaboral(distrito).click();
	}
	
	@Then("Ingreso avenida de info laboral {string}")
	public void Ingreso_avenida_info_laboral(String avenida) {
		cotifedDatosAdicionalesPage.getTxtAvenidaInfoLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtAvenidaInfoLaboral().sendKeys(avenida);
		cotifedDatosAdicionalesPage.getTxtCalleAvenida().click();
		cotifedDatosAdicionalesPage.buscar_referencia();
		//cotifedDatosAdicionalesPage.getTxtAvenidaInfoLaboral().sendKeys(Keys.ENTER);
	}
	
	@Then("Doy click en confirmar geopoint de info laboral")
	public void Doy_click_confirmar_geopoint_info_laboral() {
		cotifedDatosAdicionalesPage.getBtnConfirmarInfoLaboral().click();
		System.out.println("click en aceptar coordenadas");
	}
	
	@Then("Selecciono referencia de info laboral {string}")
	public void Selecciono_referencia_info_laboral(String referencia) {
		System.out.println(referencia);
		cotifedDatosAdicionalesPage.getCbxReferenciaInfoLaboral().click();
		cotifedDatosAdicionalesPage.getOpcionCbxReferenciaInfoLaboral(referencia).click();
	}                                 
	
	@Then("Ingreso descripcion de info laboral {string}")
	public void Ingreso_descripcion_info_laboral(String descripcion) {
		System.out.println(descripcion);
		cotifedDatosAdicionalesPage.getTxtDescripcionInfoLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtDescripcionInfoLaboral().sendKeys(descripcion);
	}
	
	
	
}