package com.qa.efe.automatizacion.steps;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedInfoFinancieraPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;

import io.cucumber.java.en.When;

public class CredifedInfoFinancieraSteps {
	private CredifedInfoFinancieraPage credifedInfoFinancieraPage;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	public CredifedInfoFinancieraSteps(CredifedInfoFinancieraPage credifedInfoFinancieraPage,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.credifedInfoFinancieraPage = credifedInfoFinancieraPage;
		this.credifedGeneralidadesPage = credifedGeneralidadesPage;
	}
	
	@When("Selecciono perfil de ingreso principal {string}")
	public void SeleccionoPerfilIngresoPrincipal(String opcion)
	{
		credifedInfoFinancieraPage.perfilIngresoPrincipal(opcion).click();
	}
	
	@When("Selecciono situacion laboral {string}")
	public void seleccionoSituacionLaboral(String opcion)
	{
		credifedInfoFinancieraPage.situacionLaboral(opcion).click();
	}
	
	@When("Selecciono ocupacion {string}")
	public void seleccionoOcupacion(String opcion)
	{
		credifedInfoFinancieraPage.seleccionoOcupacion(opcion).click();
	}
	
	@When("Ingreso declarado {string}")
	public void ingresoDeclarado(String opcion)
	{
		credifedInfoFinancieraPage.ingresoDeclarado(opcion);
	}
	
	@When("Registro antiguedad laboral {string} años y {string} meses")
	public void registroAntiguedadLaboral(String opcion,String opcion1)
	{
		credifedInfoFinancieraPage.antiguedadLaboralAnio().click();
		credifedInfoFinancieraPage.antiguedadLaboralAnio().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoFinancieraPage.antiguedadLaboralAnio().sendKeys(opcion);
		credifedInfoFinancieraPage.antiguedadLaboralMes().click();
		credifedInfoFinancieraPage.antiguedadLaboralMes().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoFinancieraPage.antiguedadLaboralMes().sendKeys(opcion1);
		credifedInfoFinancieraPage.bajarDeudas().click();
	}
	
	@When("Reviso el detalle de deudas subir sustento")
	public void revisoDetalleDeudas()
	{
		try {			
			credifedGeneralidadesPage.scrollTo(credifedInfoFinancieraPage.bajarDeudas());			
			List<WebElement> elemento = credifedInfoFinancieraPage.listDetalleDeudas();			
			int fijo = -2;			
			
			for (int i = 0; i < elemento.size(); i++) {	
				 fijo = fijo + 6;
				 String fijoString = String.valueOf(fijo);
				 String ind = String.valueOf(i);			 
				 
					try {
				    credifedInfoFinancieraPage.detalleDeudas(i).click();					
					credifedInfoFinancieraPage.clickSeleccionarArchivoFor(fijoString).click();				
					String[] commands = new String[]{}; 					
					commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};					
					Runtime.getRuntime().exec(commands);			
					SeleniumWaiters.waitSeconds(10);				
					credifedInfoFinancieraPage.clickCargarArchivoFor(ind).click();				
					SeleniumWaiters.waitSeconds(15);
					System.out.println("Archivo N°: "+i+" subido satisfactoriamente.");
					}
					catch(Exception e) {
						System.out.println("Error en la subida de archivo");
					}
			}
			
		} catch (Exception e) {
			System.out.println("No es necesario subir sustento");
		}
		
	}
}
