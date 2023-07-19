package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedInfoLaboralAvalPage;
import com.qa.efe.automatizacion.pages.CredifedInfoLaboralPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.stores.IntegracionStore;

import io.cucumber.java.en.When;

public class CredifedInfoLaboralAvalSteps {
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	private CredifedInfoLaboralAvalPage credifedInfoLaboralAvalPage;
	private CredifedInfoLaboralPage credifedInfoLaboralPage;
	private IntegracionStore integracionStore;
	public CredifedInfoLaboralAvalSteps(CredifedInfoLaboralAvalPage credifedInfoLaboralAvalPage,
			CredifedInfoLaboralPage credifedInfoLaboralPage,CredifedGeneralidadesPage credifedGeneralidadesPage
			,IntegracionStore integracionStore) {
		this.credifedInfoLaboralAvalPage = credifedInfoLaboralAvalPage;
		this.credifedInfoLaboralPage=credifedInfoLaboralPage;
		this.credifedGeneralidadesPage=credifedGeneralidadesPage;
		this.integracionStore=integracionStore;
	}
	@When("Ingreso centro de trabajo aval {string}")
	public void ingresoCentroTrabajo(String opcion) {
		credifedInfoLaboralAvalPage.getCentroTrabajo().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralAvalPage.getCentroTrabajo().sendKeys(opcion);
		integracionStore.centroTrabajolaboralAval=opcion;
	}
	
	@When("Ingreso ruc de centro de trabajo aval {string}")
	public void ingresoRucCentroTrabajo(String opcion) {
		credifedInfoLaboralAvalPage.getRucCentroTrabajo().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralAvalPage.getRucCentroTrabajo().sendKeys(opcion);
		integracionStore.rucCentroTrabajolaboralAval=opcion;
	}
	
	@When("Elijo e ingreso telefono fijo informacion laboral aval {string} {string}")
	public void elijoIngresoTelefonoFijoInformacionLaboral(String pais,String nro)
	{
		SeleniumWaiters.waitSeconds(8);
		credifedInfoLaboralAvalPage.getTipoTelefonoFijo(pais).click();
		if(pais.equals("LIMA")) {
			credifedInfoLaboralAvalPage.getTelefonoFijoLima().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoLaboralAvalPage.getTelefonoFijoLima().sendKeys(nro);
		}else {
			credifedInfoLaboralAvalPage.getTelefonoFijoOtros().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoLaboralAvalPage.getTelefonoFijoOtros().sendKeys(nro);	
		}	
		integracionStore.DeptotelFijoLaboralAval=pais;
		integracionStore.telFijoLaboralAval=nro;
	}
	
	@When("Ingreso celular aval {string}")
	public void ingresoCelular(String opcion) {
		credifedInfoLaboralAvalPage.getCelular().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralAvalPage.getCelular().sendKeys(opcion);
		integracionStore.celLaboralAval=opcion;
	}
	
	@When("Selecciono departamento laboral aval {string}")
	public void seleccionoDepartamentoLaboral(String opcion)
	{
		credifedInfoLaboralAvalPage.selectDepartamento(opcion).click();
		integracionStore.departamentoLaboralTitularAval=opcion;
	}
	
	@When("Selecciono provincia laboral aval {string}")
	public void seleccionoProvincia_laboral(String opcion)
	{
		credifedInfoLaboralAvalPage.selectProvincia(opcion).click();
		integracionStore.provinciaDomLaboralTitularAval=opcion;
	}
	
	@When("Selecciono distrito laboral aval {string}")
	public void seleccionoDistrito_laboral(String opcion)
	{
		credifedInfoLaboralAvalPage.selectDistrito(opcion).click();
		integracionStore.distritoDomLaboralTitularAval=opcion;

	}
	
	@When("Ingreso direccion domiciliaria laboral aval {string}")
	public void ingresoDireccionDomiciliariaLaboral(String opcion)
	{
		credifedInfoLaboralAvalPage.ingresoDireccionDomiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralAvalPage.ingresoDireccionDomiciliaria().sendKeys(opcion);
	}
	
	@When("Doy click en ubicar mapa laboral aval")
	public void clickBtnUbicarMapaLaboral()
	{
		SeleniumWaiters.waitSeconds(3);
		credifedInfoLaboralAvalPage.clickBtnUbicarMapa().click();
	}
	
	@When("Selecciono tipo de referencia laboral aval {string}")
	public void seleccionoReferenciaLaboral(String opcion)
	{
		credifedInfoLaboralAvalPage.selectReferencia(opcion).click();
	}
	
	@When("Ingreso la referencia laboral aval {string}")
	public void ingresoReferenciaLaboral(String opcion)
	{
		credifedInfoLaboralAvalPage.ingresarReferencia().sendKeys(opcion);
	}
	
	@When("Doy click en aceptar la ubicacion correcta en el mapa laboral aval")
	public void clickAceptarUbicarMapaLaboral()
	{
		do {
		} while (credifedInfoLaboralPage.loadingPage()!=null);
		credifedInfoLaboralAvalPage.clickAceptarUbicarMapa().click();
	}
	
	
	
}
