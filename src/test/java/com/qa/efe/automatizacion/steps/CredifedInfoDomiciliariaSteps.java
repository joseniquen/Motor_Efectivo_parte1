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
	@When("selecciono departamento {string}")
	public void select_departamento(String opcion)
	{
		credifedInfoDomiciliariaPage.select_departamento(opcion).click();
	}
	@When("selecciono provincia {string}")
	public void select_provincia(String opcion)
	{
		credifedInfoDomiciliariaPage.select_provincia(opcion).click();
	}
	@When("selecciono distrito {string}")
	public void select_distrito(String opcion)
	{
		credifedInfoDomiciliariaPage.select_distrito(opcion).click();
	}
	@When("ingreso direccion domiciliaria {string}")
	public void ingreso_direccion_domiciliaria(String opcion)
	{
		credifedInfoDomiciliariaPage.ingreso_direccion_domiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoDomiciliariaPage.ingreso_direccion_domiciliaria().sendKeys(opcion);
	}
	@When("click en ubicar mapa")
	public void click_btn_ubicar_mapa()
	{
		credifedInfoDomiciliariaPage.click_btn_ubicar_mapa().click();
	}
	@When("selecciono tipo de referencia {string}")
	public void select_referencia(String opcion)
	{
		credifedInfoDomiciliariaPage.select_referencia(opcion).click();
	}
	@When("ingreso la referencia {string}")
	public void ingresar_referencia(String opcion)
	{
		credifedInfoDomiciliariaPage.ingresar_referencia().sendKeys(opcion);
	}
	@When("doy click en aceptar la ubicacion correcta en el mapa")
	public void click_aceptar_ubicar_mapa()
	{
		credifedInfoDomiciliariaPage.click_aceptar_ubicar_mapa().click();
	}
}
