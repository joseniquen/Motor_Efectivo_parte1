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

	@Then("Selecciono tienda {string}")
	public void selecciono_Tienda(String tienda) {
		filtroPage.getCbxTienda().click();
		filtroPage.getOpcionTienda(tienda).click();
	}

	@Then("Selecciono Tipo de documento {string}")
	public void selecciono_Tipo_Doc(String tipoDoc) {
		integracionStore.tipo_documento=tipoDoc;
		filtroPage.getCbxTipoDoc().click();
		filtroPage.getOpcionTipoDoc(tipoDoc).click();
		System.out.println(tipoDoc);
	}
	@Then("Ingreso numero de documento {string}")
	public void ingreso_Numero_Doc(String NumeroDoc) {
		filtroPage.getTxtNumeroDoc().sendKeys(NumeroDoc);
		integracionStore.dni=NumeroDoc;
		System.out.println(NumeroDoc);
		System.out.println(integracionStore.dni);
	}
	@Then("Ingreso correo {string}")
	public void ingreso_correo(String correo) {
		filtroPage.getTxtEmail().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		filtroPage.getTxtEmail().sendKeys(correo);
	}
	@Then("Ingreso numero celular {string}")
	public void ingreso_numero_celular(String celular) {
		filtroPage.getTxtNumeroCell().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		filtroPage.getTxtNumeroCell().sendKeys(celular);
	}
	@Then("Doy click en filtrar")
	public void click_filtrar() {
		filtroPage.getBtnFiltrar().click();
	}

	
	
}
