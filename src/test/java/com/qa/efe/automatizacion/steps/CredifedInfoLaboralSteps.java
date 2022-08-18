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
			System.out.println("aa");
			credifedInfoLaboralPage.getTelefonoFijo_lima().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoLaboralPage.getTelefonoFijo_lima().sendKeys(nro);
		}else {
			System.out.println("bb");
			credifedInfoLaboralPage.getTelefonoFijo_otros().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoLaboralPage.getTelefonoFijo_otros().sendKeys(nro);	
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
		credifedInfoLaboralPage.select_departamento(opcion).click();
	}
	@When("Selecciono provincia laboral {string}")
	public void seleccionoProvincia_laboral(String opcion)
	{
		credifedInfoLaboralPage.select_provincia(opcion).click();
	}
	@When("Selecciono distrito laboral {string}")
	public void seleccionoDistrito_laboral(String opcion)
	{
		credifedInfoLaboralPage.select_distrito(opcion).click();
	}
	@When("Ingreso direccion domiciliaria laboral {string}")
	public void ingresoDireccionDomiciliariaLaboral(String opcion)
	{
		credifedInfoLaboralPage.ingreso_direccion_domiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.ingreso_direccion_domiciliaria().sendKeys(opcion);
	}
	@When("Doy click en ubicar mapa laboral")
	public void clickBtnUbicarMapaLaboral()
	{
		SeleniumWaiters.waitSeconds(3);
		credifedInfoLaboralPage.click_btn_ubicar_mapa().click();
	}
	@When("Selecciono tipo de referencia laboral {string}")
	public void seleccionoReferenciaLaboral(String opcion)
	{
		credifedInfoLaboralPage.select_referencia(opcion).click();
	}
	@When("Ingreso la referencia laboral {string}")
	public void ingresoReferenciaLaboral(String opcion)
	{
		credifedInfoLaboralPage.ingresar_referencia().sendKeys(opcion);
	}
	@When("Doy click en aceptar la ubicacion correcta en el mapa laboral")
	public void clickAceptarUbicarMapaLaboral()
	{
		credifedInfoLaboralPage.click_aceptar_ubicar_mapa().click();
	}
}
