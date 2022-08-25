package com.qa.efe.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedDatosTitularPage {
	private WebDriver driver;

	public CredifedDatosTitularPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public WebElement clickBtnEditar()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-MenuEditarCV1:buttonEditar"),10);
	}
	public WebElement selectTipoVenta(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:CabeceraSolicitudCV1:tipoVentaSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:CabeceraSolicitudCV1:tipoVentaSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement selectCondicionEspecial(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:condicionEspecialSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:condicionEspecialSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement selectEstadoCivil(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:estadoCivilSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:estadoCivilSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement selectPaisNacimiento(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:paisNacimientoSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:paisNacimientoSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement selectPaisResidencia(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:paisResidenciaSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:paisResidenciaSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement ingresoCelPrincipal()
	{
		return SeleniumWaiters.findElement(driver,By.id("maskedtext-input-informacionPersonalTitularCV:celularPrincipalText"),10);
	}
	public WebElement ingresoCelSecundario()
	{
		return SeleniumWaiters.findElement(driver,By.id("maskedtext-input-informacionPersonalTitularCV:celularSecundarioText"),10);
	}
	public WebElement selectPaisTelFijo(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:codigoTelefonoFijoSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:codigoTelefonoFijoSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement ingresoTelefonoFijoOtros()
	{
		return SeleniumWaiters.findElement(driver,By.id("maskedtext-input-informacionPersonalTitularCV:telefonoOtros"),10);
	}
	public WebElement ingresoTelefonoFijoLima()
	{
		return SeleniumWaiters.findElement(driver,By.id("maskedtext-input-informacionPersonalTitularCV:telefonoLima"),10);
	}
	public WebElement ingresoCorreo()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-informacionPersonalTitularCV:correoElectronicoText"),10);
	}
	public WebElement clickBtnDelivery()
	{
		return driver.findElement(By.id("checkbox-input-informacionPersonalTitularCV:deliveryCheck"));
	}
	
}
