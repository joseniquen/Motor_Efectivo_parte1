package com.qa.efe.automatizacion.steps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CotifedLoginPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CotifedLoginSteps {
	private CotifedLoginPage loginPage;
	private WebDriver driver;
	private PropertiesManager propertiesManager;
	private CotifedGeneralidadesPage cotifedGeneralidadesPage;

	public CotifedLoginSteps(PropertiesManager propertiesManager, WebDriverManager driverManager,CotifedGeneralidadesPage cotifedGeneralidadesPage, CotifedLoginPage loginPage
			 ) {
		this.propertiesManager = propertiesManager;
		this.driver = driverManager.getDriver();
		this.loginPage = loginPage;
		this.cotifedGeneralidadesPage=cotifedGeneralidadesPage;
	}

	@Given("Ingreso a la pagina de cotifed")
	public void ingresoPaginaCotifed() {
		driver.get(propertiesManager.getProperties().getProperty("cotifed.url"));
	}
	
	@When("Ingreso mi usuario {string}")
	public void ingresoUsuario(String usuario) {
		loginPage.getTxtUsuario().sendKeys(usuario);	
	}

	@And("Ingreso mi contraseña {string}")
	public void ingresoContraseña(String contraseña) {
		loginPage.getTxtContrasena().sendKeys(contraseña);	
	}

	@And("Doy click en el boton ingresar")
	public void doyClickBotonIngresar() {
		loginPage.getBtnIngresar().click();
		cotifedGeneralidadesPage.cargarDatos();
		try {
			cotifedGeneralidadesPage.captura_pantalla_cotifed("target", "cotifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@And("Valido que no haya sesiones abiertas")
	public void validoQueNoHayaSesionesAbiertas() {
		if(loginPage.getTextSesionAbierta().size()!=0){
			loginPage.getBtnSesionesAbiertas().click();
			SeleniumWaiters.waitSeconds(4);
			loginPage.getBtnIngresar().click();
		}else if(loginPage.getTextProblemasConexion().size()!=0){
			SeleniumWaiters.waitSeconds(6);
			loginPage.getBtnIngresar().click();
		}
		cotifedGeneralidadesPage.cargarDatos();
		try {
			cotifedGeneralidadesPage.captura_pantalla_cotifed("target", "cotifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
