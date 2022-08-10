package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CotifedDatosAdicionalesPage {
	private WebDriver driver;

	public CotifedDatosAdicionalesPage(WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public WebElement getBtnContinuarDatosAdicionales()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//button[contains(.,'CONTINUAR')]"),10);	
	}
	public WebElement getTxtCorreoPersona()
	{
		return driver.findElement(By.id("email"));
	}
	public WebElement getTxtCelularPersona()
	{
		return driver.findElement(By.id("nroCelularPersona"));
	}
	public WebElement getCbxPrefijoPersona()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Prefijo']/parent::div//select"),10);
	}	
	public WebElement getOpcionCbxPrefijoPersona(String prefijo)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Prefijo']/parent::div//select/option[contains(.,'"+prefijo+"')]"),10);	
	}
	public WebElement getTxtTelefonoPersona()
	{
		return driver.findElement(By.id("nroTelefonoPersona"));
	}
	public WebElement getCbxDepartamentoInfoDomiciliaria()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Departamento(*)']/parent::div//select"),10);
	}	
	public WebElement getOpcionCbxDepartamentoInfoDomiciliaria(String departamento)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Departamento(*)']/parent::div//select/option[contains(.,'"+departamento+"')]"),10);	
	}
	public WebElement getCbxProvinciaInfoDomiciliaria()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Provincia(*)']/parent::div//select"),10);
	}	
	public WebElement getOpcionCbxProvinciaInfoDomiciliaria(String provincia)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Provincia(*)']/parent::div//select/option[contains(.,'"+provincia+"')]"),10);	
	}
	public WebElement getCbxDistritoInfoDomiciliaria()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Distrito(*)']/parent::div//select"),10);
	}	
	public WebElement getOpcionCbxDistritoInfoDomiciliaria(String distrito)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Distrito(*)']/parent::div//select/option[contains(.,'"+distrito+"')]"),10);	
	}
	public WebElement getTxtAvenidaInfoDomiciliaria()
	{
		return driver.findElement(By.id("nombreVia"));
	}
	public WebElement getBtnConfirmarInfoDomiciliaria()
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='framegeo']")));
		System.out.println("cambio de iframe");
		SeleniumWaiters.waitSeconds(4);
		return  SeleniumWaiters.findElement(driver,By.xpath("//*[@id='u-accept']"),10);
	}
	public WebElement getCbxReferenciaInfoDomiciliaria()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Referencia(*)']/parent::div//select"),10);
	}	
	public WebElement getOpcionCbxReferenciaInfoDomiciliaria(String referencia)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Referencia(*)']/parent::div//select/option[contains(.,'"+referencia+"')]"),10);	
	}
	public WebElement getTxtDescripcionInfoDomiciliaria()
	{
		return driver.findElement(By.id("nombreReferencia"));
	}
	public WebElement getTxtCentroInfoLaboral()
	{
		return driver.findElement(By.id("nombreCentroTrabajo"));
	}
	public WebElement getCbxPrefijoInfoLaboral()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("/html/body//div/div/form/div[4]/div/div[2]/div/div[2]/select"),10);
	}	
	public WebElement getOpcionCbxPrefijoInfoLaboral(String prefijo)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("/html/body//div/div/form/div[4]/div/div[2]/div/div[2]/select/option[contains(.,'"+prefijo+"')]"),10);	
	}
	public WebElement getTxtTelefonoInfoLaboral()
	{
		return driver.findElement(By.id("nroTelefono"));
	}
	public WebElement getTxtCelularInfoLaboral()
	{
		return driver.findElement(By.id("nroCelular"));
	}
	public WebElement getTxtRucInfoLaboral()
	{
		return driver.findElement(By.id("rucCentroTrabajo"));
	}
	//***************
	public WebElement getCbxDepartamentoInfoLaboral()
	{
		 return driver.findElement(By.id("codDepartamentoWork"));
	}	
	public WebElement getOpcionCbxDepartamentoInfoLaboral(String departamento)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//select[@id='codDepartamentoWork']/option[contains(.,'"+departamento+"')]"),10);	
	}
	public WebElement getCbxProvinciaInfoLaboral()
	{
		 return driver.findElement(By.id("codProvinciaWork"));
	}	
	public WebElement getOpcionCbxProvinciaInfoLaboral(String provincia)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//select[@id='codProvinciaWork']/option[contains(.,'"+provincia+"')]"),10);	
	}
	public WebElement getCbxDistritoInfoLaboral()
	{
		return driver.findElement(By.id("codDistritoWork"));
	}	
	public WebElement getOpcionCbxDistritoInfoLaboral(String distrito)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//select[@id='codDistritoWork']/option[contains(.,'"+distrito+"')]"),10);	
	}
	public WebElement getTxtAvenidaInfoLaboral()
	{
		return driver.findElement(By.id("nombreViaWork"));
	}
	public WebElement getBtnConfirmarInfoLaboral()
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='framegeoWork']")));
		System.out.println("cambio de iframe");
		SeleniumWaiters.waitSeconds(7);
		return  SeleniumWaiters.findElement(driver,By.xpath("//*[@id='u-accept']"),10);
	}
	public WebElement getCbxReferenciaInfoLaboral()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Referencia']/parent::div//select"),10);
	}	
	public WebElement getOpcionCbxReferenciaInfoLaboral(String referencia)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Referencia(*)']/parent::div//select/option[contains(.,'"+referencia+"')]"),10);	
	}
	public WebElement getTxtDescripcionInfoLaboral()
	{
		return driver.findElement(By.id("nombreReferenciaWork"));
	}
	//***************


}
