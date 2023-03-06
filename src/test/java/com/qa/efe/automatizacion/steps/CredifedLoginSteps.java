package com.qa.efe.automatizacion.steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedLoginPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CredifedLoginSteps {
	private CredifedLoginPage credifedLoginPage;
	private WebDriver driver;
	private PropertiesManager propertiesManager;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	
	public CredifedLoginSteps(PropertiesManager propertiesManager, WebDriverManager driverManager, CredifedLoginPage credifedLoginPage
			 ,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.propertiesManager = propertiesManager;
		this.driver = driverManager.getDriver();
		this.credifedLoginPage = credifedLoginPage;
		this.credifedGeneralidadesPage = credifedGeneralidadesPage;

	}
	
	@Given("Ingreso a la pagina de credifed")
	public void open_LoginCotifed() {
		driver.get(propertiesManager.getProperties().getProperty("cretifed.url"));
		
	}
	
	@When("Doy click en conexion segura")
	public void doyClickConexionSegura()
	{
		credifedLoginPage.conexionSeguraBpm();	
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
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed("target", "cotifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@When("Cierro sesion de credifed")
	public void cierroSesionCredifed() {
		System.out.println("1");
		credifedLoginPage.cerrarSesion().click();
		System.out.println("2");
		SeleniumWaiters.waitSeconds(5);
		credifedLoginPage.clickBtnCerrarSesion().click();
		System.out.println("3");
	}
}
