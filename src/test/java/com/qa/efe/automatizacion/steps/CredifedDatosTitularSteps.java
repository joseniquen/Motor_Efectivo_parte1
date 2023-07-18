package com.qa.efe.automatizacion.steps;

import java.io.IOException;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CredifedDatosTitularPage;
import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CredifedDatosTitularSteps {
	private CredifedDatosTitularPage credifedDatosTitularPage;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;

	public CredifedDatosTitularSteps(CredifedDatosTitularPage credifedDatosTitularPage,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.credifedDatosTitularPage = credifedDatosTitularPage;
		this.credifedGeneralidadesPage = credifedGeneralidadesPage;

	}
	
	@When("Doy click en boton editar {int}")
	public void clickBtnEditar(int a)
	{
		credifedDatosTitularPage.clickBtnEditar().click();
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
	
	@When("Selecciono tipo de venta {string}")
	public void seleccionoTipoVenta(String opcion)
	{
		credifedDatosTitularPage.selectTipoVenta(opcion).click();	
	}
	
	@When("Selecciono condicion especial {string}")
	public void seleccionoCondicionEspecial(String opcion)
	{
		credifedDatosTitularPage.selectCondicionEspecial(opcion).click();	
	}
	
	@When("Selecciono estado civil {string}")
	public void seleccionoEstadoCivi(String opcion)
	{
		credifedDatosTitularPage.selectEstadoCivil(opcion).click();	
	}
	
	@When("Selecciono pais de nacimiento {string}")
	public void seleccionoPaisNacimiento(String opcion)
	{
		credifedDatosTitularPage.selectPaisNacimiento(opcion).click();
	}
	
	@When("Selecciono pais de residencia {int} {string}")
	public void SeleccionoPaisResidencia(int a,String opcion)
	{
		credifedDatosTitularPage.selectPaisResidencia(opcion).click();
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
	
	@When("Ingreso celular principal {string}")
	public void ingresoCelularPrincipal(String opcion)
	{
		credifedDatosTitularPage.ingresoCelPrincipal().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedDatosTitularPage.ingresoCelPrincipal().sendKeys(opcion);
	}
	
	@When("Ingreso celular secundario {string}")
	public void ingresoCelularSecundario(String opcion)
	{
		credifedDatosTitularPage.ingresoCelSecundario().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedDatosTitularPage.ingresoCelSecundario().sendKeys(opcion);
	}
	
	@When("Elijo e ingreso telefono fijo {string} {string}")
	public void elijoIngresoTelefonoFijo(String pais,String nro)
	{
		credifedDatosTitularPage.selectPaisTelFijo(pais).click();
		if(pais.equals("LIMA")) {
			credifedDatosTitularPage.ingresoTelefonoFijoLima().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedDatosTitularPage.ingresoTelefonoFijoLima().sendKeys(nro);
		}else {
			credifedDatosTitularPage.ingresoTelefonoFijoOtros().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			credifedDatosTitularPage.ingresoTelefonoFijoOtros().sendKeys(nro);	
		}	
	}
	
	@When("Ingreso correo electronico {int} {string}")
	public void ingresoCorreo(int a,String opcion)
	{
		credifedDatosTitularPage.ingresoCorreo().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		credifedDatosTitularPage.ingresoCorreo().sendKeys(opcion);
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
	
	@And("Doy click en check delivery")
	public void doyClickCheckDelivery()
	{
		credifedDatosTitularPage.clickBtnDelivery().click();
	}
}
