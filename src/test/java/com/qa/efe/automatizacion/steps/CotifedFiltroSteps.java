package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CotifedFiltroPage;
import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;
import com.qa.efe.automatizacion.stores.IntegracionStore;

public class CotifedFiltroSteps {
	private CotifedFiltroPage filtroPage;
	private WebDriver driver;
	private PropertiesManager propertiesManager;
	private IntegracionStore integracionStore;
	private CotifedGeneralidadesPage generalidadesPage;
	public CotifedFiltroSteps(
			PropertiesManager propertiesManager, 
			WebDriverManager driverManager, 
			CotifedFiltroPage filtroPage,
			IntegracionStore integracionStore
			 ) {
		this.propertiesManager = propertiesManager;
		this.driver = driverManager.getDriver();
		this.filtroPage = filtroPage;
		this.generalidadesPage = generalidadesPage;
		this.integracionStore=integracionStore;
	}

	@When("Selecciono tienda {string}")
	public void seleccionoTienda(String tienda) {
		filtroPage.getCbxTienda().click();
		filtroPage.getOpcionTienda(tienda).click();
	}

	@When("Selecciono Tipo de documento {string}")
	public void seleccionoTipoDoc(String tipoDoc) {
		integracionStore.tipo_documento=tipoDoc;
		filtroPage.getCbxTipoDoc().click();
		filtroPage.getOpcionTipoDoc(tipoDoc).click();
	}
	@When("Ingreso numero de documento {string}")
	public void ingresoNumeroDocumento(String NumeroDoc) {
		filtroPage.getTxtNumeroDoc().sendKeys(NumeroDoc);
		integracionStore.dni=NumeroDoc;
		while(generalidadesPage.Pantalla_Carga().size() != 0) {
		}
		SeleniumWaiters.waitSeconds(2);
	}
	@When("Ingreso correo {string}")
	public void ingresoCorreo(String correo) {
		filtroPage.getTxtEmail().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		filtroPage.getTxtEmail().sendKeys(correo);
	}
	@When("Ingreso numero celular {string}")
	public void ingresoNumeroCelular(String celular) {
		filtroPage.getTxtNumeroCell().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		filtroPage.getTxtNumeroCell().sendKeys(celular);
	}
	@When("Doy click en filtrar")
	public void doyClickFiltrar() {
		filtroPage.getBtnFiltrar().click();
		while(generalidadesPage.Pantalla_Carga().size() != 0) {
		}
		SeleniumWaiters.waitSeconds(2);
	}

	
	
}
