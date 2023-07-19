package com.qa.efe.automatizacion.steps;

import java.io.IOException;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedDatosTitularPage;
import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedInfoLaboralPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.stores.IntegracionStore;

import io.cucumber.java.en.When;

public class CredifedInfoLaboralSteps {
	private CredifedInfoLaboralPage credifedInfoLaboralPage;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	private CredifedDatosTitularPage credifedDatosTitularPage;
	private IntegracionStore integracionStore;

	public CredifedInfoLaboralSteps(CredifedInfoLaboralPage credifedInfoLaboralPage,CredifedGeneralidadesPage credifedGeneralidadesPage, CredifedDatosTitularPage credifedDatosTitularPage, IntegracionStore integracionStore) {
		this.credifedInfoLaboralPage = credifedInfoLaboralPage;
		this.credifedGeneralidadesPage = credifedGeneralidadesPage;
		this.credifedDatosTitularPage = credifedDatosTitularPage;
		this.integracionStore = integracionStore;
	}
	
	@When("Ingreso centro de trabajo {string}")
	public void ingresoCentroTrabajo(String opcion) {
		credifedInfoLaboralPage.getCentroTrabajo().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.getCentroTrabajo().sendKeys(opcion);
		integracionStore.centroTrabajolaboral=opcion;
	}
	
	@When("Ingreso ruc de centro de trabajo {string}")
	public void ingresoRucCentroTrabajo(String opcion) {
		credifedInfoLaboralPage.getRucCentroTrabajo().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.getRucCentroTrabajo().sendKeys(opcion);
		integracionStore.rucCentroTrabajolaboral=opcion;
	}
	
	@When("Elijo e ingreso telefono fijo informacion laboral {string} {string}")
	public void elijoIngresoTelefonoFijoInformacionLaboral(String pais,String nro)
	{
		credifedInfoLaboralPage.getTipoTelefonoFijo(pais).click();
		if(pais.equals("LIMA")) {
			credifedInfoLaboralPage.getTelefonoFijoLima().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoLaboralPage.getTelefonoFijoLima().sendKeys(nro);
		}else {
			credifedInfoLaboralPage.getTelefonoFijoOtros().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoLaboralPage.getTelefonoFijoOtros().sendKeys(nro);	
		}	
		integracionStore.DeptotelFijoLaboral=pais;
		integracionStore.telFijoLaboral=nro;
	}
	
	@When("Ingreso celular {int} {string}")
	public void ingresoCelular(int a, String opcion) {
		credifedInfoLaboralPage.getCelular().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.getCelular().sendKeys(opcion);
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		integracionStore.celLaboral=opcion;
	}
	
	@When("Selecciono departamento laboral {string}")
	public void seleccionoDepartamentoLaboral(String opcion)
	{
		credifedInfoLaboralPage.selectDepartamento(opcion).click();
		integracionStore.departamentoLaboralTitular=opcion;
	}
	
	@When("Selecciono provincia laboral {string}")
	public void seleccionoProvincia_laboral(String opcion)
	{
		credifedInfoLaboralPage.selectProvincia(opcion).click();
		integracionStore.provinciaDomLaboralTitular=opcion;
	}
	
	@When("Selecciono distrito laboral {string}")
	public void seleccionoDistrito_laboral(String opcion)
	{
		credifedInfoLaboralPage.selectDistrito(opcion).click();
		integracionStore.distritoDomLaboralTitular=opcion;
	}
	
	@When("Ingreso direccion domiciliaria laboral {string}")
	public void ingresoDireccionDomiciliariaLaboral(String opcion)
	{
		credifedInfoLaboralPage.ingresoDireccionDomiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.ingresoDireccionDomiciliaria().sendKeys(opcion);
	}
	
	@When("Doy click en ubicar mapa laboral")
	public void clickBtnUbicarMapaLaboral()
	{
		SeleniumWaiters.waitSeconds(3);
		credifedInfoLaboralPage.clickBtnUbicarMapa().click();
	}
	
	@When("Selecciono tipo de referencia laboral {string}")
	public void seleccionoReferenciaLaboral(String opcion)
	{
		credifedInfoLaboralPage.selectReferencia(opcion).click();
	}
	
	@When("Ingreso la referencia laboral {int} {string}")
	public void ingresoReferenciaLaboral(int a,String opcion)
	{
		credifedInfoLaboralPage.ingresarReferencia().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.ingresarReferencia().sendKeys(opcion);
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Doy click en aceptar la ubicacion correcta en el mapa laboral")
	public void clickAceptarUbicarMapaLaboral()
	{
		do {
		} while (credifedInfoLaboralPage.loadingPage()!=null);
		credifedInfoLaboralPage.clickAceptarUbicarMapa().click();
	}
	
	@When("selecciono via laboral {int} {string}")
	public void selectVia(int a, String opcion)
	{
		do {
			/*credifedGeneralidadesPage.clickBtnGuardar().click();
			SeleniumWaiters.waitSeconds(10);
			try {	
				credifedGeneralidadesPage.clickBtnSobreescribirDatos().click();
			} catch (Exception a) {
				System.out.println("Pasa ok");
			}*/
			credifedInfoLaboralPage.refreshPage();
			SeleniumWaiters.waitSeconds(6);
			credifedGeneralidadesPage.iframeDefecto();
			credifedGeneralidadesPage.cambioIframe("Paso: Analizar Solicitud de Crédito");
			credifedGeneralidadesPage.cambioIframe("10 Información Laboral Titular");
			credifedDatosTitularPage.clickBtnEditar().click();
			ingresoCentroTrabajo(integracionStore.centroTrabajolaboral);
			ingresoRucCentroTrabajo(integracionStore.rucCentroTrabajolaboral);
			elijoIngresoTelefonoFijoInformacionLaboral(integracionStore.DeptotelFijoLaboral,integracionStore.telFijoLaboral);
			ingresoCelular(a,integracionStore.celLaboral);
			seleccionoDepartamentoLaboral(integracionStore.departamentoLaboralTitular);
			seleccionoProvincia_laboral(integracionStore.provinciaDomLaboralTitular);
			seleccionoDistrito_laboral(integracionStore.distritoDomLaboralTitular);
		} while (errorVia(opcion)==true);
		SeleniumWaiters.waitSeconds(2);
		credifedGeneralidadesPage.iframeDefecto();
		credifedGeneralidadesPage.cambioIframe("Paso: Analizar Solicitud de Crédito");
		credifedGeneralidadesPage.cambioIframe("10 Información Laboral Titular");
		credifedInfoLaboralPage.selectViaLaboral(opcion).click();
	}
	
	public boolean errorVia(String opcion){
		
		if(credifedInfoLaboralPage.selectViaLaboralValida(opcion).size()!=0) {
			return false;
		}else {
		return true;
		}
	}
	
	@When("Ingreso numero de direccion domiciliaria laboral {int} {string}")
	public void ingresoNumeroDireccionDomiciliaria(int a, String opcion)
	{
		credifedInfoLaboralPage.ingresoNumeroDireccionDomiciliariaLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.ingresoNumeroDireccionDomiciliariaLaboral().sendKeys(opcion);
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Ingreso agrupacion laboral {string}")
	public void ingresoAgrupacion(String opcion)
	{
		credifedInfoLaboralPage.ingresoAgrupacionLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.ingresoAgrupacionLaboral().sendKeys(opcion);
	}
	@When("Ingreso division laboral {string}")
	public void ingresoDivision(String opcion)
	{
		credifedInfoLaboralPage.ingresoDivisionLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.ingresoDivisionLaboral().sendKeys(opcion);
	}
	@When("Ingreso sub division laboral {string}")
	public void ingresoSubdivision(String opcion)
	{
		credifedInfoLaboralPage.ingresoSubdivisionLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.ingresoSubdivisionLaboral().sendKeys(opcion);
	}
	@When("Ingreso interior laboral {int} {string}")
	public void ingresoInterior(int a,String opcion)
	{
		credifedInfoLaboralPage.ingresoInteriorLaboral().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedInfoLaboralPage.ingresoInteriorLaboral().sendKeys(opcion);
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
