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
	
	@When("Doy click en simular {int}")
	public void clickBtnSimular(int a)
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
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Visualizo el resumen de la solicitud {int}")
	public void VisualizarResumenSolicitud(int a)
	{
		
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		credifedOfertaComercialPage.detalleCredito().click();
		SeleniumWaiters.waitSeconds(5);
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SeleniumWaiters.waitSeconds(5);
		credifedOfertaComercialPage.salirDetalleCredito().click();
		
	}
	@When("Doy click en el boton aprobar {int}")
	public void clickBtnAprobar(int a)
	{
		try {
			credifedOfertaComercialPage.clickAprobar().click();
		} catch (Exception e) {
			clickBtnSimular(a);
			credifedOfertaComercialPage.clickAprobar().click();
		}
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Doy click en aceptar solicitud de credito {int}")
	public void clickAceptarSolicitudCredito(int a)
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
				
				verificoPantallaResumenCredito(a);
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
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Verifico que estemos en la pantalla resumen del credito {int}")
	public void verificoPantallaResumenCredito(int a)
	{
		credifedOfertaComercialPage.verificarResumenSol();
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Verifico que la solicitud de credito haya sido aprobada correctamente {int}")
	public void verificarSolicitudAprobada(int a)
	{
		try {
			SeleniumWaiters.findElement(driver,By.xpath("//*[@id='TaskListController_0']//div[text()='No se han encontrado tareas.']"), 30);

		} catch (Exception e) {
			System.out.println("La solicitud contiene Exepciones");
		}
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Doy click en seguro desgravamen con devolucion {int}")
	public void DoyclickSeguroDesgravamenConDevolucion(int a)
	{
		credifedOfertaComercialPage.scrollAval();
		System.out.println(credifedOfertaComercialPage.getRbtConDevolucion());
		credifedOfertaComercialPage.getRbtConDevolucion().click();
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Acepto seguro desgravamen con devolucion {int}")
	public void AceptoSeguroDesgravamenConDevolucion(int a)
	{
		try {
		credifedOfertaComercialPage.getBtnAceptoDesgravamenConDevolucion().click();
		}catch(Exception e){
			
		}	
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
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
	
	@When("Verifico CME del cliente {int}")
	public void verificoCmeCliente(int a)
	{
		//funcion para revisar si sale algun popup de consentimiento, de domicilio, de info laboral, de malla, etc
				SeleniumWaiters.waitSeconds(4);
				int i=credifedGeneralidadesPage.AceptarAlertaRoja().size()-1;
				System.out.println("i"+i);
				try {
					do {
						System.out.println("antes click alerta");
						credifedGeneralidadesPage.AceptarAlertaRoja().get(i).click();
						i=i-1;
						System.out.println("click alerta");
						SeleniumWaiters.waitSeconds(5);
					} while (credifedGeneralidadesPage.verificarAlertaRoja()==true);
				} catch (Exception e) {
				}
				
				
				try {
					credifedGeneralidadesPage.captura_pantalla(a);		} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	}
	
}
