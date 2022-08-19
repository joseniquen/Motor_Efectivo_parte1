package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedDatosTitularPage;

import io.cucumber.java.en.When;

public class CredifedDatosTitularSteps {
	private CredifedDatosTitularPage credifedDatosTitularPage;
	public CredifedDatosTitularSteps(CredifedDatosTitularPage credifedDatosTitularPage) {
		this.credifedDatosTitularPage = credifedDatosTitularPage;
	}
	
	@When("Doy click en boton editar")
	public void clickBtnEditar()
	{
		credifedDatosTitularPage.clickBtnEditar().click();
	}
	
	@When("Selecciono tipo de venta {string}")
	public void seleccionoTipoVenta(String opcion)
	{
		credifedDatosTitularPage.selectTipoVenta(opcion).click();
	}
	
	@When("Selecciono condicion especial {string}")
	public void seleccionoCondicionEspecial(String opcion)
	{
		credifedDatosTitularPage.selectCondicionEspecial(opcion).click();
	}
	
	@When("Selecciono estado civil {string}")
	public void seleccionoEstadoCivi(String opcion)
	{
		credifedDatosTitularPage.selectEstadoCivil(opcion).click();
	}
	
	@When("Selecciono pais de nacimiento {string}")
	public void seleccionoPaisNacimiento(String opcion)
	{
		credifedDatosTitularPage.selectPaisNacimiento(opcion).click();
	}
	
	@When("Selecciono pais de residencia {string}")
	public void SeleccionoPaisResidencia(String opcion)
	{
		credifedDatosTitularPage.selectPaisResidencia(opcion).click();
	}
	
	@When("Ingreso celular principal {string}")
	public void ingresoCelularPrincipal(String opcion)
	{
		credifedDatosTitularPage.ingresoCelPrincipal().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedDatosTitularPage.ingresoCelPrincipal().sendKeys(opcion);
	}
	
	@When("Ingreso celular secundario {string}")
	public void ingresoCelularSecundario(String opcion)
	{
		credifedDatosTitularPage.ingresoCelSecundario().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedDatosTitularPage.ingresoCelSecundario().sendKeys(opcion);
	}
	
	@When("Elijo e ingreso telefono fijo {string} {string}")
	public void elijoIngresoTelefonoFijo(String pais,String nro)
	{
		credifedDatosTitularPage.selectPaisTelFijo(pais).click();
		if(pais.equals("LIMA")) {
			credifedDatosTitularPage.ingresoTelefonoFijoLima().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedDatosTitularPage.ingresoTelefonoFijoLima().sendKeys(nro);
		}else {
			credifedDatosTitularPage.ingresoTelefonoFijoOtros().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedDatosTitularPage.ingresoTelefonoFijoOtros().sendKeys(nro);	
		}	
	}
	
	@When("Ingreso correo electronico {string}")
	public void ingresoCorreo(String opcion)
	{
		credifedDatosTitularPage.ingresoCorreo().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedDatosTitularPage.ingresoCorreo().sendKeys(opcion);
	}
}
