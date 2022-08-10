package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CotifedConfirmacionSolicitudPage;
import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;
import com.qa.efe.automatizacion.stores.IntegracionStore;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CotifedConfirmacionSolicitudSteps {
	private CotifedConfirmacionSolicitudPage cotifedConfirmacionSolicitudPage;
	private WebDriver driver;
	private CotifedGeneralidadesPage generalidadesPage;
	private CotifedGeneralidadesSteps cotifedGeneralidadesSteps;
	private IntegracionStore integracionStore;

	public CotifedConfirmacionSolicitudSteps( 
			WebDriverManager driverManager, 
			CotifedConfirmacionSolicitudPage cotifedConfirmacionSolicitudPage,
			IntegracionStore integracionStore,
			CotifedGeneralidadesSteps cotifedGeneralidadesSteps
			 ) {
		this.driver = driverManager.getDriver();
		this.cotifedConfirmacionSolicitudPage = cotifedConfirmacionSolicitudPage;
		this.integracionStore=integracionStore;
		this.cotifedGeneralidadesSteps=cotifedGeneralidadesSteps;
	}
	
	@When("Elijo tipo de desembolso {string}")
	public void Elijo_tipo_desembolso(String tipoDesembolso)
	{
		cotifedConfirmacionSolicitudPage.getRdbtipoDesembolso(tipoDesembolso).click();
	}

	@When("Selecciono requisito y cargo archivo")
	public void Selecciono_requisito_y_cargo_archivo (int i)
	{	
		int divs = cotifedConfirmacionSolicitudPage.numRequisitos();
		System.out.println(divs);
		for (i = 0; i < divs; i++) {
			if(i==1) {
				if(integracionStore.tipo_documento.equals("CARNET.EXTRANJERIA")) {
					cotifedConfirmacionSolicitudPage.getSelectTipoRequisitos(i,3).click();
					cotifedConfirmacionSolicitudPage.getClickSeleccionar(i).click();
					cotifedConfirmacionSolicitudPage.getClickInsertar(i).click();
					try { 
						String[] commands = new String[]{}; 
						commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
						Runtime.getRuntime().exec(commands); 
					} catch (IOException e) {}
					System.out.println("aca1");
					cotifedGeneralidadesSteps.pantalla_carga();
					System.out.println("aca2");
					SeleniumWaiters.waitSeconds(5);	
					System.out.println("aca3");
					if(cotifedConfirmacionSolicitudPage.getErrorSharePoint().size()!=0) {
						System.out.println("aca4");
						cotifedConfirmacionSolicitudPage.getBtnOk().click();
						System.out.println("aca5");
						Selecciono_requisito_y_cargo_archivo(i);
						System.out.println("aca6");
					}
				}else if(integracionStore.tipo_documento.equals("D.N.I.")){
					cotifedConfirmacionSolicitudPage.getSelectTipoRequisitos(i,2).click();
					cotifedConfirmacionSolicitudPage.getClickSeleccionar(i).click();
					cotifedConfirmacionSolicitudPage.getClickInsertar(i).click();
					try { 
						String[] commands = new String[]{}; 
						commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
						Runtime.getRuntime().exec(commands); 
					} catch (IOException e) {}
					System.out.println("aca1");
					cotifedGeneralidadesSteps.pantalla_carga();
					System.out.println("aca2");
					SeleniumWaiters.waitSeconds(5);	
					System.out.println("aca3");
					if(cotifedConfirmacionSolicitudPage.getErrorSharePoint().size()!=0) {
						System.out.println("aca4");
						cotifedConfirmacionSolicitudPage.getBtnOk().click();
						System.out.println("aca5");
						Selecciono_requisito_y_cargo_archivo(i);
						System.out.println("aca6");
					}			
				}
			}else if(i==2) {
				if(integracionStore.tipo_documento.equals("CARNET.EXTRANJERIA")) {
					cotifedConfirmacionSolicitudPage.getSelectTipoRequisitos(i,3).click();
					cotifedConfirmacionSolicitudPage.getClickSeleccionar(i).click();
					cotifedConfirmacionSolicitudPage.getClickInsertar(i).click();
					try { 
						String[] commands = new String[]{}; 
						commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
						Runtime.getRuntime().exec(commands); 
					} catch (IOException e) {}
					System.out.println("aca1");
					cotifedGeneralidadesSteps.pantalla_carga();
					System.out.println("aca2");
					SeleniumWaiters.waitSeconds(5);	
					System.out.println("aca3");
					if(cotifedConfirmacionSolicitudPage.getErrorSharePoint().size()!=0) {
						System.out.println("aca4");
						cotifedConfirmacionSolicitudPage.getBtnOk().click();
						System.out.println("aca5");
						Selecciono_requisito_y_cargo_archivo(i);
						System.out.println("aca6");
					}
				}else if(integracionStore.tipo_documento.equals("D.N.I.")){
					cotifedConfirmacionSolicitudPage.getSelectTipoRequisitos(i,2).click();
					cotifedConfirmacionSolicitudPage.getClickSeleccionar(i).click();
					cotifedConfirmacionSolicitudPage.getClickInsertar(i).click();
					try { 
						String[] commands = new String[]{}; 
						commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
						Runtime.getRuntime().exec(commands); 
					} catch (IOException e) {}
					System.out.println("aca1");
					cotifedGeneralidadesSteps.pantalla_carga();
					System.out.println("aca2");
					SeleniumWaiters.waitSeconds(5);	
					System.out.println("aca3");
					if(cotifedConfirmacionSolicitudPage.getErrorSharePoint().size()!=0) {
						System.out.println("aca4");
						cotifedConfirmacionSolicitudPage.getBtnOk().click();
						System.out.println("aca5");
						Selecciono_requisito_y_cargo_archivo(i);
						System.out.println("aca6");
					}
				}
			}else {
				cotifedConfirmacionSolicitudPage.getSelectTipoRequisitos(i,2).click();
				cotifedConfirmacionSolicitudPage.getClickSeleccionar(i).click();
				cotifedConfirmacionSolicitudPage.getClickInsertar(i).click();
				try { 
					String[] commands = new String[]{}; 
					commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
					Runtime.getRuntime().exec(commands); 
				} catch (IOException e) {}
				System.out.println("aca1");
				cotifedGeneralidadesSteps.pantalla_carga();
				System.out.println("aca2");
				SeleniumWaiters.waitSeconds(5);	
				System.out.println("aca3");
				if(cotifedConfirmacionSolicitudPage.getErrorSharePoint().size()!=0) {
					System.out.println("aca4");
					cotifedConfirmacionSolicitudPage.getBtnOk().click();
					System.out.println("aca5");
					Selecciono_requisito_y_cargo_archivo(i);
					System.out.println("aca6");
				}
			}
		}
		
		
	}
	
	@Then("Ingreso referencias telefonicas")
	public void Ingreso_referencias_telefonicas(DataTable referencias) {
		List<Map<String, String>> items = referencias.asMaps(String.class, String.class);
		for (int i = 0; i < items.size(); i++) {
			Map<String, String> item = items.get(i);
			cotifedConfirmacionSolicitudPage.getCbxParentesco().click();
			cotifedConfirmacionSolicitudPage.getOpcionParentesco(item.get("parentesco")).click();
			cotifedConfirmacionSolicitudPage.getTxtNombres().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			cotifedConfirmacionSolicitudPage.getTxtNombres().sendKeys(item.get("nombres"));
			cotifedConfirmacionSolicitudPage.getTxtApellidos().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			cotifedConfirmacionSolicitudPage.getTxtApellidos().sendKeys(item.get("apellidos"));
			cotifedConfirmacionSolicitudPage.getCbxPrefijo().click();
			cotifedConfirmacionSolicitudPage.getOpcionPrefijo(item.get("prefijo")).click();
			cotifedConfirmacionSolicitudPage.getTxtTelefono().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			cotifedConfirmacionSolicitudPage.getTxtTelefono().sendKeys(item.get("telefono_fijo"));
			cotifedConfirmacionSolicitudPage.getTxtCelular().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			cotifedConfirmacionSolicitudPage.getTxtCelular().sendKeys(item.get("celular"));
			cotifedConfirmacionSolicitudPage.getBtnAgregar().click();
			SeleniumWaiters.waitSeconds(5);
		}
	}

	@Then("Doy click en el boton solicitar")
	public void Doy_click_boton_solicitar() {
		cotifedConfirmacionSolicitudPage.getBtnSolicitar().click();
	}
	
	@When("Obtener numero de solicitud")
	public void Obtener_numero_solicitud() {	
		String nroSolicitud = cotifedConfirmacionSolicitudPage.getNroSolicitud().getText();
		System.out.println(nroSolicitud);
	}
	@When("Terminar solicitud")
	public void Terminar_solicitud() {	
		SeleniumWaiters.waitSeconds(7);
		cotifedConfirmacionSolicitudPage.getBtnOk().click();
	}
	
}










