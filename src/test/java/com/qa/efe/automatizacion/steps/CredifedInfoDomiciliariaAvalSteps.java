package com.qa.efe.automatizacion.steps;

import java.io.IOException;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedDatosAvalPage;
import com.qa.efe.automatizacion.pages.CredifedDatosTitularPage;
import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedInfoDomiciliariaAvalPage;
import com.qa.efe.automatizacion.pages.CredifedInfoLaboralPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.stores.IntegracionStore;

import io.cucumber.java.en.When;

public class CredifedInfoDomiciliariaAvalSteps {
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	private CredifedInfoDomiciliariaAvalPage credifedInfoDomiciliariaAvalPage;
	private CredifedInfoLaboralPage credifedInfoLaboralPage;
	private CredifedDatosTitularPage credifedDatosTitularPage;
	private IntegracionStore integracionStore;
	private CredifedInfoLaboralAvalSteps credifedInfoLaboralAvalSteps;
		
		public CredifedInfoDomiciliariaAvalSteps(CredifedGeneralidadesPage credifedGeneralidadesPage, 
				CredifedInfoDomiciliariaAvalPage credifedInfoDomiciliariaAvalPage,
				CredifedInfoLaboralPage credifedInfoLaboralPage,CredifedDatosTitularPage credifedDatosTitularPage
				,IntegracionStore integracionStore,CredifedInfoLaboralAvalSteps credifedInfoLaboralAvalSteps
				 ) {
			this.credifedGeneralidadesPage=credifedGeneralidadesPage;
			this.credifedInfoDomiciliariaAvalPage=credifedInfoDomiciliariaAvalPage;
			this.credifedInfoLaboralPage=credifedInfoLaboralPage;
			this.credifedDatosTitularPage=credifedDatosTitularPage;
			this.integracionStore=integracionStore;
			this.credifedInfoLaboralAvalSteps=credifedInfoLaboralAvalSteps;

		}
		
		@When("Selecciono el tipo de propiedad {string}")
		public void seleccionoTipoPropiedad(String string) {
			integracionStore.tipoPropiedadDomTitularAval=string;
			do {
				credifedInfoLaboralPage.refreshPage();
				SeleniumWaiters.waitSeconds(10);
				credifedGeneralidadesPage.iframeDefecto();
				credifedGeneralidadesPage.cambioIframe("Paso: Analizar Solicitud de Crédito");
				credifedGeneralidadesPage.cambioIframe("16 Información Domiciliaria Aval");
				credifedDatosTitularPage.clickBtnEditar().click();		
				credifedInfoDomiciliariaAvalPage.tipoPropiedad(string).click();
			} while (errortipoPropiedad(string)==true);
			SeleniumWaiters.waitSeconds(4);
			credifedGeneralidadesPage.iframeDefecto();
			credifedGeneralidadesPage.cambioIframe("Paso: Analizar Solicitud de Crédito");
			credifedGeneralidadesPage.cambioIframe("16 Información Domiciliaria Aval");
			credifedInfoDomiciliariaAvalPage.tipoPropiedad(string).click();			
		}
		
		public boolean errortipoPropiedad(String opcion){
			
			if(credifedInfoDomiciliariaAvalPage.tipoPropiedadValida(opcion).size()!=0) {
				return false;
			}else {
			return true;
			}
		}
		@When("Ingreso antiguedad domiciliaria {string} años y {string} meses")
		public void ingresoAntiguedadDomiciliariaAniosMeses(String string, String string2) {
			credifedInfoDomiciliariaAvalPage.ingresarAntiguedadDomAnios().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoDomiciliariaAvalPage.ingresarAntiguedadDomAnios().sendKeys(string);
			
			credifedInfoDomiciliariaAvalPage.ingresarAntiguedadDomMeses().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoDomiciliariaAvalPage.ingresarAntiguedadDomMeses().sendKeys(string2);
			
			integracionStore.antiguedadAnioDomTitularAval=string;
			integracionStore.antiguedadMesDomTitularAval=string2;

		}
		
		@When("Selecciono departamento aval {string}")
		public void seleccionoDepartamento(String opcion)
		{
			credifedInfoDomiciliariaAvalPage.selectDepartamento(opcion).click();
			integracionStore.departamentoDomTitularAval=opcion;
		}
		
		@When("Selecciono provincia aval {string}")
		public void seleccionoProvincia(String opcion)
		{
			credifedInfoDomiciliariaAvalPage.selectProvincia(opcion).click();
			integracionStore.provinciaDomTitularAval=opcion;

		}
		
		@When("Selecciono distrito aval {string}")
		public void seleccionoDistrito(String opcion)
		{
			credifedInfoDomiciliariaAvalPage.selectDistrito(opcion).click();
			integracionStore.distritoDomTitularAval=opcion;

		}
		
		@When("Ingreso direccion domiciliaria aval {string}")
		public void ingresoDireccionDomiciliaria(String opcion)
		{
			credifedInfoDomiciliariaAvalPage.ingresoDireccionDomiciliaria().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoDomiciliariaAvalPage.ingresoDireccionDomiciliaria().sendKeys(opcion);
		}
		
		@When("Doy click en ubicar mapa aval")
		public void clickBtnUbicarMapa()
		{
			credifedInfoDomiciliariaAvalPage.scrollReferencia();
			credifedInfoDomiciliariaAvalPage.clickBtnUbicarMapa().click();
		}
		
		@When("Doy click en aceptar la ubicacion correcta en el mapa aval")
		public void clickAceptarUbicarMapa()
		{
			do {
			} while (credifedInfoLaboralPage.loadingPage()!=null);
			credifedInfoDomiciliariaAvalPage.clickAceptarUbicarMapa().click();
		}
		
		@When("Selecciono tipo de referencia aval {string}")
		public void seleccionoTipoReferencia(String opcion)
		{
			credifedInfoDomiciliariaAvalPage.selectReferencia(opcion).click();
		}
		
		@When("Ingreso la referencia aval {string}")
		public void ingresoReferencia(String opcion)
		{
			credifedInfoDomiciliariaAvalPage.ingresarReferencia().sendKeys(opcion);
		}
		@When("selecciono via aval {int} {string}")
		public void selectVia1(int a,String opcion)
		{
			
			do {
				credifedInfoLaboralPage.refreshPage();
				SeleniumWaiters.waitSeconds(8);
				credifedGeneralidadesPage.iframeDefecto();
				credifedGeneralidadesPage.cambioIframe("Paso: Analizar Solicitud de Crédito");
				credifedGeneralidadesPage.cambioIframe("16 Información Domiciliaria Aval");
				credifedDatosTitularPage.clickBtnEditar().click();	
				SeleniumWaiters.waitSeconds(5);
				seleccionoDepartamento(integracionStore.departamentoDomTitularAval);
				seleccionoProvincia(integracionStore.provinciaDomTitularAval);
				seleccionoDistrito(integracionStore.distritoDomTitularAval);
				seleccionoTipoPropiedad(integracionStore.tipoPropiedadDomTitularAval);
				ingresoAntiguedadDomiciliariaAniosMeses(integracionStore.antiguedadAnioDomTitularAval,integracionStore.antiguedadMesDomTitularAval);
			} while (errorVia(opcion)==true);
			SeleniumWaiters.waitSeconds(4);
			credifedGeneralidadesPage.iframeDefecto();
			credifedGeneralidadesPage.cambioIframe("Paso: Analizar Solicitud de Crédito");
			credifedGeneralidadesPage.cambioIframe("16 Información Domiciliaria Aval");
			credifedInfoDomiciliariaAvalPage.selectVia(opcion).click();
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
		@When("selecciono via aval laboral {int} {string}")
		public void selectVia2(int a,String opcion)
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
				credifedGeneralidadesPage.cambioIframe("18 Información Laboral Aval");
				credifedDatosTitularPage.clickBtnEditar().click();	
				credifedInfoLaboralAvalSteps.ingresoCentroTrabajo(integracionStore.centroTrabajolaboralAval);
				credifedInfoLaboralAvalSteps.ingresoRucCentroTrabajo(integracionStore.rucCentroTrabajolaboralAval);
				credifedInfoLaboralAvalSteps.elijoIngresoTelefonoFijoInformacionLaboral(integracionStore.DeptotelFijoLaboralAval,integracionStore.telFijoLaboralAval);
				credifedInfoLaboralAvalSteps.ingresoCelular(integracionStore.celLaboralAval);
				credifedInfoLaboralAvalSteps.seleccionoDepartamentoLaboral(integracionStore.departamentoLaboralTitularAval);
				credifedInfoLaboralAvalSteps.seleccionoProvincia_laboral(integracionStore.provinciaDomLaboralTitularAval);
				credifedInfoLaboralAvalSteps.seleccionoDistrito_laboral(integracionStore.distritoDomLaboralTitularAval);
			} while (errorVia(opcion)==true);
			SeleniumWaiters.waitSeconds(2);
			credifedGeneralidadesPage.iframeDefecto();
			credifedGeneralidadesPage.cambioIframe("Paso: Analizar Solicitud de Crédito");
			credifedGeneralidadesPage.cambioIframe("18 Información Laboral Aval");
			credifedInfoDomiciliariaAvalPage.selectVia(opcion).click();
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
		
		public boolean errorVia(String opcion){
			
			if(credifedInfoDomiciliariaAvalPage.selectViaValida(opcion).size()!=0) {
				return false;
			}else {
			return true;
			}
		}
		
		
}
