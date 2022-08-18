package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.efe.automatizacion.pages.CredifedInfoDomiciliariaPage;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.When;

public class CredifedInfoDomiciliariaSteps {
	private WebDriver driver;
	private CredifedInfoDomiciliariaPage credifedInfoDomiciliariaPage;
	public CredifedInfoDomiciliariaSteps( WebDriverManager driverManager,CredifedInfoDomiciliariaPage credifedInfoDomiciliariaPage) {
		this.driver = driverManager.getDriver();
		this.credifedInfoDomiciliariaPage = credifedInfoDomiciliariaPage;
	}
	@When("Selecciono departamento {string}")
	public void seleccionoDepartamento(String opcion)
	{
		credifedInfoDomiciliariaPage.select_departamento(opcion).click();
	}
	@When("Selecciono provincia {string}")
	public void seleccionoProvincia(String opcion)
	{
		credifedInfoDomiciliariaPage.select_provincia(opcion).click();
	}
	@When("Selecciono distrito {string}")
	public void seleccionoDistrito(String opcion)
	{
		credifedInfoDomiciliariaPage.select_distrito(opcion).click();
	}
	@When("Ingreso direccion domiciliaria {string}")
	public void ingresoDireccionDomiciliaria(String opcion)
	{
		credifedInfoDomiciliariaPage.ingreso_direccion_domiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoDomiciliariaPage.ingreso_direccion_domiciliaria().sendKeys(opcion);
	}
	@When("Doy click en ubicar mapa")
	public void clickBtnUbicarMapa()
	{
		credifedInfoDomiciliariaPage.click_btn_ubicar_mapa().click();
	}
	@When("Selecciono tipo de referencia {string}")
	public void seleccionoTipoReferencia(String opcion)
	{
		credifedInfoDomiciliariaPage.select_referencia(opcion).click();
	}
	@When("Ingreso la referencia {string}")
	public void ingresoReferencia(String opcion)
	{
		credifedInfoDomiciliariaPage.ingresar_referencia().sendKeys(opcion);
	}
	@When("Doy click en aceptar la ubicacion correcta en el mapa")
	public void clickAceptarUbicarMapa()
	{
		credifedInfoDomiciliariaPage.click_aceptar_ubicar_mapa().click();
	}
}
