package com.qa.efe.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedReferenciaTelfPage {
	private WebDriver driver;

	public CredifedReferenciaTelfPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public WebElement clickNuevaReferencia() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-RegistroReferenciasCV1:Button1"),10);
	}
	public WebElement getTelefono()
	{
		return SeleniumWaiters.findElement(driver,By.id("maskedtext-input-RegistroReferenciasCV1:CrearReferencia1:telefonoFijo1"),10);
	}
	public WebElement getParentesco(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.id("singleselect-RegistroReferenciasCV1:CrearReferencia1:parentesco1"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-RegistroReferenciasCV1:CrearReferencia1:parentesco1']/option[text()='"+opcion+"']"),10);
	}
	public WebElement getLugarTelf(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.id("singleselect-RegistroReferenciasCV1:CrearReferencia1:codigoTelefonoFijo1"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-RegistroReferenciasCV1:CrearReferencia1:codigoTelefonoFijo1']/option[text()='"+opcion+"']"),10);
	}
	public WebElement getCelular()
	{
		return SeleniumWaiters.findElement(driver,By.id("maskedtext-input-RegistroReferenciasCV1:CrearReferencia1:celular1"),10);
	}
	public WebElement getNombres()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-RegistroReferenciasCV1:CrearReferencia1:nombres1"),10);
	}
	public WebElement getApellidos()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-RegistroReferenciasCV1:CrearReferencia1:apellidos1"),10);
	}
	public WebElement clickAceptarReferencia()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-RegistroReferenciasCV1:aceptarNuevoRefButton"),10);
	}
}
