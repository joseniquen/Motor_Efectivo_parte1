package com.qa.motor.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.motor.config.PropertiesManager;
import com.qa.motor.pages.CotifedConfirmacionSolicitudPage;
import com.qa.motor.shared.SeleniumWaiters;
import com.qa.motor.shared.devices.managers.WebDriverManager;

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

	public CotifedConfirmacionSolicitudSteps( WebDriverManager driverManager, CotifedConfirmacionSolicitudPage cotifedConfirmacionSolicitudPage
			 ) {
		this.driver = driverManager.getDriver();
		this.cotifedConfirmacionSolicitudPage = cotifedConfirmacionSolicitudPage;
	}
	
	@When("Selecciono requisito y cargo archivo")
	public void Selecciono_requisito_y_cargo_archivo (DataTable requisitos)
	{
		List<Map<String, String>> items = requisitos.asMaps(String.class, String.class);
		for (int i = 0; i < items.size(); i++) {
			Map<String, String> item = items.get(i);
			//System.out.println("tabla: "+item.get("requisitos"));
			cotifedConfirmacionSolicitudPage.getSelectTipoRequisitos(i,item.get("requisitos")).click();
			cotifedConfirmacionSolicitudPage.getClickSeleccionar(i).click();
			cotifedConfirmacionSolicitudPage.getClickInsertar(i).click();
			try { 
				String[] commands = new String[]{}; 
				commands = new String[]{"C:\\Users\\jniquen\\Downloads\\PhotoUpload"+i+".exe"};
				Runtime.getRuntime().exec(commands); 
			} catch (IOException e) {}
			SeleniumWaiters.waitSeconds(15);
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
		//integrationStore.codePrevent = numbers;
		//return numbers;
	}
	@When("Terminar solicitud")
	public void Terminar_solicitud() {	
		SeleniumWaiters.waitSeconds(7);
		cotifedConfirmacionSolicitudPage.getBtnOk().click();
	}
	
}










