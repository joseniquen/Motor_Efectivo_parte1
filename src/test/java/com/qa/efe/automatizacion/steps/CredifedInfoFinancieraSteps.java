package com.qa.efe.automatizacion.steps;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedInfoFinancieraPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

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
		//credifedInfoFinancieraPage.ingreso_declarado().click();
		//credifedInfoFinancieraPage.ingreso_declarado().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoFinancieraPage.ingreso_declarado(opcion);
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
		try {
			credifedGeneralidadesPage.scrollTo(credifedInfoFinancieraPage.detalle_deudas(0));
			List<WebElement> elemento = credifedInfoFinancieraPage.list_detalle_deudas();
			for (int i = 0; i < elemento.size(); i++) {
				credifedInfoFinancieraPage.detalle_deudas(i).click();
				credifedInfoFinancieraPage.click_seleccionar_Archivo().click();
				try { 
					String[] commands = new String[]{}; 
					commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
					Runtime.getRuntime().exec(commands); 
				} catch (IOException e) {}
				SeleniumWaiters.waitSeconds(15);
				credifedInfoFinancieraPage.click_cargar_archivo_en().click();
				SeleniumWaiters.waitSeconds(15);
			}
			
		} catch (Exception e) {
			System.out.println("No es necesario subir sustento");
		}
		
	}
	
}
