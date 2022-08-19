package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedOfertaComercialPage {
	private WebDriver driver;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;

	public CredifedOfertaComercialPage( WebDriverManager driverManager,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.driver = driverManager.getDriver();
		this.credifedGeneralidadesPage=credifedGeneralidadesPage;
	}
	public WebElement clickSimular() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-AprobacionCreditoCV1:btnSimunar"),10);
	}
	public WebElement clickAprobar() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-AprobacionCreditoCV1:AprobarButton"),10);
	}
	public WebElement clickAceptar() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-ResumenSolicitudCV1:Button1"),10);
	}
	public WebElement clickConfirmar() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-ResumenSolicitudCV1:confirmarButton"),10);
	}
	public WebElement clickValidarAprobacion() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-ResumenSolicitudCV1:volverButton"),10);
	}
	public List<WebElement> ventanaValidarAprobacion() {
		return driver.findElements(By.id("div_23_1_1_12_1"));
	}
	public WebElement verificarResumenSol() {
		return SeleniumWaiters.findElement(driver, By.xpath("//span[contains(.,'La CME de la solicitud ha sido aprobada con éxito.')]"),10);
	}
	public void scrollAval() {
		WebElement element= driver.findElement(By.xpath("//div/span[contains(.,'Producto Financiero')]"));
		credifedGeneralidadesPage.scrollTo(element);
	}
	public List<WebElement> solicitudAprobadaCorrectamente() {
		return driver.findElements(By.xpath("//p[contains(.,'Solicitud aprobada exitosamente.')]"));
	}
	public List<WebElement> verificarSolAprobada() {
		return driver.findElements(By.xpath("//a[@title='Pulse para trabajar en la tarea']"));
	}
	public List<WebElement> verificarExcepciones() {
		return driver.findElements(By.xpath("//*[@id=\"TaskRow_0\"]/div/div[2]"));
	}
	public WebElement getRbtConDevolucion() {
		return driver.findElement(By.xpath("//*[@id=\"radiogroup-item-input-AprobacionCreditoCV1:segDesgravamenRadio[1]\"]"));
	}
	public WebElement getBtnAceptoDesgravamenConDevolucion() {
		return SeleniumWaiters.findElement(driver, By.id("modalalert-button-AprobacionCreditoCV1:mallaCrediticiaModal_Alert"),10);
	}
}
