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
	@Given("Ingreso a la pagina de credifed")
	public void open_LoginCotifed() {
		driver.get(propertiesManager.getProperties().getProperty("cretifed.url"));
	}
	@When("Doy click en conexion segura")
	public void doyClickConexionSegura()
	{
		credifedLoginPage.conexion_segura_bpm();
		
	}
	@When("Ingreso mi usuario bpm {string}")
	public void ingresoUsuarioBpm(String usuario) {
		credifedLoginPage.getUsuarioBpm().sendKeys(usuario);
		
	}

	@When("Ingreso mi contraseña bpm {string}")
	public void ingresoContraseñaBpm(String contraseña) {
		credifedLoginPage.gettxtContrasenaBpm().sendKeys(contraseña);
			
	}

	@When("Doy click en boton continuar de bpm")
	public void doyClickBotonContinuarBpm() {
		credifedLoginPage.getbtnContinuar().click();
		
	}
}
