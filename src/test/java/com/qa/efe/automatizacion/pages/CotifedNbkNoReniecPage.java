package com.qa.efe.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	public WebElement getCbxSexo()
	{
		return SeleniumWaiters.findElement(driver, By.xpath("//div/label[text()='Sexo*']/parent::div//select"));
	}
	public WebElement getOpcionSexo(String sexo)
	{
		return SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Sexo*']/parent::div//select/option[contains(.,'"+sexo+"')]"), 10);
	}
	public WebElement getCbxEstadoCivil()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Estado Civil*']/parent::div//select"),10);
	}
	public WebElement getOpcionEstadoCivil(String estadoCivil)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Estado Civil*']/parent::div//select/option[contains(.,'"+estadoCivil+"')]"),10);
	}
	public void getInputNac(String fecha)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('dateOfBirth').removeAttribute('readonly')");	
		driver.findElement(By.id("dateOfBirth")).click();
		driver.findElement(By.id("dateOfBirth")).sendKeys(fecha);
		
	}
	public WebElement getCbxDepartamento()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Departamento*']/parent::div//select"),10);
	}
	public WebElement getOpcionDepartamento(String departamento)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Departamento*']/parent::div//select/option[contains(.,'"+departamento+"')]"),10);	
	}
	public WebElement getCbxProvincia()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Provincia*']/parent::div//select"),10);
	}
	public WebElement getOpcionProvincia(String provincia)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Provincia*']/parent::div//select/option[contains(.,'"+provincia+"')]"),10);	
	}
	public WebElement getCbxDistrito()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Distrito*']/parent::div//select"),10);
	}
	public WebElement getOpcionDistrito(String distrito)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Distrito*']/parent::div//select/option[contains(.,'"+distrito+"')]"),10);	
	}
	public WebElement getCbxTipoVivienda()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Tipo de Vivienda*']/parent::div//select"),10);
	}
	public WebElement getOpcionTipoVivienda(String tipoVivienda)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Tipo de Vivienda*']/parent::div//select/option[contains(.,'"+tipoVivienda+"')]"),10);	
	}
	public WebElement getCbxSituacion()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Perfil/Situación*']/parent::div//select"),10);
	}
	public WebElement getOpcionSituacion(String situacion)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Perfil/Situación*']/parent::div//select/option[contains(.,'"+situacion+"')]"),10);	
	}
	public WebElement getCbxOcupacion()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Ocupación*']/parent::div//select"),10);
	}
	public WebElement getOpcionOcupacion(String ocupacion)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Ocupación*']/parent::div//select/option[contains(.,'"+ocupacion+"')]"),10);	
	}
	public WebElement getTxtIngreso()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Ingreso*']/parent::div//input"),10);	
	}
	public WebElement getTxtAntLabAnios()
	{
		return driver.findElement(By.id("yearOfEmployment"));
	}
	public WebElement getTxtAntLabMeses()
	{
		return driver.findElement(By.id("monthOfEmployment"));
	}
	public boolean validarLink()
	{
		String url = driver.getCurrentUrl();
		return url.contains("nbk-no-reniec");
	}
	public WebElement getBtnFiltrar() 
	{
		return SeleniumWaiters.findElement(driver, By.xpath("/html/body/app-root/app-modules/app-banked-reniec/div[2]/div[1]/div/div/button[2]"));
	}

	public WebElement getAlertTmp()
	{
		return SeleniumWaiters.findElement(driver, By.xpath("/html/body/div[5]/div/div[3]/button[1]"));
	}
}