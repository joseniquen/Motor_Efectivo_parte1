package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.efe.automatizacion.pages.CredifedDatosTitularPage;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.When;

public class CredifedDatosTitularSteps {
	private WebDriver driver;
	private CredifedDatosTitularPage credifedDatosTitularPage;
	public CredifedDatosTitularSteps( WebDriverManager driverManager,CredifedDatosTitularPage credifedDatosTitularPage) {
		this.driver = driverManager.getDriver();
		this.credifedDatosTitularPage = credifedDatosTitularPage;
	}
	
	@When("Doy click en boton editar")
	public void clickBtnEditar()
	{
		credifedDatosTitularPage.click_btn_editar().click();
	}
	@When("Selecciono tipo de venta {string}")
	public void seleccionoTipoVenta(String opcion)
	{
		credifedDatosTitularPage.select_tipo_venta(opcion).click();
	}
	@When("Selecciono condicion especial {string}")
	public void seleccionoCondicionEspecial(String opcion)
	{
		credifedDatosTitularPage.select_condicion_especial(opcion).click();
	}
	@When("Selecciono estado civil {string}")
	public void seleccionoEstadoCivi(String opcion)
	{
		credifedDatosTitularPage.select_estado_civil(opcion).click();
	}
	@When("Selecciono pais de nacimiento {string}")
	public void seleccionoPaisNacimiento(String opcion)
	{
		credifedDatosTitularPage.select_pais_nacimiento(opcion).click();
	}
	@When("Selecciono pais de residencia {string}")
	public void SeleccionoPaisResidencia(String opcion)
	{
		credifedDatosTitularPage.select_pais_residencia(opcion).click();
	}
	@When("Ingreso celular principal {string}")
	public void ingresoCelularPrincipal(String opcion)
	{
		credifedDatosTitularPage.ingreso_cel_prinicipal().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedDatosTitularPage.ingreso_cel_prinicipal().sendKeys(opcion);
	}
	@When("Ingreso celular secundario {string}")
	public void ingresoCelularSecundario(String opcion)
	{
		credifedDatosTitularPage.ingreso_cel_secundario().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedDatosTitularPage.ingreso_cel_secundario().sendKeys(opcion);
	}
	@When("Elijo e ingreso telefono fijo {string} {string}")
	public void elijoIngresoTelefonoFijo(String pais,String nro)
	{
		credifedDatosTitularPage.select_pais_tel_fijo(pais).click();
		if(pais.equals("LIMA")) {
			credifedDatosTitularPage.ingreso_telefono_fijo_lima().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedDatosTitularPage.ingreso_telefono_fijo_lima().sendKeys(nro);
		}else {
			credifedDatosTitularPage.ingreso_telefono_fijo_otros().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedDatosTitularPage.ingreso_telefono_fijo_otros().sendKeys(nro);	
		}
		
	}
	@When("Ingreso correo electronico {string}")
	public void ingresoCorreo(String opcion)
	{
		credifedDatosTitularPage.ingreso_correo().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedDatosTitularPage.ingreso_correo().sendKeys(opcion);
	}
}
