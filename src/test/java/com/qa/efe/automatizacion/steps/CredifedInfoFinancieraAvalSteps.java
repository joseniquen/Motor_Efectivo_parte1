package com.qa.efe.automatizacion.steps;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedInfoFinancieraAvalPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;

import io.cucumber.java.en.When;

public class CredifedInfoFinancieraAvalSteps {
	private CredifedInfoFinancieraAvalPage credifedInfoFinancieraAvalPage;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	public CredifedInfoFinancieraAvalSteps(CredifedInfoFinancieraAvalPage credifedInfoFinancieraAvalPage,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.credifedInfoFinancieraAvalPage = credifedInfoFinancieraAvalPage;
		this.credifedGeneralidadesPage = credifedGeneralidadesPage;
	}
	
	
	@When("Selecciono perfil de ingreso principal aval {string}")
	public void SeleccionoPerfilIngresoPrincipal(String opcion)
	{
		credifedInfoFinancieraAvalPage.perfilIngresoPrincipal(opcion).click();
	}
	
	@When("Selecciono situacion laboral aval {string}")
	public void seleccionoSituacionLaboral(String opcion)
	{
		credifedInfoFinancieraAvalPage.situacionLaboral(opcion).click();
	}
	
	@When("Selecciono ocupacion aval {string}")
	public void seleccionoOcupacion(String opcion)
	{
		credifedInfoFinancieraAvalPage.seleccionoOcupacion(opcion).click();
	}
	
	@When("Ingreso declarado aval {string}")
	public void ingresoDeclarado(String opcion)
	{
		System.out.println("1"+credifedInfoFinancieraAvalPage.ingresoDeclaradoText().getText());
		System.out.println("2"+credifedInfoFinancieraAvalPage.ingresoDeclaradoText().getAttribute("textContent"));
		System.out.println("3"+credifedInfoFinancieraAvalPage.ingresoDeclaradoText().getAttribute("value"));
		System.out.println("3"+credifedInfoFinancieraAvalPage.ingresoDeclaradoText().getAttribute("innerText"));
		do {
			credifedInfoFinancieraAvalPage.ingresoDeclaradoText().click();
			credifedInfoFinancieraAvalPage.ingresoDeclaradoText().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoFinancieraAvalPage.ingresoDeclaradoText().sendKeys(opcion);
			SeleniumWaiters.waitSeconds(4);
			System.out.println(credifedInfoFinancieraAvalPage.ingresoDeclaradoText().getText());
		} while (credifedInfoFinancieraAvalPage.ingresoDeclaradoText().getAttribute("value").equals("0.00"));
	}
	
	@When("Registro antiguedad laboral aval {string} años y {string} meses")
	public void registroAntiguedadLaboral(String opcion,String opcion1)
	{
		credifedInfoFinancieraAvalPage.antiguedadLaboralAnio().click();
		credifedInfoFinancieraAvalPage.antiguedadLaboralAnio().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoFinancieraAvalPage.antiguedadLaboralAnio().sendKeys(opcion);
		credifedInfoFinancieraAvalPage.antiguedadLaboralMes().click();
		credifedInfoFinancieraAvalPage.antiguedadLaboralMes().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoFinancieraAvalPage.antiguedadLaboralMes().sendKeys(opcion1);
		credifedInfoFinancieraAvalPage.bajarDeudas().click();
	}
	
	@When("Reviso el detalle de deudas subir sustento aval")
	public void revisoDetalleDeudas()
	{
		try {			
			credifedGeneralidadesPage.scrollTo(credifedInfoFinancieraAvalPage.bajarDeudas());			
			List<WebElement> elemento = credifedInfoFinancieraAvalPage.listDetalleDeudas();			
			int fijo = -2;			
			
			for (int i = 0; i < elemento.size(); i++) {	
				 fijo = fijo + 6;
				 String fijoString = String.valueOf(fijo);
				 String ind = String.valueOf(i);			 
				 
					try {
				    credifedInfoFinancieraAvalPage.detalleDeudas(i).click();					
					credifedInfoFinancieraAvalPage.clickSeleccionarArchivoFor(fijoString).click();				
					String[] commands = new String[]{}; 					
					commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};					
					Runtime.getRuntime().exec(commands);			
					SeleniumWaiters.waitSeconds(10);				
					credifedInfoFinancieraAvalPage.clickCargarArchivoForAval(ind).click();				
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
