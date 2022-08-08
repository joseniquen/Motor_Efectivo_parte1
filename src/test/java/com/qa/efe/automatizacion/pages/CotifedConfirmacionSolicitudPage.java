package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CotifedConfirmacionSolicitudPage {
	private WebDriver driver;

	public CotifedConfirmacionSolicitudPage(WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public WebElement getRdbtipoDesembolso(String tipoDesembolso)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div//label/span[contains(.,'"+tipoDesembolso+"')]"),10000);
	}
	public WebElement getSelectTipoRequisitos(int i,int opcion)
	{ 	
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='select_"+i+"']"),20000).click();
		//return  SeleniumWaiters.findElement(driver,By.xpath("//select[@id='select_"+i+"']/option[contains(.,'"+opcion+"')]"),20000);
		return  SeleniumWaiters.findElement(driver,By.xpath("//select[@id='select_"+i+"']/option["+opcion+"]"),20000);
	}
	public WebElement getClickSeleccionar(int opcion)
	{ 	
		opcion = opcion +1;
		return SeleniumWaiters.findElement(driver,By.xpath("//h3[text()='Requisitos']/parent::div/parent::div/parent::app-requirements/div[2]/div/div["+opcion+"]/div[2]/button"),10000);
	}
	public WebElement getClickInsertar(int opcion)
	{ 	
		opcion = opcion +1;
		return driver.findElement(By.xpath("//h3[text()='Requisitos']/parent::div/parent::div/parent::app-requirements/div[2]/div/div["+opcion+"]/div[3]/div/div/div/div/div/label/span"));
	}
	public WebElement getCbxParentesco()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Parentesco']/parent::div//select"),10000);
	}
	public WebElement getOpcionParentesco(String parentesco)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Parentesco']/parent::div//select/option[contains(.,'"+parentesco+"')]"),10000);	
	}
	public WebElement getTxtNombres()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Nombres']/parent::div/input"),10000);
	}
	public WebElement getTxtApellidos()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Apellidos']/parent::div/input"),10000);
	}
	public WebElement getCbxPrefijo()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Prefijo']/parent::div//select"),10000);
	}
	public WebElement getOpcionPrefijo(String prefijo)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Prefijo']/parent::div//select/option[contains(.,'"+prefijo+"')]"),10000);	
	}
	public WebElement getTxtTelefono()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Teléfono fijo']/parent::div/input"),10000);
	}
	public WebElement getTxtCelular()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Num de Celular']/parent::div/input"),10000);
	}
	public WebElement getBtnAgregar()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/span/em[text()='add_circle']"),10000);	
	}
	public WebElement getBtnSolicitar()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//button[contains(.,'Solicitar')]"),10000);	
	}
	public WebElement getNroSolicitud() {
		return SeleniumWaiters.findClickableElement(driver,By.xpath("/html/body//div[2]/div[3]/div/div/label[1]"), 1000);
	}
	public WebElement getBtnOk()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//button[contains(.,'OK.')]"),10000);	
	}
	public List<WebElement> getErrorSharePoint()
	{
		return  driver.findElements(By.xpath("//h2[contains(.,'Hubo un error al consumir el servicio EnviarArchivoSharePoint')]/parent::div/parent::div[@style='display: flex;']"));	
	}
	public int numRequisitos()
	{
		SeleniumWaiters.waitSeconds(5);
		return  driver.findElements(By.xpath("//div[@class='m12 row']")).size();
	}
	
}