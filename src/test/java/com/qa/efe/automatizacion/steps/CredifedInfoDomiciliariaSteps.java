package com.qa.efe.automatizacion.steps;

import java.io.IOException;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedDatosTitularPage;
import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedInfoDomiciliariaPage;
import com.qa.efe.automatizacion.pages.CredifedInfoLaboralPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.stores.IntegracionStore;

import io.cucumber.java.en.When;

public class CredifedInfoDomiciliariaSteps {
	private CredifedInfoDomiciliariaPage credifedInfoDomiciliariaPage;
	private CredifedInfoLaboralPage credifedInfoLaboralPage;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	private CredifedDatosTitularPage credifedDatosTitularPage;
	private IntegracionStore integracionStore;

	public CredifedInfoDomiciliariaSteps(CredifedInfoDomiciliariaPage credifedInfoDomiciliariaPage,CredifedInfoLaboralPage credifedInfoLaboralPage,CredifedGeneralidadesPage credifedGeneralidadesPage,CredifedDatosTitularPage credifedDatosTitularPage, IntegracionStore integracionStore) {
		this.credifedInfoDomiciliariaPage = credifedInfoDomiciliariaPage;
		this.credifedInfoLaboralPage=credifedInfoLaboralPage;
		this.credifedGeneralidadesPage=credifedGeneralidadesPage;
		this.credifedDatosTitularPage=credifedDatosTitularPage;
		this.integracionStore=integracionStore;
	}
	
	@When("Selecciono departamento {string}")
	public void seleccionoDepartamento(String opcion)
	{
		credifedInfoDomiciliariaPage.selectDepartamento(opcion).click();
		integracionStore.departamentoDomTitular=opcion;
	}
	
	@When("Selecciono provincia {string}")
	public void seleccionoProvincia(String opcion)
	{
		credifedInfoDomiciliariaPage.selectProvincia(opcion).click();
		integracionStore.provinciaDomTitular=opcion;
	}
	
	@When("Selecciono distrito {int} {string}")
	public void seleccionoDistrito(int a,String opcion)
	{
		credifedInfoDomiciliariaPage.selectDistrito(opcion).click();
		integracionStore.distritoDomTitular=opcion;
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
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
	
	@When("Ingreso la referencia {int} {string}")
	public void ingresoReferencia(int a,String opcion)
	{
		credifedInfoDomiciliariaPage.ingresarReferencia().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoDomiciliariaPage.ingresarReferencia().sendKeys(opcion);
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
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
		do {
			/*credifedGeneralidadesPage.clickBtnGuardar().click();
			SeleniumWaiters.waitSeconds(10);
			try {
				credifedGeneralidadesPage.clickBtnSobreescribirDatos().click();
			} catch (Exception a) {
				System.out.println("Pasa ok");
			}*/
			credifedInfoDomiciliariaPage.refreshPage();
			SeleniumWaiters.waitSeconds(10);
			credifedGeneralidadesPage.iframeDefecto();
			credifedGeneralidadesPage.cambioIframe("Paso: Analizar Solicitud de Crédito");
			credifedGeneralidadesPage.cambioIframe("08 Información Domiciliaria Titular");
			credifedDatosTitularPage.clickBtnEditar().click();	
			credifedInfoDomiciliariaPage.selectDepartamento(integracionStore.departamentoDomTitular).click();
			credifedInfoDomiciliariaPage.selectProvincia(integracionStore.provinciaDomTitular).click();
			credifedInfoDomiciliariaPage.selectDistrito(integracionStore.distritoDomTitular).click();			
		} while (errorVia(opcion)==true);
		SeleniumWaiters.waitSeconds(2);
		credifedGeneralidadesPage.iframeDefecto();
		credifedGeneralidadesPage.cambioIframe("Paso: Analizar Solicitud de Crédito");
		credifedGeneralidadesPage.cambioIframe("08 Información Domiciliaria Titular");
		credifedInfoDomiciliariaPage.selectVia(opcion).click();
	}
	
	public boolean errorVia(String opcion){
		
		if(credifedInfoDomiciliariaPage.selectViaValida(opcion).size()!=0) {
			return false;
		}else {
		return true;
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
	@When("Ingreso interior {int} {string}")
	public void ingresoInterior(int a,String opcion)
	{
		credifedInfoDomiciliariaPage.ingresoInterior().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoDomiciliariaPage.ingresoInterior().sendKeys(opcion);
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
