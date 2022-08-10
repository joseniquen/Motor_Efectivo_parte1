package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CotifedLoginPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CotifedLoginSteps {
	private CotifedLoginPage loginPage;
	private WebDriver driver;
	private PropertiesManager propertiesManager;

	public CotifedLoginSteps(PropertiesManager propertiesManager, WebDriverManager driverManager, CotifedLoginPage loginPage
			 ) {
		this.propertiesManager = propertiesManager;
		this.driver = driverManager.getDriver();
		this.loginPage = loginPage;
	}

	@Given("Abrir login cotifed")
	public void open_LoginCotifed() {
		driver.get(propertiesManager.getProperties().getProperty("cotifed.url"));
	}
	
	@Then("Ingreso el usuario {string}")
	public void ingreso_el_usuario(String usuario) {
		loginPage.gettxtUsuario().sendKeys(usuario);		
	}

	@Then("Ingreso la contraseña {string}")
	public void ingreso_la_contraseña(String contraseña) {
		loginPage.gettxtContrasena().sendKeys(contraseña);	
	}

	@When("doy click en el boton ingresar")
	public void doy_click_en_el_boton_ingresar() {
		loginPage.getbtnIngresar().click();
	}
	@When("valido que no haya sesiones abiertas")
	public void valido_sesiones_abiertas() {
		if(loginPage.getTextSesionAbierta().size()!=0){
			loginPage.getbtnSesionesAbiertas().click();
			SeleniumWaiters.waitSeconds(3);
			loginPage.getbtnSesionesAbiertas().click();

		}
		;
	}
}
