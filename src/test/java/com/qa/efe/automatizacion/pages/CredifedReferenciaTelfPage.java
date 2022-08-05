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
	public WebElement click_nueva_referencia() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-RegistroReferenciasCV1:Button1"),10000);
	}
	public WebElement getTelefono()
	{
		return SeleniumWaiters.findElement(driver,By.id("maskedtext-input-RegistroReferenciasCV1:CrearReferencia1:telefonoFijo1"),10000);
	}
	public WebElement getParentesco(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.id("singleselect-RegistroReferenciasCV1:CrearReferencia1:parentesco1"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-RegistroReferenciasCV1:CrearReferencia1:parentesco1']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement getLugar_telf(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.id("singleselect-RegistroReferenciasCV1:CrearReferencia1:codigoTelefonoFijo1"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-RegistroReferenciasCV1:CrearReferencia1:codigoTelefonoFijo1']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement getCelular()
	{
		return SeleniumWaiters.findElement(driver,By.id("maskedtext-input-RegistroReferenciasCV1:CrearReferencia1:celular1"),10000);
	}
	public WebElement getNombres()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-RegistroReferenciasCV1:CrearReferencia1:nombres1"),10000);
	}
	public WebElement getApellidos()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-RegistroReferenciasCV1:CrearReferencia1:apellidos1"),10000);
	}
	public WebElement click_aceptar_referencia()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-RegistroReferenciasCV1:aceptarNuevoRefButton"),10000);
	}
}
