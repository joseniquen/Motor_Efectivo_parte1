package com.qa.efe.automatizacion.steps;

import java.io.IOException;
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
	
	@When("Selecciono perfil de ingreso principal {int} {string}")
	public void SeleccionoPerfilIngresoPrincipal(int a,String opcion)
	{
		credifedInfoFinancieraPage.perfilIngresoPrincipal(opcion).click();
		try {
			 switch (a) {
		        case 1:
					credifedGeneralidadesPage.captura_pantalla_credifed_analizar("target", "credifed captura_");
		            break;
		        case 2:
					credifedGeneralidadesPage.captura_pantalla_credifed_enviar_obs("target", "credifed captura_");
		            break;
		        case 3:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar_obs("target", "credifed captura_");
		            break;
		        default:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar("target", "credifed captura_");
		            break;
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		System.out.println("1"+credifedInfoFinancieraPage.ingresoDeclaradoText().getText());
		System.out.println("2"+credifedInfoFinancieraPage.ingresoDeclaradoText().getAttribute("textContent"));
		System.out.println("3"+credifedInfoFinancieraPage.ingresoDeclaradoText().getAttribute("value"));
		System.out.println("3"+credifedInfoFinancieraPage.ingresoDeclaradoText().getAttribute("innerText"));
		do {
			credifedInfoFinancieraPage.ingresoDeclaradoText().click();
			credifedInfoFinancieraPage.ingresoDeclaradoText().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoFinancieraPage.ingresoDeclaradoText().sendKeys(opcion);
			SeleniumWaiters.waitSeconds(4);
			System.out.println(credifedInfoFinancieraPage.ingresoDeclaradoText().getText());
		} while (credifedInfoFinancieraPage.ingresoDeclaradoText().getAttribute("value").equals("0.00"));
	}
	
	@When("Registro antiguedad laboral {string} años y {string} meses {int}")
	public void registroAntiguedadLaboral(String opcion,String opcion1, int a)
	{
		credifedInfoFinancieraPage.antiguedadLaboralAnio().click();
		credifedInfoFinancieraPage.antiguedadLaboralAnio().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoFinancieraPage.antiguedadLaboralAnio().sendKeys(opcion);
		credifedInfoFinancieraPage.antiguedadLaboralMes().click();
		credifedInfoFinancieraPage.antiguedadLaboralMes().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoFinancieraPage.antiguedadLaboralMes().sendKeys(opcion1);
		credifedInfoFinancieraPage.bajarDeudas().click();
		
		try {
			 switch (a) {
		        case 1:
					credifedGeneralidadesPage.captura_pantalla_credifed_analizar("target", "credifed captura_");
		            break;
		        case 2:
					credifedGeneralidadesPage.captura_pantalla_credifed_enviar_obs("target", "credifed captura_");
		            break;
		        case 3:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar_obs("target", "credifed captura_");
		            break;
		        default:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar("target", "credifed captura_");
		            break;
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Reviso el detalle de deudas subir sustento {int}")
	public void revisoDetalleDeudas(int a)
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
		try {
			 switch (a) {
		        case 1:
					credifedGeneralidadesPage.captura_pantalla_credifed_analizar("target", "credifed captura_");
		            break;
		        case 2:
					credifedGeneralidadesPage.captura_pantalla_credifed_enviar_obs("target", "credifed captura_");
		            break;
		        case 3:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar_obs("target", "credifed captura_");
		            break;
		        default:
					credifedGeneralidadesPage.captura_pantalla_credifed_aprobar("target", "credifed captura_");
		            break;
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
