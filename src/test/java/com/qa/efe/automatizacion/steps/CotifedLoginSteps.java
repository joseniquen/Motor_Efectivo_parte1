package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CotifedLoginPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;
import com.qa.efe.automatizacion.stores.File;

public class CotifedLoginSteps {
	private CotifedLoginPage loginPage;
	private WebDriver driver;
	private PropertiesManager propertiesManager;
	private File file;
	private CotifedGeneralidadesPage cotifedGeneralidadesPage;

	public CotifedLoginSteps(PropertiesManager propertiesManager, WebDriverManager driverManager,CotifedGeneralidadesPage cotifedGeneralidadesPage, CotifedLoginPage loginPage, File file
			 ) {
		this.propertiesManager = propertiesManager;
		this.driver = driverManager.getDriver();
		this.loginPage = loginPage;
		this.file=file;
		this.cotifedGeneralidadesPage=cotifedGeneralidadesPage;
	}

	@Given("Ingreso a la pagina de cotifed")
	public void ingresoPaginaCotifed() {
		driver.get(propertiesManager.getProperties().getProperty("cotifed.url"));
	}
	
	@When("Ingreso mi usuario {string}")
	public void ingresoUsuario(String usuario) {
		loginPage.gettxtUsuario().sendKeys(usuario);		
	}

	@When("Ingreso mi contraseña {string}")
	public void ingresoContraseña(String contraseña) {
		loginPage.gettxtContrasena().sendKeys(contraseña);	
	}

	@When("Doy click en el boton ingresar")
	public void doyClickBotonIngresar() {
		loginPage.getbtnIngresar().click();
		cotifedGeneralidadesPage.cargarDatos();
	}
	@When("Valido que no haya sesiones abiertas")
	public void validoQueNoHayaSesionesAbiertas() {
		if(loginPage.getTextSesionAbierta().size()!=0){
			loginPage.getbtnSesionesAbiertas().click();
			SeleniumWaiters.waitSeconds(4);
			loginPage.getbtnIngresar().click();
		}
		cotifedGeneralidadesPage.cargarDatos();
	}
}
