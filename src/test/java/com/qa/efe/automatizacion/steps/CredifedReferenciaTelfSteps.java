package com.qa.efe.automatizacion.steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.efe.automatizacion.pages.CredifedReferenciaTelfPage;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class CredifedReferenciaTelfSteps {
	private WebDriver driver;
	private CredifedReferenciaTelfPage credifedReferenciaTelfPage;
	public CredifedReferenciaTelfSteps( WebDriverManager driverManager,CredifedReferenciaTelfPage credifedReferenciaTelfPage) {
		this.driver = driverManager.getDriver();
		this.credifedReferenciaTelfPage = credifedReferenciaTelfPage;
	}
	@When("Doy click en agregar nueva referencia")
	public void clickNuevaReferencia()
	{
		credifedReferenciaTelfPage.click_nueva_referencia().click();
	}
	@When("Creo referencia telefonica")
	public void clickNuevaReferencia(DataTable referencia)
	{
		List<Map<String, String>> items = referencia.asMaps(String.class, String.class);
		Map<String, String> item = items.get(0);
		String parentesco = item.get("parentesco");
		String lugar_telf = item.get("lugar_telf");
		String telefono = item.get("telefono");
		String celular = item.get("celular");
		String nombres = item.get("nombres");
		String apellidos = item.get("apellidos");
		credifedReferenciaTelfPage.getParentesco(parentesco).click();
		credifedReferenciaTelfPage.getLugar_telf(lugar_telf).click();
		credifedReferenciaTelfPage.getTelefono().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedReferenciaTelfPage.getTelefono().sendKeys(telefono);
		credifedReferenciaTelfPage.getCelular().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedReferenciaTelfPage.getCelular().sendKeys(celular);
		credifedReferenciaTelfPage.getNombres().sendKeys(nombres);
		credifedReferenciaTelfPage.getApellidos().sendKeys(apellidos);
		credifedReferenciaTelfPage.click_aceptar_referencia().click();

	}
}
