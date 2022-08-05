package com.qa.motor.steps;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.motor.pages.CredifedGeneralidadesPage;
import com.qa.motor.pages.CredifedInfoFinancieraPage;
import com.qa.motor.shared.SeleniumWaiters;
import com.qa.motor.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.When;

public class CredifedInfoFinancieraSteps {
	private WebDriver driver;
	private CredifedInfoFinancieraPage credifedInfoFinancieraPage;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	public CredifedInfoFinancieraSteps( WebDriverManager driverManager,CredifedInfoFinancieraPage credifedInfoFinancieraPage,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.driver = driverManager.getDriver();
		this.credifedInfoFinancieraPage = credifedInfoFinancieraPage;
		this.credifedGeneralidadesPage = credifedGeneralidadesPage;
	}
	@When("perfil de ingreso principal {string}")
	public void perfil_ingreso_principal(String opcion)
	{
		credifedInfoFinancieraPage.perfil_ingreso_principal(opcion).click();
	}
	@When("selecciono situacion laboral {string}")
	public void situacion_laboral(String opcion)
	{
		credifedInfoFinancieraPage.situacion_laboral(opcion).click();
		//credifedInfoFinancieraPage.situacion_laboral().sendKeys(opcion);
	}
	@When("selecciono ocupacion {string}")
	public void selecciono_ocupacion(String opcion)
	{
		credifedInfoFinancieraPage.selecciono_ocupacion(opcion).click();
		//credifedInfoFinancieraPage.selecciono_ocupacion().sendKeys(opcion);
	}
	@When("ingreso declarado {string}")
	public void ingreso_declarado(String opcion)
	{
		credifedInfoFinancieraPage.ingreso_declarado().click();
		credifedInfoFinancieraPage.ingreso_declarado().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoFinancieraPage.ingreso_declarado().sendKeys(opcion);
	}
	@When("registro antiguedad laboral {string} años y {string} meses")
	public void antiguedad_laboral(String opcion,String opcion1)
	{
		credifedInfoFinancieraPage.antiguedad_laboral_anio().click();
		credifedInfoFinancieraPage.antiguedad_laboral_anio().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoFinancieraPage.antiguedad_laboral_anio().sendKeys(opcion);
		credifedInfoFinancieraPage.antiguedad_laboral_mes().click();
		credifedInfoFinancieraPage.antiguedad_laboral_mes().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoFinancieraPage.antiguedad_laboral_mes().sendKeys(opcion1);
	}
	@When("revisar el detalle de deudas subir sustento")
	public void detalle_deudas()
	{
		
		credifedGeneralidadesPage.scrollTo(credifedInfoFinancieraPage.detalle_deudas());
		credifedInfoFinancieraPage.detalle_deudas().click();
		credifedInfoFinancieraPage.click_seleccionar_Archivo().click();
		try { 
			String[] commands = new String[]{}; 
			commands = new String[]{"C:\\Users\\jniquen\\Downloads\\PhotoUpload.exe"};
			Runtime.getRuntime().exec(commands); 
		} catch (IOException e) {}
		SeleniumWaiters.waitSeconds(15);
		credifedInfoFinancieraPage.click_cargar_archivo().click();
		SeleniumWaiters.waitSeconds(15);
	}
	
}
