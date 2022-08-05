package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.config.PropertiesManager;
import com.qa.efe.automatizacion.pages.CotifedNbkNoReniecPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CotifedNbkNoReniecSteps {
	private CotifedNbkNoReniecPage cotifedNbkNoReniecPage;
	private WebDriver driver;

	public CotifedNbkNoReniecSteps( WebDriverManager driverManager, CotifedNbkNoReniecPage cotifedNbkNoReniecPage
			 ) {
		this.driver = driverManager.getDriver();
		this.cotifedNbkNoReniecPage = cotifedNbkNoReniecPage;
	}
	
	@Then("Ingreso datos personales")
	public void Ingreso_datos_personales(DataTable datos) {
		List<Map<String, String>> items = datos.asMaps(String.class, String.class);
		for (int i = 0; i < items.size(); i++) {
			Map<String, String> item = items.get(i);
			//cotifedNbkNoReniecPage.getTxtPrimerNombre().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			//cotifedNbkNoReniecPage.getTxtPrimerNombre().sendKeys(item.get("primer_nombre"));
			//cotifedNbkNoReniecPage.getTxtSegundoNombre().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			//cotifedNbkNoReniecPage.getTxtSegundoNombre().sendKeys(item.get("segundo_nombre"));
			//cotifedNbkNoReniecPage.getTxtApellidoPaterno().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			//cotifedNbkNoReniecPage.getTxtApellidoPaterno().sendKeys(item.get("apellido_paterno"));
			//cotifedNbkNoReniecPage.getTxtApellidoMaterno().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			//cotifedNbkNoReniecPage.getTxtApellidoMaterno().sendKeys(item.get("apellido_materno"));
			cotifedNbkNoReniecPage.getCbxEstadoCivil().click();
			cotifedNbkNoReniecPage.getOpcionEstadoCivil(item.get("estado_civil")).click();
			SeleniumWaiters.waitSeconds(3);
		}
	}
	
	@Then("Ingreso informacion de vivienda")
	public void Ingreso_informacion_vivienda(DataTable infoVivienda) {
		List<Map<String, String>> items = infoVivienda.asMaps(String.class, String.class);
		for (int i = 0; i < items.size(); i++) {
			Map<String, String> item = items.get(i);
			cotifedNbkNoReniecPage.getCbxDepartamento().click();
			cotifedNbkNoReniecPage.getOpcionDepartamento(item.get("departamento")).click();
			cotifedNbkNoReniecPage.getCbxProvincia().click();
			cotifedNbkNoReniecPage.getOpcionProvincia(item.get("provincia")).click();
			cotifedNbkNoReniecPage.getCbxDistrito().click();
			cotifedNbkNoReniecPage.getOpcionDistrito(item.get("distrito")).click();
			cotifedNbkNoReniecPage.getCbxTipoVivienda().click();
			cotifedNbkNoReniecPage.getOpcionTipoVivienda(item.get("tipo_vivienda")).click();
			SeleniumWaiters.waitSeconds(3);
		}
	}

	@Then("Ingreso informacion laboral")
	public void Ingreso_informacion_laboral(DataTable infoLaboral) {
		List<Map<String, String>> items = infoLaboral.asMaps(String.class, String.class);
		for (int i = 0; i < items.size(); i++) {
			Map<String, String> item = items.get(i);
			cotifedNbkNoReniecPage.getCbxSituacion().click();
			cotifedNbkNoReniecPage.getOpcionSituacion(item.get("situacion")).click();
			cotifedNbkNoReniecPage.getCbxOcupacion().click();
			cotifedNbkNoReniecPage.getOpcionOcupacion(item.get("ocupacion")).click();
			cotifedNbkNoReniecPage.getTxtIngreso().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			cotifedNbkNoReniecPage.getTxtIngreso().sendKeys(item.get("ingreso"));
			cotifedNbkNoReniecPage.getTxtAntLabAnios().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			cotifedNbkNoReniecPage.getTxtAntLabAnios().sendKeys(item.get("ant_laboral_anios"));
			cotifedNbkNoReniecPage.getTxtAntLabMeses().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			cotifedNbkNoReniecPage.getTxtAntLabMeses().sendKeys(item.get("ant_laboral_meses"));
			SeleniumWaiters.waitSeconds(3);
		}
	}
	
}










