package com.qa.efe.automatizacion.steps;

import com.qa.efe.automatizacion.pages.CredifedDatosAvalPage;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedDashboardPage;
import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.stores.IntegracionStore;

import io.cucumber.java.en.When;

public class CredifedDatosAvalSteps {
	
private CredifedGeneralidadesPage credifedGeneralidadesPage;
private CredifedDatosAvalPage credifedAvalPage;
private CredifedGeneralidadesSteps credifedGeneralidadesSteps;
private CredifedDatosTitularSteps credifedDatosTitularSteps;
private IntegracionStore integracionStore;
	
	public CredifedDatosAvalSteps(CredifedGeneralidadesPage credifedGeneralidadesPage, CredifedDatosAvalPage credifedAvalPage
			,CredifedGeneralidadesSteps credifedGeneralidadesSteps, CredifedDatosTitularSteps credifedDatosTitularSteps
			,IntegracionStore integracionStore) {
		this.credifedGeneralidadesPage=credifedGeneralidadesPage;
		this.credifedAvalPage=credifedAvalPage;
		this.credifedGeneralidadesSteps=credifedGeneralidadesSteps;
		this.credifedDatosTitularSteps=credifedDatosTitularSteps;
		this.integracionStore=integracionStore;
	}
	
	@When ("Selecciono tipo de documento aval {string}")
	public void seleccionoTipoDocumentoAval(String doc) {
		credifedAvalPage.getTipoDocumento().click();
		credifedAvalPage.getSelectTipoDocumento(doc).click();
		integracionStore.dniAval=doc;
	}
	
	@When ("Ingreso numero de documento aval {string}")
	public void ingresoNumeroDocumentoAval(String doc) {
		if(credifedAvalPage.getNumeroDocumento().isEnabled()) {
		credifedAvalPage.getNumeroDocumento().sendKeys(doc);
		credifedAvalPage.textNumeroDocumento().click();
		}else {
			credifedGeneralidadesSteps.cambioIframeDefault();
			credifedGeneralidadesSteps.cambioIframeNuevo("Paso: Analizar Solicitud de Crédito");
			credifedGeneralidadesSteps.cambioIframeNuevo("15 Datos Aval");
			credifedGeneralidadesSteps.clickBtnCancelar();
			credifedAvalPage.getCambiarAval().click();
			credifedAvalPage.getCambiarAvalAlerta().click();
			SeleniumWaiters.waitSeconds(4);
			credifedDatosTitularSteps.clickBtnEditar(1);
			credifedAvalPage.getTipoDocumento().click();
			credifedAvalPage.getSelectTipoDocumento(integracionStore.dniAval).click();
			credifedAvalPage.getNumeroDocumento().sendKeys(doc);
			credifedAvalPage.textNumeroDocumento().click();
		}
	}

	@When ("Selecciono condicion especial aval {string}")
	public void seleccionoCondicionEspecialAval(String doc) {
		credifedAvalPage.selectCondicionEspecial(doc).click();
	}

	@When ("Selecciono estado civil aval {string}")
	public void seleccionoEstadoCivilAval(String doc) {
		credifedAvalPage.getEstadoCivil().click();
		credifedAvalPage.getSelectEstadoCivil(doc).click();
	}
	
	@When ("Selecciono pais de nacimiento aval {string}")
	public void seleccionoPaisNacimientoAval(String doc) {
		credifedAvalPage.getPaisNacimiento().click();
		credifedAvalPage.getSelectPaisNacimiento(doc).click();
	}
	
	@When ("Selecciono pais de residencia aval {string}")
	public void seleccionoPaisResidenciaAval(String doc) {
		credifedAvalPage.getPaisResidencia().click();
		credifedAvalPage.getSelectPaisResidencia(doc).click();
	}
	
	@When ("Ingreso celular principal aval {string}")
	public void ingresoCelularPrincipalAval(String doc) {
		credifedAvalPage.getCelularPrincipal().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedAvalPage.getCelularPrincipal().sendKeys(doc);
	}
	
	@When ("Ingreso celular secundario aval {string}")
	public void getCelularSecundario(String doc) {
		credifedAvalPage.getCelularSecundario().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedAvalPage.getCelularSecundario().sendKeys(doc);
	}
	
	@When ("Elijo e ingreso telefono fijo aval {string} {string}")
	public void ingresoTelefonoFijoAval(String doc,String doc2) {
		credifedAvalPage.selectPaisTelFijo(doc).click();
		credifedAvalPage.getNumeroFijo().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedAvalPage.getNumeroFijo().sendKeys(doc2);
	}
	
	@When ("Ingreso correo electronico aval {string}")
	public void ingresoCorreoElectronicoAval(String doc) {
		credifedAvalPage.getCorreo().sendKeys(doc);
	}
	

}
