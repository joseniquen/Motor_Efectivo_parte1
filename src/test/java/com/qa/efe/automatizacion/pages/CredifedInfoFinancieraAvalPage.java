package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedInfoFinancieraAvalPage {
	private WebDriver driver;

	public CredifedInfoFinancieraAvalPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public WebElement perfilIngresoPrincipal(String opcion) {
		SeleniumWaiters.findElement(driver, By.id("singleselect-InformacionAdicionalLaboralConyugeCV1:perfilSingle_Select"),10).click();
		return SeleniumWaiters.findElement(driver, By.xpath("//select[@id='singleselect-InformacionAdicionalLaboralConyugeCV1:perfilSingle_Select']/option[contains(.,'"+opcion+"')]"),10);
	}
	public WebElement situacionLaboral(String opcion) {
		SeleniumWaiters.findElement(driver, By.id("singleselect-InformacionAdicionalLaboralConyugeCV1:situacionLaboralSingle_Select"),10).click();
		return SeleniumWaiters.findElement(driver, By.xpath("//select[@id='singleselect-InformacionAdicionalLaboralConyugeCV1:situacionLaboralSingle_Select']/option[contains(.,'"+opcion+"')]"),10);
	}
	public WebElement seleccionoOcupacion(String opcion) {
		SeleniumWaiters.findElement(driver, By.id("singleselect-InformacionAdicionalLaboralConyugeCV1:ocupacionPrincipalSingle_Select"),10).click();
		return SeleniumWaiters.findElement(driver, By.xpath("//select[@id='singleselect-InformacionAdicionalLaboralConyugeCV1:ocupacionPrincipalSingle_Select']/option[contains(.,'"+opcion+"')]"),10);
	}
	public WebElement ingresoDeclaradoText() {
		return SeleniumWaiters.findElement(driver, By.id("decimal-input-InformacionAdicionalLaboralConyugeCV1:nuevoIngresoPrincipalDecimal"),10);
	}
	public WebElement antiguedadLaboralAnio() {
		return SeleniumWaiters.findElement(driver, By.id("decimal-input-InformacionAdicionalLaboralConyugeCV1:antiguedadPrincipalAniosInteger"),10);	 
	}
	public WebElement antiguedadLaboralMes() {
		return SeleniumWaiters.findElement(driver, By.id("decimal-input-InformacionAdicionalLaboralConyugeCV1:antiguedadPrincipalMesesInteger"),10); 
	}	
	public WebElement bajarDeudas() {
		return SeleniumWaiters.findElement(driver, By.xpath("//span[text()='Detalle de Deudas']"),10);
	}
	public WebElement detalleDeudas(int opc) {
		return SeleniumWaiters.findElement(driver, By.id("button-button-InformacionAdicionalLaboralConyugeCV1:listaDeudasTable:sustento1["+opc+"]:AddButton"),10);	 
	}
	public List<WebElement> listDetalleDeudas() {
		return driver.findElements(By.xpath("//*[@id=\"div_13_1_3\"]/div[2]/div[2]/div/table/tbody/tr")); 
	}
	public WebElement clickSeleccionarArchivo() {
		return SeleniumWaiters.findElement(driver, By.xpath("//*[@id=\\\"div_12_1_1_1_1_r4\\\"]//td/div[text()='Select...']"),10);
	}
	public WebElement clickSeleccionarArchivoFor(String param) {
		return SeleniumWaiters.findElement(driver, By.xpath("//*[@id=\"div_12_1_1_1_1_r"+param+"\"]/div/table/tbody/tr[1]/td[1]/div"),10);
	}
	public WebElement clickCargarArchivo() {
		return SeleniumWaiters.findElement(driver, By.xpath("//button[text()=\\\"Cargar\\\"]"),10);		 
	}
	public WebElement clickCargarArchivoFor(String ind) {
		return SeleniumWaiters.findElement(driver, By.xpath("//*[@id=\"button-button-InformacionAdicionalLaboralCV2:listaDeudasTable:sustento1["+ind+"]:UploadButton\"]"),10);
	}
	public WebElement clickCargarArchivoForAval(String ind) {
		return SeleniumWaiters.findElement(driver, By.xpath("//*[@id=\"button-button-InformacionAdicionalLaboralConyugeCV1:listaDeudasTable:sustento1["+ind+"]:UploadButton\"]"),10);
	}
	public WebElement clickCargarArchivoEn() {
		return SeleniumWaiters.findElement(driver, By.xpath("//button[text()=\"Upload\"]"),10);	 
	}	
}
