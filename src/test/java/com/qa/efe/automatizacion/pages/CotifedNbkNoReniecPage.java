package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CotifedNbkNoReniecPage {
	private WebDriver driver;

	public CotifedNbkNoReniecPage(WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public WebElement getTxtPrimerNombre()
	{
		return driver.findElement(By.id("firstName"));
	}
	public WebElement getTxtSegundoNombre()
	{
		return driver.findElement(By.id("secondName"));
	}
	public WebElement getTxtApellidoPaterno()
	{
		return driver.findElement(By.id("lastName"));
	}
	public WebElement getTxtApellidoMaterno()
	{
		return driver.findElement(By.id("matLastName"));
	}
	public WebElement getCbxEstadoCivil()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Estado Civil*']/parent::div//select"),10000);
	}
	public WebElement getOpcionEstadoCivil(String estadoCivil)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Estado Civil*']/parent::div//select/option[contains(.,'"+estadoCivil+"')]"),10000);	
	}
	public WebElement getCbxDepartamento()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Departamento*']/parent::div//select"),10000);
	}
	public WebElement getOpcionDepartamento(String departamento)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Departamento*']/parent::div//select/option[contains(.,'"+departamento+"')]"),10000);	
	}
	public WebElement getCbxProvincia()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Provincia*']/parent::div//select"),10000);
	}
	public WebElement getOpcionProvincia(String provincia)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Provincia*']/parent::div//select/option[contains(.,'"+provincia+"')]"),10000);	
	}
	public WebElement getCbxDistrito()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Distrito*']/parent::div//select"),10000);
	}
	public WebElement getOpcionDistrito(String distrito)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Distrito*']/parent::div//select/option[contains(.,'"+distrito+"')]"),10000);	
	}
	public WebElement getCbxTipoVivienda()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Tipo de Vivienda*']/parent::div//select"),10000);
	}
	public WebElement getOpcionTipoVivienda(String tipoVivienda)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Tipo de Vivienda*']/parent::div//select/option[contains(.,'"+tipoVivienda+"')]"),10000);	
	}
	public WebElement getCbxSituacion()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Perfil/Situación*']/parent::div//select"),10000);
	}
	public WebElement getOpcionSituacion(String situacion)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Perfil/Situación*']/parent::div//select/option[contains(.,'"+situacion+"')]"),10000);	
	}
	public WebElement getCbxOcupacion()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Ocupación*']/parent::div//select"),10000);
	}
	public WebElement getOpcionOcupacion(String ocupacion)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Ocupación*']/parent::div//select/option[contains(.,'"+ocupacion+"')]"),10000);	
	}
	public WebElement getTxtIngreso()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Ingreso*']/parent::div//input"),10000);	
	}
	public WebElement getTxtAntLabAnios()
	{
		return driver.findElement(By.id("yearOfEmployment"));
	}
	public WebElement getTxtAntLabMeses()
	{
		return driver.findElement(By.id("monthOfEmployment"));
	}
}