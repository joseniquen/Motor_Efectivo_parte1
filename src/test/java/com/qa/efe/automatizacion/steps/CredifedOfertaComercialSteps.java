package com.qa.efe.automatizacion.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedOfertaComercialPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.When;

public class CredifedOfertaComercialSteps {
	private WebDriver driver;
	private CredifedOfertaComercialPage credifedOfertaComercialPage;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	public CredifedOfertaComercialSteps(CredifedGeneralidadesPage credifedGeneralidadesPage, WebDriverManager driverManager,CredifedOfertaComercialPage credifedOfertaComercialPage) {
		this.driver = driverManager.getDriver();
		this.credifedOfertaComercialPage = credifedOfertaComercialPage;
		this.credifedGeneralidadesPage=credifedGeneralidadesPage;
	}
	@When("doy click en simular")
	public void click_simular()
	{
		credifedOfertaComercialPage.click_simular().click();
	}
	@When("doy click en aprobar")
	public void click_aprobar()
	{
		credifedOfertaComercialPage.click_aprobar().click();
	}
	@When("doy click en aceptar solicitud de credito")
	public void click_aceptar()
	{
		
		credifedOfertaComercialPage.click_aceptar().click();
		SeleniumWaiters.waitSeconds(10);
		List<WebElement> element = credifedOfertaComercialPage.ventana_validar_aprobacion();
		if(element.size()!=0) {
			credifedOfertaComercialPage.click_validar_aprobacion().click();	
			SeleniumWaiters.waitSeconds(10);
			
			driver.switchTo().defaultContent();
			System.out.println("cambio de inframe a default");
			
			credifedGeneralidadesPage.cambioIframe("Paso: Aprobar Solicitud de Crédito");	
			System.out.println("cambio de inframe a Paso: Aprobar Solicitud de Crédito");
			
			credifedGeneralidadesPage.cambioIframe("09 Información Financiera Titular");	
			System.out.println("cambio de inframe a 09 Información Financiera Titular");
			
			credifedGeneralidadesPage.pestañas_menu("Oferta Comercial").click();
			SeleniumWaiters.waitSeconds(10);
			
			driver.switchTo().defaultContent();
			System.out.println("cambio de inframe a default");
			
			credifedGeneralidadesPage.cambioIframe("Paso: Aprobar Solicitud de Crédito");	
			System.out.println("cambio de inframe a Paso: Aprobar Solicitud de Crédito");
			
			credifedGeneralidadesPage.cambioIframe("22 Oferta Comercial");	
			System.out.println("cambio de inframe a 22 Oferta Comercial");
			
			credifedOfertaComercialPage.click_simular().click();
			SeleniumWaiters.waitSeconds(5);
			try {
				credifedOfertaComercialPage.click_aprobar().click();
			} catch (Exception e) {
				credifedOfertaComercialPage.click_simular().click();
				SeleniumWaiters.waitSeconds(5);
				credifedOfertaComercialPage.click_aprobar().click();
			}
			
			SeleniumWaiters.waitSeconds(7);
			
			driver.switchTo().defaultContent();
			System.out.println("cambio de inframe a default");
			
			credifedGeneralidadesPage.cambioIframe("Paso: Aprobar Solicitud de Crédito");	
			System.out.println("cambio de inframe a Paso: Aprobar Solicitud de Crédito");
			
			credifedGeneralidadesPage.cambioIframe("Resumen Solicitud");	
			System.out.println("cambio de inframe a Resumen Solicitud");
			
			verificar_pantalla_resumen();
			credifedOfertaComercialPage.click_aceptar().click();
			SeleniumWaiters.waitSeconds(10);
			
			credifedOfertaComercialPage.click_confirmar().click();
			
		}else {
			System.out.println("antes 1");
			credifedOfertaComercialPage.click_confirmar().click();
			System.out.println("despues 1");
		}
		
	}
	@When("verificar que estemos en la pantalla resumen del credito")
	public void verificar_pantalla_resumen()
	{
		credifedOfertaComercialPage.verificar_resumen_sol();
	}
	@When("verificar que la solicitud de credito haya sido aprobada correctamente")
	public void verificar_sol_aprobada()
	{
		SeleniumWaiters.waitSeconds(30);
		List<WebElement> element = credifedOfertaComercialPage.verificar_sol_aprobada();
		List<WebElement> element1 = credifedOfertaComercialPage.verificar_excepciones();
		if (element1.size()!=0) {
			System.out.println("La solicitud de credito contiene una excepcion");
		} else {
			System.out.println("Su solicitud ah sido registrada y aprobada correctamente ");
		}
	}
}
