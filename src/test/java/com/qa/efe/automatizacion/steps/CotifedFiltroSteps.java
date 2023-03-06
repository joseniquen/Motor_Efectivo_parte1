package com.qa.efe.automatizacion.steps;

import java.io.IOException;

import org.openqa.selenium.Keys;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import com.qa.efe.automatizacion.pages.CotifedFiltroPage;
import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;
import com.qa.efe.automatizacion.stores.IntegracionStore;

public class CotifedFiltroSteps {
	private CotifedFiltroPage filtroPage;
	private IntegracionStore integracionStore;
	private CotifedGeneralidadesPage generalidadesPage;

	public CotifedFiltroSteps(
			WebDriverManager driverManager, 
			CotifedFiltroPage filtroPage,
			CotifedGeneralidadesPage generalidadesPage,
			IntegracionStore integracionStore
			 ) {
		this.filtroPage = filtroPage;
		this.generalidadesPage = generalidadesPage;
		this.integracionStore=integracionStore;
	}

	@When("Selecciono tienda {string}")
	public void seleccionoTienda(String tienda) {
		generalidadesPage.cargarDatos();
		filtroPage.getCbxTienda().click();
		filtroPage.getOpcionTienda(tienda).click();		
	}

	@And("Selecciono Tipo de documento {string}")
	public void seleccionoTipoDoc(String tipoDoc) {
		integracionStore.tipo_documento=tipoDoc;
		filtroPage.getCbxTipoDoc().click();
		filtroPage.getOpcionTipoDoc(tipoDoc).click();
	}
	@And("Ingreso numero de documento {string}")
	public void ingresoNumeroDocumento(String NumeroDoc) {
		filtroPage.getTxtNumeroDoc().sendKeys(NumeroDoc);
		integracionStore.dni=NumeroDoc;
		generalidadesPage.cargarDatos();
	}
	@And("Ingreso correo {string}")
	public void ingresoCorreo(String correo) {
		filtroPage.getTxtEmail().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		filtroPage.getTxtEmail().sendKeys(correo);
	}
	@And("Ingreso numero celular {string}")
	public void ingresoNumeroCelular(String celular) {
		filtroPage.getTxtNumeroCell().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		filtroPage.getTxtNumeroCell().sendKeys(celular);
	}
	@When("Doy click en filtrar")
	public void doyClickFiltrar() {
		filtroPage.getBtnFiltrar().click();
		generalidadesPage.cargarDatos();
		try {
			generalidadesPage.captura_pantalla_cotifed("target", "cotifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
