package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedInfoLaboralPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;

import io.cucumber.java.en.When;

public class CredifedInfoLaboralSteps {
	private CredifedInfoLaboralPage credifedInfoLaboralPage;
	public CredifedInfoLaboralSteps(CredifedInfoLaboralPage credifedInfoLaboralPage) {
		this.credifedInfoLaboralPage = credifedInfoLaboralPage;
	}
	
	@When("Ingreso centro de trabajo {string}")
	public void ingresoCentroTrabajo(String opcion) {
		credifedInfoLaboralPage.getCentroTrabajo().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.getCentroTrabajo().sendKeys(opcion);
	}
	
	@When("Ingreso ruc de centro de trabajo {string}")
	public void ingresoRucCentroTrabajo(String opcion) {
		credifedInfoLaboralPage.getRucCentroTrabajo().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.getRucCentroTrabajo().sendKeys(opcion);
	}
	
	@When("Elijo e ingreso telefono fijo informacion laboral {string} {string}")
	public void elijoIngresoTelefonoFijoInformacionLaboral(String pais,String nro)
	{
		credifedInfoLaboralPage.getTipoTelefonoFijo(pais).click();
		if(pais.equals("LIMA")) {
			credifedInfoLaboralPage.getTelefonoFijoLima().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoLaboralPage.getTelefonoFijoLima().sendKeys(nro);
		}else {
			credifedInfoLaboralPage.getTelefonoFijoOtros().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoLaboralPage.getTelefonoFijoOtros().sendKeys(nro);	
		}	
	}
	
	@When("Ingreso celular {string}")
	public void ingresoCelular(String opcion) {
		credifedInfoLaboralPage.getCelular().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.getCelular().sendKeys(opcion);
	}
	
	@When("Selecciono departamento laboral {string}")
	public void seleccionoDepartamentoLaboral(String opcion)
	{
		credifedInfoLaboralPage.selectDepartamento(opcion).click();
	}
	
	@When("Selecciono provincia laboral {string}")
	public void seleccionoProvincia_laboral(String opcion)
	{
		credifedInfoLaboralPage.selectProvincia(opcion).click();
	}
	
	@When("Selecciono distrito laboral {string}")
	public void seleccionoDistrito_laboral(String opcion)
	{
		credifedInfoLaboralPage.selectDistrito(opcion).click();
	}
	
	@When("Ingreso direccion domiciliaria laboral {string}")
	public void ingresoDireccionDomiciliariaLaboral(String opcion)
	{
		credifedInfoLaboralPage.ingresoDireccionDomiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.ingresoDireccionDomiciliaria().sendKeys(opcion);
	}
	
	@When("Doy click en ubicar mapa laboral")
	public void clickBtnUbicarMapaLaboral()
	{
		SeleniumWaiters.waitSeconds(3);
		credifedInfoLaboralPage.clickBtnUbicarMapa().click();
	}
	
	@When("Selecciono tipo de referencia laboral {string}")
	public void seleccionoReferenciaLaboral(String opcion)
	{
		credifedInfoLaboralPage.selectReferencia(opcion).click();
	}
	
	@When("Ingreso la referencia laboral {string}")
	public void ingresoReferenciaLaboral(String opcion)
	{
		credifedInfoLaboralPage.ingresarReferencia().sendKeys(opcion);
	}
	
	@When("Doy click en aceptar la ubicacion correcta en el mapa laboral")
	public void clickAceptarUbicarMapaLaboral()
	{
		do {
		} while (credifedInfoLaboralPage.loadingPage()!=null);
		credifedInfoLaboralPage.clickAceptarUbicarMapa().click();
	}
}
