package com.qa.efe.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedDatosAvalPage {
	private WebDriver driver;

	public CredifedDatosAvalPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	
	public WebElement getTipoDocumento()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/span[text()='Tipo de Documento']/parent::div//select"),10);
	}
	
	public WebElement getSelectTipoDocumento(String opcion)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/span[text()='Tipo de Documento']/parent::div//select/option[contains(.,'"+opcion+"')]"),10);
	}
	
	public WebElement getNumeroDocumento() {
		return driver.findElement(By.xpath("//input[@id='text-input-informacionPersonaAvalCV:numeroDocumentoText']"));
	}
	
	public WebElement textNumeroDocumento() {
		return driver.findElement(By.xpath("//span[@id='text-label-informacionPersonaAvalCV:numeroDocumentoText']"));
	}
	public WebElement getCambiarAval() {
		return SeleniumWaiters.findElement(driver,By.id("button-button-CambiarAval1:CambiarAval"),40);
	}
	public WebElement getCambiarAvalAlerta() {
		return driver.findElement(By.xpath("//button[@id='button-button-ModalCambioAvalCV1:buttonAceptar']"));
	}
	public WebElement selectCondicionEspecial(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonaAvalCV:condicionEspecialSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonaAvalCV:condicionEspecialSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	
	public WebElement getEstadoCivil()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/span[text()='Estado Civil']/parent::div//select"),10);
	}
	
	public WebElement getSelectEstadoCivil(String opcion)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/span[text()='Estado Civil']/parent::div//select/option[contains(.,'"+opcion+"')]"),10);
	}
	
	public WebElement getPaisNacimiento()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/span[text()='País de Nacimiento']/parent::div//select"),10);
	}
	
	public WebElement getSelectPaisNacimiento(String opcion)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/span[text()='País de Nacimiento']/parent::div//select/option[contains(.,'"+opcion+"')]"),10);
	}
	
	public WebElement getPaisResidencia()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/span[text()='País de Residencia']/parent::div//select"),10);
	}
	
	public WebElement getSelectPaisResidencia(String opcion)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/span[text()='País de Residencia']/parent::div//select/option[contains(.,'"+opcion+"')]"),10);
	}
	
	public WebElement getCelularPrincipal() {
		
		return  SeleniumWaiters.findElement(driver,By.xpath("//input[@id='maskedtext-input-informacionPersonaAvalCV:celularPrincipalText']"),10);
	}
	
	public WebElement getCelularSecundario() {
			
			return  SeleniumWaiters.findElement(driver,By.xpath("//input[@id='maskedtext-input-informacionPersonaAvalCV:celularSecundarioText']"),10);
	}
	
	public WebElement selectPaisTelFijo(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonaAvalCV:codigoTelefonoFijoSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-informacionPersonaAvalCV:codigoTelefonoFijoSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	
	public WebElement getNumeroFijo() {
		return driver.findElement(By.xpath("//input[@id='maskedtext-input-informacionPersonaAvalCV:telefonoLima']"));
	}
	
	public WebElement getCorreo() {
		return driver.findElement(By.xpath("//input[@id='text-input-informacionPersonaAvalCV:correoElectronicoText']"));
	}
	
}
