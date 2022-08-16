package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.efe.automatizacion.pages.CredifedInfoLaboralPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CredifedInfoLaboralSteps {
	private WebDriver driver;
	private CredifedInfoLaboralPage credifedInfoLaboralPage;
	public CredifedInfoLaboralSteps( WebDriverManager driverManager,CredifedInfoLaboralPage credifedInfoLaboralPage) {
		this.driver = driverManager.getDriver();
		this.credifedInfoLaboralPage = credifedInfoLaboralPage;
	}
	@Then("ingreso centro de trabajo {string}")
	public void ingreso_centro_trabajo(String opcion) {
		credifedInfoLaboralPage.getCentroTrabajo().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.getCentroTrabajo().sendKeys(opcion);

	}
	@Then("ingreso ruc de centro de trabajo {string}")
	public void ingreso_ruc_centro_trabajo(String opcion) {
		credifedInfoLaboralPage.getRucCentroTrabajo().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.getRucCentroTrabajo().sendKeys(opcion);

	}
	@When("elijo e ingreso telefono fijo info laboral {string} {string}")
	public void select_pais_tel__fijo(String pais,String nro)
	{
		credifedInfoLaboralPage.getTipoTelefonoFijo(pais).click();
		if(pais.equals("LIMA")) {
			System.out.println("aa");
			credifedInfoLaboralPage.getTelefonoFijo_lima().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoLaboralPage.getTelefonoFijo_lima().sendKeys(nro);
		}else {
			System.out.println("bb");
			credifedInfoLaboralPage.getTelefonoFijo_otros().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoLaboralPage.getTelefonoFijo_otros().sendKeys(nro);	
		}
		
	}
	@Then("ingreso celular {string}")
	public void ingreso_celular(String opcion) {
		credifedInfoLaboralPage.getCelular().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.getCelular().sendKeys(opcion);

	}
	
	@When("selecciono departamento laboral {string}")
	public void select_departamento_laboral(String opcion)
	{
		credifedInfoLaboralPage.select_departamento(opcion).click();
	}
	@When("selecciono provincia laboral {string}")
	public void select_provincia_laboral(String opcion)
	{
		credifedInfoLaboralPage.select_provincia(opcion).click();
	}
	@When("selecciono distrito laboral {string}")
	public void select_distrito_laboral(String opcion)
	{
		credifedInfoLaboralPage.select_distrito(opcion).click();
	}
	@When("ingreso direccion domiciliaria laboral {string}")
	public void ingreso_direccion_domiciliaria_laboral(String opcion)
	{
		credifedInfoLaboralPage.ingreso_direccion_domiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.ingreso_direccion_domiciliaria().sendKeys(opcion);
	}
	@When("click en ubicar mapa laboral")
	public void click_btn_ubicar_mapa_laboral()
	{
		SeleniumWaiters.waitSeconds(3);
		credifedInfoLaboralPage.click_btn_ubicar_mapa().click();
	}
	@When("selecciono tipo de referencia laboral {string}")
	public void select_referencia_laboral(String opcion)
	{
		credifedInfoLaboralPage.select_referencia(opcion).click();
	}
	@When("ingreso la referencia laboral {string}")
	public void ingresar_referencia_laboral(String opcion)
	{
		credifedInfoLaboralPage.ingresar_referencia().sendKeys(opcion);
	}
	@When("doy click en aceptar la ubicacion correcta en el mapa laboral")
	public void click_aceptar_ubicar_mapa_laboral()
	{
		credifedInfoLaboralPage.click_aceptar_ubicar_mapa().click();
	}
}
