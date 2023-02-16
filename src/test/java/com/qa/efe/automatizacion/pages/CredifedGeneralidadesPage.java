package com.qa.efe.automatizacion.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.NavigationHelpers;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedGeneralidadesPage {
	private WebDriver driver;
	public CredifedGeneralidadesPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public void cambioIframe(String titleIframe)
	{
		driver.switchTo().frame(SeleniumWaiters.findElement(driver,By.xpath("//iframe[@title='"+titleIframe+"']"),50));
	}
	public void iframeDefecto() {
		driver.switchTo().defaultContent();
	}
	public void verificarConsentimientoDigital()
	{
		try {
			WebElement verificar =SeleniumWaiters.findElement(driver,By.xpath("//*[@id='div_19_1_5_2_2_1']"),15); 
			if (verificar.isDisplayed()) {
				SeleniumWaiters.findElement(driver,By.id("button-button-informacionPersonalTitularCV:dialogConsentimiento:Button1"),10).click();
			} 
		} catch (Exception e) {
			System.out.println("No hay error en servicio verificar consentimiento digital");
		} 
	}
	public void verificarErrorEjecutarServicioDireccion()
	{
		try {
			WebElement verificar =SeleniumWaiters.findElement(driver,By.xpath("//*[@id='div_8_1_3_2_1']"),10); 
			if (verificar.isDisplayed()) {
				SeleniumWaiters.findElement(driver,By.id("button-button-InformacionDomiciliariaCV:direccionDisplay:Button1"),10).click();
			} 
		} catch (Exception e) {
			System.out.println("No hay error en servicio verificar direccion");
		}
		
	}
	public void verificarErrorNormalizarDireccion()
	{
		try {
			WebElement verificar =SeleniumWaiters.findElement(driver,By.xpath("//*[@id='div_5_1_3_2_1']"),15); 
			if (verificar.isDisplayed()) {
				SeleniumWaiters.findElement(driver,By.id("button-button-UbicacionGeograficaCV1:direccionPrincipalDisplay:Button1"),10).click();
			} 
		} catch (Exception e) {
			System.out.println("No hay error en servicio dirección");
		}
		
	}
	public void verificarErrorEjecutarFiltroEvaluarDomicilio()
	{
		try {
			WebElement verificar =SeleniumWaiters.findElement(driver,By.xpath("//*[@id='div_10_1_5_4_1_4_2_1']"),10); 
			if (verificar.isDisplayed()) {
				SeleniumWaiters.findElement(driver,By.id("button-button-InformacionDomiciliariaCV:DisplayServiceErrorCV1:Button1"),10).click();
			} 
		} catch (Exception e) {
			System.out.println("No hay error en filtro evaluar domicilio");
		}
		
	}
	public void verificarErrorFiltroPersonas()
	{
		try {
			WebElement verificar =SeleniumWaiters.findElement(driver,By.xpath("//*[@id=\\\"div_19_1_5_13_2_1\\\"]"),15); 
			if (verificar.isDisplayed()) {
				SeleniumWaiters.findElement(driver,By.id("button-button-informacionPersonalTitularCV:displayEDP:Button1"),10).click();
			} 
		} catch (Exception e) {
			System.out.println("No hay error en filtro personas");
		}
		
	}
	public void verificarErrorFiltroInformacionFinanciera()
	{
		try {
			WebElement verificar =SeleniumWaiters.findElement(driver,By.xpath("//*[@id='div_16_1_6_4_1_3_2_1']"),10); 
			if (verificar.isDisplayed()) {
				SeleniumWaiters.findElement(driver,By.id("button-button-InformacionAdicionalLaboralCV2:displayFiltroFinanciero:Button1"),10).click();
			} 
		} catch (Exception e) {
			System.out.println("No hay error en filtro personas");
		}
		
	}
	public void verificarErrorReferenciasTelefonicas()
	{
		try {
			WebElement verificar =SeleniumWaiters.findElement(driver,By.xpath("//*[@id='div_9_1_5_2_2_1']"),10); 
			if (verificar.isDisplayed()) {
				SeleniumWaiters.findElement(driver,By.id("button-button-RegistroReferenciasCV1:minRefTelfErrorCV:Button1"),10).click();
			} 
		} catch (Exception e) {
			System.out.println("No hay error en referencias telefonicas");
		}
		
	}
	public WebElement clickBtnGuardar()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-MenuEditarCV1:buttonGuardar"),10);
	}
	public WebElement clickBtnSobreescribirDatos()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-ModalMenuEditarGuardar:buttonAceptar"),10);
	}
	public WebElement clickBtnContinuar()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//button[text()='Continuar >>']"),10);
	}
	public void scrollTo(WebElement element) {
		NavigationHelpers.scrollToElement(driver, element);
	}
	public WebElement pestañasMenu(String opcion)
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//button[text()='"+opcion+"']"),10);
	}	
	public List<WebElement> validarMenuInicial(String titleIframe)
	{
		return driver.findElements(By.xpath("//iframe[@title='"+titleIframe+"']"));
	}
	
	public List<WebElement> listaIframe()
	{
		return driver.findElements(By.tagName("iframe"));
	}
	
	public WebElement validarMenuInicialCambiar(String titleIframe)
	{
		try {
			return SeleniumWaiters.findElement(driver,By.xpath("//iframe[@title='"+titleIframe+"']"),10);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public List<WebElement> validarMenuInicialIframe()
	{
		return driver.findElements(By.xpath("//iframe[@style='border: 0px; height: 100%; width: 100%; display: block']"));
	}
	public WebElement clickMenuInicialAnalizar()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//div/button[text()='Datos Titular']"),10);
	}	
	public WebElement clickMenuInicialAprobar()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//div/button[text()='Validar Requisitos']"),15);
	}	
	public WebElement clickMenuInicialExepcion()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//div/button[text()='Observaciones']"),15);
	}
}
