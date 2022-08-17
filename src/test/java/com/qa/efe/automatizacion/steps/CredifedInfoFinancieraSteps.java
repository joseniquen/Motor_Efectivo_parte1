package com.qa.efe.automatizacion.steps;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.pages.CotifedConfirmacionSolicitudPage;
import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedInfoFinancieraPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.When;

public class CredifedInfoFinancieraSteps {
	private WebDriver driver;
	private CredifedInfoFinancieraPage credifedInfoFinancieraPage;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	private CotifedConfirmacionSolicitudPage cotifedConfirmacionSolicitudPage;
	public CredifedInfoFinancieraSteps( WebDriverManager driverManager,CredifedInfoFinancieraPage credifedInfoFinancieraPage,CredifedGeneralidadesPage credifedGeneralidadesPage,CotifedConfirmacionSolicitudPage cotifedConfirmacionSolicitudPage) {
		this.driver = driverManager.getDriver();
		this.credifedInfoFinancieraPage = credifedInfoFinancieraPage;
		this.credifedGeneralidadesPage = credifedGeneralidadesPage;
		this.cotifedConfirmacionSolicitudPage=cotifedConfirmacionSolicitudPage;
	}
	@When("Selecciono perfil de ingreso principal {string}")
	public void SeleccionoPerfilIngresoPrincipal(String opcion)
	{
		credifedInfoFinancieraPage.perfil_ingreso_principal(opcion).click();
	}
	@When("Selecciono situacion laboral {string}")
	public void seleccionoSituacionLaboral(String opcion)
	{
		credifedInfoFinancieraPage.situacion_laboral(opcion).click();
	}
	@When("Selecciono ocupacion {string}")
	public void seleccionoOcupacion(String opcion)
	{
		credifedInfoFinancieraPage.selecciono_ocupacion(opcion).click();
	}
	@When("Ingreso declarado {string}")
	public void ingresoDeclarado(String opcion)
	{
		credifedInfoFinancieraPage.ingreso_declarado(opcion);
	}
	@When("Registro antiguedad laboral {string} años y {string} meses")
	public void registroAntiguedadLaboral(String opcion,String opcion1)
	{
		credifedInfoFinancieraPage.antiguedad_laboral_anio().click();
		credifedInfoFinancieraPage.antiguedad_laboral_anio().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoFinancieraPage.antiguedad_laboral_anio().sendKeys(opcion);
		credifedInfoFinancieraPage.antiguedad_laboral_mes().click();
		credifedInfoFinancieraPage.antiguedad_laboral_mes().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoFinancieraPage.antiguedad_laboral_mes().sendKeys(opcion1);
		credifedInfoFinancieraPage.bajar_deudas().click();
	}
	@When("Reviso el detalle de deudas subir sustento")
	public void revisoDetalleDeudas()
	{
		
		try {			
			credifedGeneralidadesPage.scrollTo(credifedInfoFinancieraPage.bajar_deudas());			
			List<WebElement> elemento = credifedInfoFinancieraPage.list_detalle_deudas();			
			int fijo = -2;			
			
			for (int i = 0; i < elemento.size(); i++) {	
				 fijo = fijo + 6;
				 String fijoString = String.valueOf(fijo);
				 String ind = String.valueOf(i);			 
				 
					credifedInfoFinancieraPage.detalle_deudas(i).click();					
					credifedInfoFinancieraPage.click_seleccionar_ArchivoFor(fijoString).click();				
					String[] commands = new String[]{}; 					
					commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};					
					Runtime.getRuntime().exec(commands);			
					SeleniumWaiters.waitSeconds(10);				
					credifedInfoFinancieraPage.click_cargar_archivoFor(ind).click();				
					SeleniumWaiters.waitSeconds(15);
					System.out.println("Archivo N°: "+i+" subido satisfactoriamente.");
			}
			
		} catch (Exception e) {
			System.out.println("No es necesario subir sustento");
		}
		
	}
	
}
