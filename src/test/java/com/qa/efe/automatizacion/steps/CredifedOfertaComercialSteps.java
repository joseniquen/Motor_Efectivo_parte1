package com.qa.efe.automatizacion.steps;

import java.io.IOException;
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
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed2("target", "credifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed2("target", "credifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				
				credifedGeneralidadesPage.cambioIframe("Paso: Aprobar Solicitud de Crédito");	
				System.out.println("cambio de inframe a Paso: Aprobar Solicitud de Crédito");
				
				credifedGeneralidadesPage.cambioIframe("09 Información Financiera Titular");	
				System.out.println("cambio de inframe a 09 Información Financiera Titular");
				
				credifedGeneralidadesPage.pestañasMenu("Oferta Comercial").click();
				SeleniumWaiters.waitSeconds(10);
				
				driver.switchTo().defaultContent();
				System.out.println("cambio de inframe a default");
				
				credifedGeneralidadesPage.cambioIframe("Paso: Aprobar Solicitud de Crédito");	
				System.out.println("cambio de inframe a Paso: Aprobar Solicitud de Crédito");
				
				credifedGeneralidadesPage.cambioIframe("22 Oferta Comercial");	
				System.out.println("cambio de inframe a 22 Oferta Comercial");
				SeleniumWaiters.waitSeconds(8);
				credifedOfertaComercialPage.clickSimular().click();
				SeleniumWaiters.waitSeconds(2);
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
				
				credifedGeneralidadesPage.cambioIframe("Paso: Aprobar Solicitud de Crédito");	
				System.out.println("cambio de inframe a Paso: Aprobar Solicitud de Crédito");
				
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
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed2("target", "credifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Verifico que estemos en la pantalla resumen del credito")
	public void verificoPantallaResumenCredito()
	{
		credifedOfertaComercialPage.verificarResumenSol();
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed2("target", "credifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Verifico que la solicitud de credito haya sido aprobada correctamente")
	public void verificarSolicitudAprobada()
	{
		try {
			SeleniumWaiters.findElement(driver,By.xpath("//*[@id='TaskListController_0']//div[text()='No se han encontrado tareas.']"), 30);

		} catch (Exception e) {
			System.out.println("La solicitud contiene Exepciones");
		}
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed2("target", "credifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Doy click en seguro desgravamen con devolucion")
	public void DoyclickSeguroDesgravamenConDevolucion()
	{
		credifedOfertaComercialPage.scrollAval();
		System.out.println(credifedOfertaComercialPage.getRbtConDevolucion());
		credifedOfertaComercialPage.getRbtConDevolucion().click();
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed2("target", "credifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Acepto seguro desgravamen con devolucion")
	public void AceptoSeguroDesgravamenConDevolucion()
	{
		try {
		credifedOfertaComercialPage.getBtnAceptoDesgravamenConDevolucion().click();
		}catch(Exception e){
			
		}	
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed2("target", "credifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			System.out.print("No salió alerta CME");
		}
		try {
			credifedGeneralidadesPage.captura_pantalla_credifed4("target", "credifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
