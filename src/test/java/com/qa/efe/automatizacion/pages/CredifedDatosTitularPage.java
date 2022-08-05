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
	public WebElement click_btn_editar()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-MenuEditarCV1:buttonEditar"),10000);
	}
	public WebElement select_tipo_venta(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:CabeceraSolicitudCV1:tipoVentaSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:CabeceraSolicitudCV1:tipoVentaSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement select_condicion_especial(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:condicionEspecialSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:condicionEspecialSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement select_estado_civil(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:estadoCivilSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:estadoCivilSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement select_pais_nacimiento(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:paisNacimientoSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:paisNacimientoSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement select_pais_residencia(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:paisResidenciaSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:paisResidenciaSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	
	public WebElement ingreso_cel_prinicipal()
	{
		return SeleniumWaiters.findElement(driver,By.id("maskedtext-input-informacionPersonalTitularCV:celularPrincipalText"),10000);
	}
	public WebElement ingreso_cel_secundario()
	{
		return SeleniumWaiters.findElement(driver,By.id("maskedtext-input-informacionPersonalTitularCV:celularSecundarioText"),10000);
	}
	public WebElement select_pais_tel_fijo(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:codigoTelefonoFijoSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonalTitularCV:codigoTelefonoFijoSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement ingreso_telefono_fijo_otros()
	{
		return SeleniumWaiters.findElement(driver,By.id("maskedtext-input-informacionPersonalTitularCV:telefonoOtros"),10000);
	}
	public WebElement ingreso_telefono_fijo_lima()
	{
		return SeleniumWaiters.findElement(driver,By.id("maskedtext-input-informacionPersonalTitularCV:telefonoLima"),10000);
	}
	public WebElement ingreso_correo()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-informacionPersonalTitularCV:correoElectronicoText"),10000);
	}
	
}
