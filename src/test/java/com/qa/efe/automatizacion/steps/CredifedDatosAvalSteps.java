package com.qa.efe.automatizacion.steps;

import com.qa.efe.automatizacion.pages.CredifedDatosAvalPage;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedDashboardPage;
import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;

import io.cucumber.java.en.When;

public class CredifedDatosAvalSteps {
	
private CredifedGeneralidadesPage credifedGeneralidadesPage;
private CredifedDatosAvalPage credifedAvalPage;
	
	public CredifedDatosAvalSteps(CredifedGeneralidadesPage credifedGeneralidadesPage, CredifedDatosAvalPage credifedAvalPage
			 ) {
		this.credifedGeneralidadesPage=credifedGeneralidadesPage;
		this.credifedAvalPage=credifedAvalPage;
	}
	
	@When ("Selecciono tipo de documento aval {string}")
	public void seleccionoTipoDocumentoAval(String doc) {
		credifedAvalPage.getTipoDocumento().click();
		credifedAvalPage.getSelectTipoDocumento(doc).click();
	}
	
	@When ("Ingreso numero de documento aval {string}")
	public void ingresoNumeroDocumentoAval(String doc) {
		credifedAvalPage.getNumeroDocumento().sendKeys(doc);
		credifedAvalPage.textNumeroDocumento().click();
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
