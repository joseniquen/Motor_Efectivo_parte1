package com.qa.efe.automatizacion.steps;

import java.io.IOException;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedDatosTitularPage;
import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedInfoDomiciliariaPage;
import com.qa.efe.automatizacion.pages.CredifedInfoLaboralPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;

import io.cucumber.java.en.When;

public class CredifedInfoDomiciliariaSteps {
	private CredifedInfoDomiciliariaPage credifedInfoDomiciliariaPage;
	private CredifedInfoLaboralPage credifedInfoLaboralPage;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	private CredifedDatosTitularPage credifedDatosTitularPage;

	public CredifedInfoDomiciliariaSteps(CredifedInfoDomiciliariaPage credifedInfoDomiciliariaPage,CredifedInfoLaboralPage credifedInfoLaboralPage,CredifedGeneralidadesPage credifedGeneralidadesPage,CredifedDatosTitularPage credifedDatosTitularPage) {
		this.credifedInfoDomiciliariaPage = credifedInfoDomiciliariaPage;
		this.credifedInfoLaboralPage=credifedInfoLaboralPage;
		this.credifedGeneralidadesPage=credifedGeneralidadesPage;
		this.credifedDatosTitularPage=credifedDatosTitularPage;

	}
	
	@When("Selecciono departamento {string}")
	public void seleccionoDepartamento(String opcion)
	{
		credifedInfoDomiciliariaPage.selectDepartamento(opcion).click();
	}
	
	@When("Selecciono provincia {string}")
	public void seleccionoProvincia(String opcion)
	{
		credifedInfoDomiciliariaPage.selectProvincia(opcion).click();
	}
	
	@When("Selecciono distrito {string}")
	public void seleccionoDistrito(String opcion)
	{
		credifedInfoDomiciliariaPage.selectDistrito(opcion).click();
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed("target", "cotifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Ingreso direccion domiciliaria {string}")
	public void ingresoDireccionDomiciliaria(String opcion)
	{
		credifedInfoDomiciliariaPage.ingresoDireccionDomiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoDomiciliariaPage.ingresoDireccionDomiciliaria().sendKeys(opcion);
	}
	
	@When("Doy click en ubicar mapa")
	public void clickBtnUbicarMapa()
	{
		credifedInfoDomiciliariaPage.clickBtnUbicarMapa().click();
	}
	
	@When("Selecciono tipo de referencia {string}")
	public void seleccionoTipoReferencia(String opcion)
	{
		credifedInfoDomiciliariaPage.selectReferencia(opcion).click();
	}
	
	@When("Ingreso la referencia {string}")
	public void ingresoReferencia(String opcion)
	{
		credifedInfoDomiciliariaPage.ingresarReferencia().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoDomiciliariaPage.ingresarReferencia().sendKeys(opcion);
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed("target", "cotifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Doy click en aceptar la ubicacion correcta en el mapa")
	public void clickAceptarUbicarMapa()
	{
		do {
		} while (credifedInfoLaboralPage.loadingPage()!=null);
		credifedInfoDomiciliariaPage.clickAceptarUbicarMapa().click();
	}
	@When("selecciono via {string}")
	public void selectVia(String opcion)
	{
		try {
			credifedInfoDomiciliariaPage.selectVia(opcion).click();
		} catch (Exception e) {
			credifedGeneralidadesPage.clickBtnGuardar();
			try {
				credifedGeneralidadesPage.clickBtnSobreescribirDatos().click();
			} catch (Exception a) {
				System.out.println("Pasa ok");
			}
			credifedInfoDomiciliariaPage.refreshPage();
			SeleniumWaiters.waitSeconds(6);
			credifedGeneralidadesPage.iframeDefecto();
			credifedGeneralidadesPage.cambioIframe("Paso: Analizar Solicitud de Crédito");
			credifedGeneralidadesPage.cambioIframe("08 Información Domiciliaria Titular");
			credifedDatosTitularPage.clickBtnEditar().click();
			credifedInfoDomiciliariaPage.selectVia(opcion).click();
		}
	}
	@When("Ingreso numero de direccion domiciliaria {string}")
	public void ingresoNumeroDireccionDomiciliaria(String opcion)
	{
		credifedInfoDomiciliariaPage.ingresoNumeroDireccionDomiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoDomiciliariaPage.ingresoNumeroDireccionDomiciliaria().sendKeys(opcion);
	}
	
	@When("Ingreso agrupacion {string}")
	public void ingresoAgrupacion(String opcion)
	{
		credifedInfoDomiciliariaPage.ingresoAgrupacion().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoDomiciliariaPage.ingresoAgrupacion().sendKeys(opcion);
	}
	@When("Ingreso division {string}")
	public void ingresoDivision(String opcion)
	{
		credifedInfoDomiciliariaPage.ingresoDivision().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoDomiciliariaPage.ingresoDivision().sendKeys(opcion);
	}
	@When("Ingreso sub division {string}")
	public void ingresoSubdivision(String opcion)
	{
		credifedInfoDomiciliariaPage.ingresoSubdivision().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoDomiciliariaPage.ingresoSubdivision().sendKeys(opcion);
	}
	@When("Ingreso interior {string}")
	public void ingresoInterior(String opcion)
	{
		credifedInfoDomiciliariaPage.ingresoInterior().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoDomiciliariaPage.ingresoInterior().sendKeys(opcion);
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed("target", "cotifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
