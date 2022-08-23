package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedDatosAvalPage;
import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedInfoDomiciliariaAvalPage;

import io.cucumber.java.en.When;

public class CredifedInfoDomiciliariaAvalSteps {
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	private CredifedInfoDomiciliariaAvalPage credifedInfoDomiciliariaAvalPage;
		
		public CredifedInfoDomiciliariaAvalSteps(CredifedGeneralidadesPage credifedGeneralidadesPage, 
				CredifedInfoDomiciliariaAvalPage credifedInfoDomiciliariaAvalPage
				 ) {
			this.credifedGeneralidadesPage=credifedGeneralidadesPage;
			this.credifedInfoDomiciliariaAvalPage=credifedInfoDomiciliariaAvalPage;
		}
		
		@When("Selecciono el tipo de propiedad {string}")
		public void seleccionoTipoPropiedad(String string) {
			credifedInfoDomiciliariaAvalPage.tipoPropiedad(string).click();
		}

		@When("Ingreso antiguedad domiciliaria {string} años y {string} meses")
		public void ingresoAntiguedadDomiciliariaAniosMeses(String string, String string2) {
			credifedInfoDomiciliariaAvalPage.ingresarAntiguedadDomAnios().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoDomiciliariaAvalPage.ingresarAntiguedadDomAnios().sendKeys(string);
			
			credifedInfoDomiciliariaAvalPage.ingresarAntiguedadDomMeses().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedInfoDomiciliariaAvalPage.ingresarAntiguedadDomMeses().sendKeys(string2);
		}
		
		@When("Selecciono departamento aval {string}")
		public void seleccionoDepartamento(String opcion)
		{
			credifedInfoDomiciliariaAvalPage.selectDepartamento(opcion).click();
		}
		
		@When("Selecciono provincia aval {string}")
		public void seleccionoProvincia(String opcion)
		{
			credifedInfoDomiciliariaAvalPage.selectProvincia(opcion).click();
		}
		
		@When("Selecciono distrito aval {string}")
		public void seleccionoDistrito(String opcion)
		{
			credifedInfoDomiciliariaAvalPage.selectDistrito(opcion).click();
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
			credifedInfoDomiciliariaAvalPage.clickBtnUbicarMapa().click();
		}
		
		@When("Doy click en aceptar la ubicacion correcta en el mapa aval")
		public void clickAceptarUbicarMapa()
		{
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
		
		
}
