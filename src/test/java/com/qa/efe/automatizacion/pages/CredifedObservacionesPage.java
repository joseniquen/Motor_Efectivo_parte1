package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedObservacionesPage {
	private WebDriver driver;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;

	public CredifedObservacionesPage( WebDriverManager driverManager,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.driver = driverManager.getDriver();
		this.credifedGeneralidadesPage=credifedGeneralidadesPage;
	}
	public List<WebElement> listaObservaciones() {
		return driver.findElements(By.xpath("//*[@id=\"div_18_1_2_1_1\"]/div/div/div/table/tbody/tr")); 
	}
	public WebElement getListaObservacion(int ind) {
		return driver.findElement(By.id("textarea-textarea-ObservacionesCV1:observacionesTable:name1["+ind+"]"));
	}
	public void scrollObservaciones() {
		WebElement element = driver.findElement(By.xpath("//div/span[text()='Observaciones']"));
		credifedGeneralidadesPage.scrollTo(element);
	}
	
	public WebElement doyClickBtnActualizar() {
		return driver.findElement(By.id("button-button-ObservacionesCV1:actualizarObservacioesButton"));
	}
	
	
	public WebElement doyClickHabilitarAprobacionExcepcion() {
		return driver.findElement(By.id("checkbox-input-ObservacionesCV1:permitirAprobacionPorExcepcionCheck"));
	}
	public void scrollAprobacionExcepcion() {
		WebElement element = driver.findElement(By.xpath("//div/button[text()='Continuar >>']"));
		credifedGeneralidadesPage.scrollTo(element);
	}
	public WebElement estadoExcepcion(String opcion) {
		SeleniumWaiters.findElement(driver, By.id("singleselect-ObservacionesCV1:AprobacionExepcionCV1:estado_SingleSelect"),10).click();
		return SeleniumWaiters.findElement(driver, By.xpath("//select[@id='singleselect-ObservacionesCV1:AprobacionExepcionCV1:estado_SingleSelect']/option[contains(.,'"+opcion+"')]"),10);
	}
	public WebElement ingresoComentario() {
		return SeleniumWaiters.findElement(driver,By.id("textarea-textarea-ObservacionesCV1:AprobacionExepcionCV1:comentarioFuncionarioText"),10);
	}
	public WebElement ingresoComentarioMesa() {
		return SeleniumWaiters.findElement(driver,By.id("textarea-textarea-ObservacionesCV1:AprobacionExepcionCV1:comentarioAprobadorText"),10);
	}	
	public void scrollBtnAprobacion() {
		WebElement element = driver.findElement(By.xpath("//div/button[text()='Enviar Aprobación por Excepción']"));
		credifedGeneralidadesPage.scrollTo(element);
	}
	public WebElement enviarAprobacionExcepcion() {
		return SeleniumWaiters.findElement(driver,By.id("button-button-ObservacionesCV1:enviarAprobacionExcepcionButton"),10);
	}
	public WebElement doyClickAceptarAprobacionExcepcion() {
		return SeleniumWaiters.findElement(driver,By.id("modalalert-button-Modal_Alert1"),10);
	}
	public void scrollBtnResponderAprobacion() {
		WebElement element = driver.findElement(By.xpath("//div/button[text()='Responder Aprobación por Excepción']"));
		credifedGeneralidadesPage.scrollTo(element);
	}
	public WebElement responderAprobacionExcepcion() {
		return SeleniumWaiters.findElement(driver,By.id("button-button-Button3"),10);
	}
	public WebElement doyClickResponderAprobacionExcepcion() {
		return SeleniumWaiters.findElement(driver,By.id("modalalert-button-Modal_Alert1"),10);
	}
}
