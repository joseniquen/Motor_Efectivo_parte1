package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CotifedDatosAdicionalesPage;
import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;

import io.cucumber.java.en.When;

public class CotifedDatosAdicionalesSteps {
	private CotifedDatosAdicionalesPage cotifedDatosAdicionalesPage;
	private CotifedGeneralidadesPage cotifedGeneralidadesPage;

	public CotifedDatosAdicionalesSteps(CotifedDatosAdicionalesPage cotifedDatosAdicionalesPage, CotifedGeneralidadesPage cotifedGeneralidadesPage
			 ) {
		this.cotifedDatosAdicionalesPage = cotifedDatosAdicionalesPage;
		this.cotifedGeneralidadesPage=cotifedGeneralidadesPage;
	}
	
	@When("Doy click en el boton continuar datos adicionales")
	public void doyClickBotonContinuarDatosAdicionales() {
		cotifedDatosAdicionalesPage.getBtnContinuarDatosAdicionales().click();
	}
	
	@When("Ingreso correo de datos principales {string}")
	public void ingresoCorreoPersona(String correo) {
		cotifedDatosAdicionalesPage.getTxtCorreoPersona().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtCorreoPersona().sendKeys(correo);
	}
	
	@When("Ingreso numero de celular de datos principales {string}")
	public void ingresoNumeroCelularPersona(String celular) {
		cotifedDatosAdicionalesPage.getTxtCelularPersona().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtCelularPersona().sendKeys(celular);
	}
	
	@When("Selecciono prefijo de datos principales {string}")
	public void seleccionoPrefijoPersona(String prefijo) {
		cotifedDatosAdicionalesPage.getCbxPrefijoPersona().click();
		cotifedDatosAdicionalesPage.getOpcionCbxPrefijoPersona(prefijo).click();
	}
	
	@When("Ingreso numero de telefono fijo de datos principales {string}")
	public void ingresoNumeroTelefonoFijoPersona(String telefono) {
		cotifedDatosAdicionalesPage.getTxtTelefonoPersona().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtTelefonoPersona().sendKeys(telefono);
	}
	
	@When("Selecciono departamento de informacion domiciliaria {string}")
	public void seleccionoDepartamentoInformacionDomiciliaria(String departamento) {
		cotifedDatosAdicionalesPage.buscarTituloDom();
		cotifedDatosAdicionalesPage.getCbxDepartamentoInfoDomiciliaria().click();
		cotifedDatosAdicionalesPage.getOpcionCbxDepartamentoInfoDomiciliaria(departamento).click();
	}
	
	@When("Selecciono provincia de informacion domiciliaria {string}")
	public void seleccionoProvinciaInformacionDomiciliaria(String provincia) {
		cotifedDatosAdicionalesPage.getCbxProvinciaInfoDomiciliaria().click();
		cotifedDatosAdicionalesPage.getOpcionCbxProvinciaInfoDomiciliaria(provincia).click();
	}
	
	@When("Selecciono distrito de informacion domiciliaria {string}")
	public void seleccionoDistritoInformacionDomiciliaria(String distrito) {
		cotifedDatosAdicionalesPage.getCbxDistritoInfoDomiciliaria().click();
		cotifedDatosAdicionalesPage.getOpcionCbxDistritoInfoDomiciliaria(distrito).click();
	}
	
	@When("Ingreso avenida de informacion domiciliaria {string}")
	public void ingresoAvenidaInformacionDomiciliaria(String avenida) {
		cotifedDatosAdicionalesPage.getTxtAvenidaInfoDomiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtAvenidaInfoDomiciliaria().sendKeys(avenida);
		cotifedDatosAdicionalesPage.getTxtAvenidaInfoDomiciliaria().sendKeys(Keys.ENTER);
	}
	
	@When("Doy click en confirmar geopoint de informacion domiciliaria")
	public void doyClickConfirmarGeopointInformacionDomiciliaria() {
		cotifedDatosAdicionalesPage.getBtnConfirmarInfoDomiciliaria().sendKeys(Keys.ENTER);
		cotifedGeneralidadesPage.IrAIframePorDefecto();
	}
	
	@When("Selecciono referencia de informacion domiciliaria {string}")
	public void seleccionoReferenciaInformacionDomiciliaria(String referencia) {
		cotifedDatosAdicionalesPage.getCbxReferenciaInfoDomiciliaria().click();
		cotifedDatosAdicionalesPage.getOpcionCbxReferenciaInfoDomiciliaria(referencia).click();
	}
	
	@When("Ingreso descripcion de informacion domiciliaria {string}")
	public void ingresoDescripcionInformacionDomiciliaria(String descripcion) {
		cotifedDatosAdicionalesPage.getTxtDescripcionInfoDomiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtDescripcionInfoDomiciliaria().sendKeys(descripcion);
	}
	
	@When("Ingreso nombre centro de informacion laboral {string}")
	public void ingresoNombreCentroInformacionLaboral(String centro) {
		cotifedDatosAdicionalesPage.buscarTituloLab();
		cotifedDatosAdicionalesPage.getTxtCentroInfoLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtCentroInfoLaboral().sendKeys(centro);
	}
	
	@When("Selecciono prefijo de informacion laboral {string}")
	public void seleccionoPrefijoInformacionLaboral(String prefijo) {
		cotifedDatosAdicionalesPage.getCbxPrefijoInfoLaboral().click();
		cotifedDatosAdicionalesPage.getOpcionCbxPrefijoInfoLaboral(prefijo).click();
	}
	
	@When("Ingreso numero de telefono fijo de informacion laboral {string}")
	public void ingresoNumeroTelefonoFijoInformacionLaboral(String telefono) {
		cotifedDatosAdicionalesPage.getTxtTelefonoInfoLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtTelefonoInfoLaboral().sendKeys(telefono);
	}
	
	@When("Ingreso celular de informacion laboral {string}")
	public void ingresoCelularInformacionLaboral(String celular) {
		cotifedDatosAdicionalesPage.getTxtCelularInfoLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtCelularInfoLaboral().sendKeys(celular);
	}
	
	@When("Ingreso ruc de centro de informacion laboral {string}")
	public void ingresoRucCentroInformacionLaboral(String ruc) {
		cotifedDatosAdicionalesPage.getTxtRucInfoLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtRucInfoLaboral().sendKeys(ruc);
	}
	
	@When("Selecciono departamento de informacion laboral {string}")
	public void seleccionoDepartamentoInformacionLaboral(String departamento) {
		cotifedDatosAdicionalesPage.getCbxDepartamentoInfoLaboral().click();
		cotifedDatosAdicionalesPage.getOpcionCbxDepartamentoInfoLaboral(departamento).click();
	}
	
	@When("Selecciono provincia de informacion laboral {string}")
	public void seleccionoProvinciaInformacionLaboral(String provincia) {
		cotifedDatosAdicionalesPage.getCbxProvinciaInfoLaboral().click();
		cotifedDatosAdicionalesPage.getOpcionCbxProvinciaInfoLaboral(provincia).click();
	}
	
	@When("Selecciono distrito de informacion laboral {string}")
	public void seleccionoDistritoInformacionLaboral(String distrito) {
		cotifedDatosAdicionalesPage.getCbxDistritoInfoLaboral().click();
		cotifedDatosAdicionalesPage.getOpcionCbxDistritoInfoLaboral(distrito).click();
	}
	
	@When("Ingreso avenida de informacion laboral {string}")
	public void ingresoAvenidaInformacionLaboral(String avenida) {
		cotifedDatosAdicionalesPage.getTxtAvenidaInfoLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtAvenidaInfoLaboral().sendKeys(avenida);
		cotifedDatosAdicionalesPage.getTxtCalleAvenida().click();
		cotifedDatosAdicionalesPage.buscarReferencia();
	}
	
	@When("Doy click en confirmar geopoint de informacion laboral")
	public void doyClickConfirmarGeopointInformacionLaboral() {
		cotifedDatosAdicionalesPage.getBtnConfirmarInfoLaboral().click();
		cotifedGeneralidadesPage.IrAIframePorDefecto();
	}
	
	@When("Selecciono referencia de informacion laboral {string}")
	public void seleccionoReferenciaInformacionLaboral(String referencia) {
		cotifedDatosAdicionalesPage.getCbxReferenciaInfoLaboral().click();
		cotifedDatosAdicionalesPage.getOpcionCbxReferenciaInfoLaboral(referencia).click();
	}                                 
	
	@When("Ingreso descripcion de informacion laboral {string}")
	public void ingresoDescripcionInformacionLaboral(String descripcion) {
		cotifedDatosAdicionalesPage.getTxtDescripcionInfoLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedDatosAdicionalesPage.getTxtDescripcionInfoLaboral().sendKeys(descripcion);
	}
	
	
	
}