package com.qa.efe.automatizacion.pages;

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
		SeleniumWaiters.findElement(driver, By.id("singleselect-InformacionAdicionalLaboralCV2:perfilSingle_Select"),10000).click();
		return SeleniumWaiters.findElement(driver, By.xpath("//select[@id='singleselect-InformacionAdicionalLaboralCV2:perfilSingle_Select']/option[contains(.,'"+opcion+"')]"),10000);
	}
	public WebElement situacion_laboral(String opcion) {
		SeleniumWaiters.findElement(driver, By.id("singleselect-InformacionAdicionalLaboralCV2:situacionLaboralSingle_Select"),10000).click();
		return SeleniumWaiters.findElement(driver, By.xpath("//select[@id='singleselect-InformacionAdicionalLaboralCV2:situacionLaboralSingle_Select']/option[contains(.,'"+opcion+"')]"),10000);
	}
	public WebElement selecciono_ocupacion(String opcion) {
		SeleniumWaiters.findElement(driver, By.id("singleselect-InformacionAdicionalLaboralCV2:ocupacionPrincipalSingle_Select"),10000).click();
		return SeleniumWaiters.findElement(driver, By.xpath("//select[@id='singleselect-InformacionAdicionalLaboralCV2:ocupacionPrincipalSingle_Select']/option[contains(.,'"+opcion+"')]"),10000);
	}
	public WebElement ingreso_declarado() {
		return SeleniumWaiters.findElement(driver, By.id("decimal-input-InformacionAdicionalLaboralCV2:nuevoIngresoPrincipalDecimal"),10000);
	}
	
	public void ingreso_declarado(String ingreso) {
		JavascriptExecutor js = (JavascriptExecutor)driver;      
		js.executeScript("document.getElementById('decimal-input-InformacionAdicionalLaboralCV2:nuevoIngresoPrincipalDecimal').value='"+ingreso+"'");
	}
	
	public WebElement antiguedad_laboral_anio() {
		return SeleniumWaiters.findElement(driver, By.id("decimal-input-InformacionAdicionalLaboralCV2:antiguedadPrincipalAniosInteger"),10000);
		 
	}
	public WebElement antiguedad_laboral_mes() {
		return SeleniumWaiters.findElement(driver, By.id("decimal-input-InformacionAdicionalLaboralCV2:antiguedadPrincipalMesesInteger"),10000);
		 
	}
	public WebElement detalle_deudas() {
		return SeleniumWaiters.findElement(driver, By.xpath("//*[@id=\"button-button-InformacionAdicionalLaboralCV2:listaDeudasTable:sustento1[0]:AddButton\"]/span"),10);
		 
	}
	
	
	public WebElement click_seleccionar_Archivo() {
		return SeleniumWaiters.findElement(driver, By.xpath("//*[@id=\"div_12_1_1_1_1_r4\"]//td/div[text()='Seleccionar...']"),10000);
		 
	}
	public WebElement click_cargar_archivo() {
		return SeleniumWaiters.findElement(driver, By.xpath("//button[text()=\"Cargar\"]"),10000);
		 
	}
	
}
