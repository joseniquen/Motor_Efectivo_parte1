package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.When;

public class CredifedInfoFinancieraPage {
	private WebDriver driver;

	public CredifedInfoFinancieraPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public WebElement perfil_ingreso_principal(String opcion) {
		SeleniumWaiters.findElement(driver, By.id("singleselect-InformacionAdicionalLaboralCV2:perfilSingle_Select"),10).click();
		return SeleniumWaiters.findElement(driver, By.xpath("//select[@id='singleselect-InformacionAdicionalLaboralCV2:perfilSingle_Select']/option[contains(.,'"+opcion+"')]"),10);
	}
	public WebElement situacion_laboral(String opcion) {
		SeleniumWaiters.findElement(driver, By.id("singleselect-InformacionAdicionalLaboralCV2:situacionLaboralSingle_Select"),10).click();
		return SeleniumWaiters.findElement(driver, By.xpath("//select[@id='singleselect-InformacionAdicionalLaboralCV2:situacionLaboralSingle_Select']/option[contains(.,'"+opcion+"')]"),10);
	}
	public WebElement selecciono_ocupacion(String opcion) {
		SeleniumWaiters.findElement(driver, By.id("singleselect-InformacionAdicionalLaboralCV2:ocupacionPrincipalSingle_Select"),10).click();
		return SeleniumWaiters.findElement(driver, By.xpath("//select[@id='singleselect-InformacionAdicionalLaboralCV2:ocupacionPrincipalSingle_Select']/option[contains(.,'"+opcion+"')]"),10);
	}
	/*public WebElement ingreso_declarado() {
		return SeleniumWaiters.findElement(driver, By.id("decimal-input-InformacionAdicionalLaboralCV2:nuevoIngresoPrincipalDecimal"),10);
	}*/
	public void ingreso_declarado(String opcion) {
		JavascriptExecutor js = (JavascriptExecutor)driver;      
		js.executeScript("document.getElementById('decimal-input-InformacionAdicionalLaboralCV2:nuevoIngresoPrincipalDecimal').value='"+opcion+"'");
	}
	public WebElement antiguedad_laboral_anio() {
		return SeleniumWaiters.findElement(driver, By.id("decimal-input-InformacionAdicionalLaboralCV2:antiguedadPrincipalAniosInteger"),10);
		 
	}
	public WebElement antiguedad_laboral_mes() {
		return SeleniumWaiters.findElement(driver, By.id("decimal-input-InformacionAdicionalLaboralCV2:antiguedadPrincipalMesesInteger"),10); 
	}	
	
	public WebElement bajar_deudas() {
		return SeleniumWaiters.findElement(driver, By.xpath("//span[text()='Detalle de Deudas']"),10);
	}
	
	public WebElement detalle_deudas(int opc) {
		return SeleniumWaiters.findElement(driver, By.id("button-button-InformacionAdicionalLaboralCV2:listaDeudasTable:sustento1["+opc+"]:AddButton"),10);	 
	}
	public List<WebElement> list_detalle_deudas() {
		return driver.findElements(By.xpath("//*[@id=\"div_13_1_3\"]/div[2]/div[2]/div/table/tbody/tr")); 
	}
	
	public WebElement click_seleccionar_Archivo() {
		return SeleniumWaiters.findElement(driver, By.xpath("//*[@id=\\\"div_12_1_1_1_1_r4\\\"]//td/div[text()='Select...']"),10);
	}
	public WebElement click_seleccionar_ArchivoFor(String param) {
		return SeleniumWaiters.findElement(driver, By.xpath("//*[@id=\"div_12_1_1_1_1_r"+param+"\"]/div/table/tbody/tr[1]/td[1]/div"),10);
	}
	public WebElement click_cargar_archivo() {
		return SeleniumWaiters.findElement(driver, By.xpath("//button[text()=\\\"Cargar\\\"]"),10);		 
	}
	public WebElement click_cargar_archivoFor(String ind) {
		return SeleniumWaiters.findElement(driver, By.xpath("//*[@id=\"button-button-InformacionAdicionalLaboralCV2:listaDeudasTable:sustento1["+ind+"]:UploadButton\"]"),10);
	}
	public WebElement click_cargar_archivo_en() {
		return SeleniumWaiters.findElement(driver, By.xpath("//button[text()=\"Upload\"]"),10);
		 
	}
	
}
