package com.qa.motor.steps;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.qa.motor.config.PropertiesManager;
import com.qa.motor.pages.CotifedLoginPage;
import com.qa.motor.shared.SeleniumWaiters;
import com.qa.motor.shared.devices.managers.WebDriverManager;

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
		;	
	}

	@Then("Ingreso la contraseña {string}")
	public void ingreso_la_contraseña(String contraseña) {
		loginPage.gettxtContrasena().sendKeys(contraseña);
		;		
	}

	@When("doy click en el boton ingresar")
	public void doy_click_en_el_boton_ingresar() {
		loginPage.getbtnIngresar().click();
		;
	}
}
