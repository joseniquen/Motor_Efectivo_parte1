package com.qa.efe.automatizacion.steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedReferenciaTelfPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class CredifedReferenciaTelfSteps {
	private CredifedReferenciaTelfPage credifedReferenciaTelfPage;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;

	public CredifedReferenciaTelfSteps(CredifedReferenciaTelfPage credifedReferenciaTelfPage,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.credifedReferenciaTelfPage = credifedReferenciaTelfPage;
		this.credifedGeneralidadesPage = credifedGeneralidadesPage;

	}
	@When("Doy click en agregar nueva referencia")
	public void clickNuevaReferencia()
	{
		credifedReferenciaTelfPage.clickNuevaReferencia().click();
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed1("target", "credifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		credifedReferenciaTelfPage.getLugarTelf(lugar_telf).click();
		credifedReferenciaTelfPage.getTelefono().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedReferenciaTelfPage.getTelefono().sendKeys(telefono);
		credifedReferenciaTelfPage.getCelular().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedReferenciaTelfPage.getCelular().sendKeys(celular);
		credifedReferenciaTelfPage.getNombres().sendKeys(nombres);
		credifedReferenciaTelfPage.getApellidos().sendKeys(apellidos);
		credifedReferenciaTelfPage.clickAceptarReferencia().click();
		
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed1("target", "credifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
