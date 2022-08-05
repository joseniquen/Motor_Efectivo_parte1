package com.qa.efe.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedInfoLaboralPage {
	private WebDriver driver;

	public CredifedInfoLaboralPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	
	public WebElement getCentroTrabajo() {
		return SeleniumWaiters.findElement(driver, By.id("text-input-UbicacionGeograficaCV1:centroTrabajoText"),10000);
	}
	public WebElement getRucCentroTrabajo() {
		return SeleniumWaiters.findElement(driver, By.id("maskedtext-input-UbicacionGeograficaCV1:rucTrabajoText"),10000);
	}
	public WebElement getTipoTelefonoFijo(String opcion) {
		SeleniumWaiters.findElement(driver, By.id("singleselect-UbicacionGeograficaCV1:telefonoFijoSelect"),10000).click();
		return SeleniumWaiters.findElement(driver, By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:telefonoFijoSelect']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement getTelefonoFijo_lima() {
		return SeleniumWaiters.findElement(driver, By.id("maskedtext-input-UbicacionGeograficaCV1:telefonoLima"),10000);
	}
	public WebElement getTelefonoFijo_otros() {
		return SeleniumWaiters.findElement(driver, By.id("maskedtext-input-UbicacionGeograficaCV1:telefonoOtros"),10000);
	}
	public WebElement getCelular() {
		return SeleniumWaiters.findElement(driver, By.id("maskedtext-input-UbicacionGeograficaCV1:celularTrabajoText"),10000);
	}
	
	public WebElement select_departamento(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:departamentoSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:departamentoSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement select_provincia(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:provinciaSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:provinciaSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement select_distrito(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:distritoSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:distritoSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement ingreso_direccion_domiciliaria()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-UbicacionGeograficaCV1:direccionPrincipalCompleta"),10000);
	}
	public WebElement click_btn_ubicar_mapa()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-UbicacionGeograficaCV1:ubicarMapaButton"),10000);
	}
	public WebElement select_referencia(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:tipoReferenciaSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:tipoReferenciaSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement ingresar_referencia()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-UbicacionGeograficaCV1:referenciaText"),10000);
	}
	public WebElement click_aceptar_ubicar_mapa()
	{
		driver.switchTo().frame(driver.findElement(By.id("framegeo")));
		return SeleniumWaiters.findElement(driver, By.xpath("//a[@id='u-accept']"), 10000);
	}
}
