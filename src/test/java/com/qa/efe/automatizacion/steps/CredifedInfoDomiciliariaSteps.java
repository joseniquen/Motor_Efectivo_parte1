package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedInfoDomiciliariaPage;
import com.qa.efe.automatizacion.pages.CredifedInfoLaboralPage;

import io.cucumber.java.en.When;

public class CredifedInfoDomiciliariaSteps {
	private CredifedInfoDomiciliariaPage credifedInfoDomiciliariaPage;
	private CredifedInfoLaboralPage credifedInfoLaboralPage;
	public CredifedInfoDomiciliariaSteps(CredifedInfoDomiciliariaPage credifedInfoDomiciliariaPage,CredifedInfoLaboralPage credifedInfoLaboralPage) {
		this.credifedInfoDomiciliariaPage = credifedInfoDomiciliariaPage;
		this.credifedInfoLaboralPage=credifedInfoLaboralPage;
	}
	
	@When("Selecciono departamento {string}")
	public void seleccionoDepartamento(String opcion)
	{
		credifedInfoDomiciliariaPage.selectDepartamento(opcion).click();
	}
	
	@When("Selecciono provincia {string}")
	public void seleccionoProvincia(String opcion)
	{
		credifedInfoDomiciliariaPage.selectProvincia(opcion).click();
	}
	
	@When("Selecciono distrito {string}")
	public void seleccionoDistrito(String opcion)
	{
		credifedInfoDomiciliariaPage.selectDistrito(opcion).click();
	}
	
	@When("Ingreso direccion domiciliaria {string}")
	public void ingresoDireccionDomiciliaria(String opcion)
	{
		credifedInfoDomiciliariaPage.ingresoDireccionDomiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoDomiciliariaPage.ingresoDireccionDomiciliaria().sendKeys(opcion);
	}
	
	@When("Doy click en ubicar mapa")
	public void clickBtnUbicarMapa()
	{
		credifedInfoDomiciliariaPage.clickBtnUbicarMapa().click();
	}
	
	@When("Selecciono tipo de referencia {string}")
	public void seleccionoTipoReferencia(String opcion)
	{
		credifedInfoDomiciliariaPage.selectReferencia(opcion).click();
	}
	
	@When("Ingreso la referencia {string}")
	public void ingresoReferencia(String opcion)
	{
		credifedInfoDomiciliariaPage.ingresarReferencia().sendKeys(opcion);
	}
	
	@When("Doy click en aceptar la ubicacion correcta en el mapa")
	public void clickAceptarUbicarMapa()
	{
		do {
		} while (credifedInfoLaboralPage.loadingPage()!=null);
		credifedInfoDomiciliariaPage.clickAceptarUbicarMapa().click();
	}
}
