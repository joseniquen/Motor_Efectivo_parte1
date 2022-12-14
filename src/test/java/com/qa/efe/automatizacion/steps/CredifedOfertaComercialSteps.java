package com.qa.efe.automatizacion.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedOfertaComercialPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

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
	
	@When("Doy click en simular")
	public void clickBtnSimular()
	{
		try {
			credifedOfertaComercialPage.clickSimular().click();
			SeleniumWaiters.waitSeconds(3);
			credifedOfertaComercialPage.clickSimular().click();

		} catch (Exception e) {
			credifedOfertaComercialPage.clickSimular().click();
			SeleniumWaiters.waitSeconds(3);
			credifedOfertaComercialPage.clickSimular().click();
		}
	}
	
	@When("Doy click en el boton aprobar")
	public void clickBtnAprobar()
	{
		try {
			credifedOfertaComercialPage.clickAprobar().click();
		} catch (Exception e) {
			clickBtnSimular();
			credifedOfertaComercialPage.clickAprobar().click();
		}
		
	}
	
	@When("Doy click en aceptar solicitud de credito")
	public void clickAceptarSolicitudCredito()
	{
		credifedOfertaComercialPage.clickAceptar().click();
		SeleniumWaiters.waitSeconds(10);
		List<WebElement> element1 = credifedOfertaComercialPage.cuentaConsolicitud();
		List<WebElement> element = credifedOfertaComercialPage.solicitudAprobadaCorrectamente();
		System.out.println("element1"+element1.size());
		System.out.println("element"+element.size());

		if(element.size()!=0 || element1.size()!=0) {
			credifedOfertaComercialPage.clickConfirmar().click();
		}else {
			if(credifedOfertaComercialPage.getValidaSolicitudPendientes()!=null){
				credifedOfertaComercialPage.clickConfirmar().click();
			}
			else {
				credifedOfertaComercialPage.clickValidarAprobacion().click();	
				SeleniumWaiters.waitSeconds(10);
				
				driver.switchTo().defaultContent();
				System.out.println("cambio de inframe a default");
				
				credifedGeneralidadesPage.cambioIframe("Paso: Aprobar Solicitud de Cr??dito");	
				System.out.println("cambio de inframe a Paso: Aprobar Solicitud de Cr??dito");
				
				credifedGeneralidadesPage.cambioIframe("09 Informaci??n Financiera Titular");	
				System.out.println("cambio de inframe a 09 Informaci??n Financiera Titular");
				
				credifedGeneralidadesPage.pesta??asMenu("Oferta Comercial").click();
				SeleniumWaiters.waitSeconds(10);
				
				driver.switchTo().defaultContent();
				System.out.println("cambio de inframe a default");
				
				credifedGeneralidadesPage.cambioIframe("Paso: Aprobar Solicitud de Cr??dito");	
				System.out.println("cambio de inframe a Paso: Aprobar Solicitud de Cr??dito");
				
				credifedGeneralidadesPage.cambioIframe("22 Oferta Comercial");	
				System.out.println("cambio de inframe a 22 Oferta Comercial");
				
				credifedOfertaComercialPage.clickSimular().click();
				SeleniumWaiters.waitSeconds(8);
				try {
					credifedOfertaComercialPage.clickAprobar().click();
				} catch (Exception e) {
					credifedOfertaComercialPage.clickSimular().click();
					SeleniumWaiters.waitSeconds(2);
					credifedOfertaComercialPage.clickSimular().click();
					SeleniumWaiters.waitSeconds(8);
					credifedOfertaComercialPage.clickAprobar().click();
				}
				
				SeleniumWaiters.waitSeconds(7);
				
				driver.switchTo().defaultContent();
				System.out.println("cambio de inframe a default");
				
				credifedGeneralidadesPage.cambioIframe("Paso: Aprobar Solicitud de Cr??dito");	
				System.out.println("cambio de inframe a Paso: Aprobar Solicitud de Cr??dito");
				
				credifedGeneralidadesPage.cambioIframe("Resumen Solicitud");	
				System.out.println("cambio de inframe a Resumen Solicitud");
				
				verificoPantallaResumenCredito();
				credifedOfertaComercialPage.clickAceptar().click();
				SeleniumWaiters.waitSeconds(5);
				if(credifedOfertaComercialPage.getValidaSolicitudPendientes()!=null) {
					credifedOfertaComercialPage.clickConfirmar().click();
				}else {
					credifedOfertaComercialPage.clickConfirmar().click();
				}
			}
		}
	}
	
	@When("Verifico que estemos en la pantalla resumen del credito")
	public void verificoPantallaResumenCredito()
	{
		credifedOfertaComercialPage.verificarResumenSol();
	}
	
	@When("Verifico que la solicitud de credito haya sido aprobada correctamente")
	public void verificarSolicitudAprobada()
	{
		SeleniumWaiters.waitSeconds(30);
		List<WebElement> element = credifedOfertaComercialPage.verificarSolAprobada();
		List<WebElement> element1 = credifedOfertaComercialPage.verificarExcepciones();
		if (element1.size()!=0) {
			System.out.println("La solicitud de credito contiene una excepcion");
		} else {
			System.out.println("Su solicitud ah sido registrada y aprobada correctamente ");
		}
	}
	
	@When("Doy click en seguro desgravamen con devolucion")
	public void DoyclickSeguroDesgravamenConDevolucion()
	{
		credifedOfertaComercialPage.scrollAval();
		System.out.println(credifedOfertaComercialPage.getRbtConDevolucion());
		credifedOfertaComercialPage.getRbtConDevolucion().click();
	}
	
	@When("Acepto seguro desgravamen con devolucion")
	public void AceptoSeguroDesgravamenConDevolucion()
	{
		try {
		credifedOfertaComercialPage.getBtnAceptoDesgravamenConDevolucion().click();
		}catch(Exception e){
			
		}		
	}
	
	@When("Doy click en seguro desgravamen sin devolucion")
	public void DoyclickSeguroDesgravamenSinnDevolucion()
	{
		credifedOfertaComercialPage.scrollAval();
		System.out.println(credifedOfertaComercialPage.getRbtSinDevolucion());
		credifedOfertaComercialPage.getRbtSinDevolucion().click();
	}
	
	@When("Verifico CME del cliente")
	public void verificoCmeCliente()
	{
		try {
			credifedOfertaComercialPage.getBtnCmeCliente().click();
		} catch (Exception e) {
			System.out.print("No sali?? alerta CME");
		}
		
	}
	
}
