package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.WebDriver;
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

	@When("Ingreso mi contraseña {string}")
	public void ingresoContraseña(String contraseña) {
		loginPage.getTxtContrasena().sendKeys(contraseña);	
	}

	@When("Doy click en el boton ingresar")
	public void doyClickBotonIngresar() {
		loginPage.getBtnIngresar().click();
		cotifedGeneralidadesPage.cargarDatos();
	}
	
	@When("Valido que no haya sesiones abiertas")
	public void validoQueNoHayaSesionesAbiertas() {
		if(loginPage.getTextSesionAbierta().size()!=0){
			loginPage.getBtnSesionesAbiertas().click();
			SeleniumWaiters.waitSeconds(4);
			loginPage.getBtnIngresar().click();
		}
		cotifedGeneralidadesPage.cargarDatos();
	}
}
