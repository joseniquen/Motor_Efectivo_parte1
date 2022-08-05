package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CotifedLoginPage;
import com.qa.efe.automatizacion.pages.CredifedLoginPage;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CredifedLoginSteps {
	private CredifedLoginPage credifedLoginPage;
	private WebDriver driver;
	private PropertiesManager propertiesManager;
	
	public CredifedLoginSteps(PropertiesManager propertiesManager, WebDriverManager driverManager, CredifedLoginPage credifedLoginPage
			 ) {
		this.propertiesManager = propertiesManager;
		this.driver = driverManager.getDriver();
		this.credifedLoginPage = credifedLoginPage;
	}
	@Given("Abrir login cretifed")
	public void open_LoginCotifed() {
		driver.get(propertiesManager.getProperties().getProperty("cretifed.url"));
	}
	@When("Validacion de conexion segura")
	public void conexion_segura_bpm()
	{
		credifedLoginPage.conexion_segura_bpm();
		
	}
	@Then("Ingreso usuario bpm {string}")
	public void ingreso_usuario_bpm(String usuario) {
		credifedLoginPage.getUsuarioBpm().sendKeys(usuario);
		
	}

	@Then("Ingreso contraseña bpm {string}")
	public void ingreso_contraseña_bpm(String contraseña) {
		credifedLoginPage.gettxtContrasenaBpm().sendKeys(contraseña);
			
	}

	@When("doy click en el boton continuar")
	public void doy_click_en_el_boton_ingresar() {
		credifedLoginPage.getbtnContinuar().click();
		
	}
}
