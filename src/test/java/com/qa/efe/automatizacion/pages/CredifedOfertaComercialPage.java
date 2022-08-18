package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedOfertaComercialPage {
	private WebDriver driver;

	public CredifedOfertaComercialPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public WebElement click_simular() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-AprobacionCreditoCV1:btnSimunar"),10);
	}
	public WebElement click_aprobar() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-AprobacionCreditoCV1:AprobarButton"),10);
	}
	public WebElement click_aceptar() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-ResumenSolicitudCV1:Button1"),10);
	}
	public WebElement click_confirmar() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-ResumenSolicitudCV1:confirmarButton"),10);
	}
	public WebElement click_validar_aprobacion() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-ResumenSolicitudCV1:volverButton"),10);
	}
	public List<WebElement> ventana_validar_aprobacion() {
		return driver.findElements(By.id("div_23_1_1_12_1"));
	}
	public WebElement verificar_resumen_sol() {
		return SeleniumWaiters.findElement(driver, By.xpath("//span[contains(.,'La CME de la solicitud ha sido aprobada con éxito.')]"),10);
	}
	
	public List<WebElement> solicitudAprobadaCorrectamente() {
		return driver.findElements(By.xpath("//p[contains(.,'Solicitud aprobada exitosamente.')]"));
	}
	
	public List<WebElement> verificar_sol_aprobada() {
		return driver.findElements(By.xpath("//a[@title='Pulse para trabajar en la tarea']"));
	}
	
	public List<WebElement> verificar_excepciones() {
		return driver.findElements(By.xpath("//*[@id=\"TaskRow_0\"]/div/div[2]"));
	}
}
