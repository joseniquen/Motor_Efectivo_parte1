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
	
	@When("doy click en boton editar")
	public void click_btn_editar()
	{
		credifedDatosTitularPage.click_btn_editar().click();
	}
	@When("selecciono tipo de venta {string}")
	public void select_tipo_venta(String opcion)
	{
		credifedDatosTitularPage.select_tipo_venta(opcion).click();
	}
	@When("selecciono condicion especial {string}")
	public void select_condicion_especial(String opcion)
	{
		credifedDatosTitularPage.select_condicion_especial(opcion).click();
	}
	@When("selecciono estado civil {string}")
	public void select_estado_civi(String opcion)
	{
		credifedDatosTitularPage.select_estado_civil(opcion).click();
	}
	@When("selecciono pais de nacimiento {string}")
	public void select_pais_nacimiento(String opcion)
	{
		credifedDatosTitularPage.select_pais_nacimiento(opcion).click();
	}
	@When("selecciono pais de residencia {string}")
	public void select_pais_residencia(String opcion)
	{
		credifedDatosTitularPage.select_pais_residencia(opcion).click();
	}
	@When("ingreso celular principal {string}")
	public void ingreso_cel_prinicipal(String opcion)
	{
		credifedDatosTitularPage.ingreso_cel_prinicipal().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedDatosTitularPage.ingreso_cel_prinicipal().sendKeys(opcion);
	}
	@When("ingreso celular secundario {string}")
	public void ingreso_cel_secundario(String opcion)
	{
		credifedDatosTitularPage.ingreso_cel_secundario().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedDatosTitularPage.ingreso_cel_secundario().sendKeys(opcion);
	}
	@When("elijo e ingreso telefono fijo {string} {string}")
	public void select_pais_tel_fijo(String pais,String nro)
	{
		credifedDatosTitularPage.select_pais_tel_fijo(pais).click();
		if(pais.equals("LIMA")) {
			System.out.println("aa");
			credifedDatosTitularPage.ingreso_telefono_fijo_lima().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedDatosTitularPage.ingreso_telefono_fijo_lima().sendKeys(nro);
		}else {
			System.out.println("bb");
			credifedDatosTitularPage.ingreso_telefono_fijo_otros().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedDatosTitularPage.ingreso_telefono_fijo_otros().sendKeys(nro);	
		}
		
	}
	@When("ingreso correo electronico {string}")
	public void ingreso_correo(String opcion)
	{
		credifedDatosTitularPage.ingreso_correo().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedDatosTitularPage.ingreso_correo().sendKeys(opcion);
	}
}
