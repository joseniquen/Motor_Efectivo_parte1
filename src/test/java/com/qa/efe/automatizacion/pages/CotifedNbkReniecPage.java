package com.qa.efe.automatizacion.pages;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CotifedNbkReniecPage {
	private WebDriver driver;
	
	public CotifedNbkReniecPage(WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	
	

	public boolean validarLinkNbkReniec()
	{
		String url = driver.getCurrentUrl();
		return url.contains("nbk-reniec");
	}
	public WebElement getCbxDepartamento()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Departamento*']/parent::div//select"),10);
	}
	public WebElement getOpcionDepartamento(String departamento) {
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Departamento*']/parent::div//select/option[contains(.,'"+departamento+"')]"),10);
	}
	public WebElement getCbxProvincia()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Provincia*']/parent::div//select"),10);
	}
	public WebElement getOpcionProvincia(String provincia) {
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Provincia*']/parent::div//select/option[contains(.,'"+provincia+"')]"),10);
	}
	public WebElement getCbxDistrito()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Distrito*']/parent::div//select"),10);
	}
	public WebElement getOpcionDistrito(String distrito) {
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Distrito*']/parent::div//select/option[contains(.,'"+distrito+"')]"),10);
	}
	public WebElement getCbxVivienda()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Tipo de Vivienda*']/parent::div//select"),10);
	}
	public WebElement getOpcionVivienda(String vivienda) {
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Tipo de Vivienda*']/parent::div//select/option[contains(.,'"+vivienda+"')]"),10);
	}
	
	public WebElement getCbxPerfil()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("/html/body/app-root/app-modules/app-unbanked-reniec/div[2]/app-working-information/div/div/div[2]/form/div[1]/div[2]/div[1]/select"),10);
	}
	public WebElement getOpcionPerfil(String perfil) {
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Perfil/Situación*']/parent::div//select/option[contains(.,'"+perfil+"')]"),10);
	}
	public WebElement getCbxOcupacion()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("/html/body/app-root/app-modules/app-unbanked-reniec/div[2]/app-working-information/div/div/div[2]/form/div[1]/div[2]/div[2]/app-catalog-combo/select"),10);
	}
	public WebElement getOpcionOcupacion(String ocupacion) {
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Ocupación*']/parent::div//select/option[contains(.,'"+ocupacion+"')]"),10);
	}
	public WebElement getTxtIngreso()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Ingreso*']/parent::div//input"),10);	
	}
	public WebElement getAntAnios()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Ant.Lab.Años*']/parent::div//input"),10);	
	}
	public WebElement getAntMeses()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Ant.Lab.Meses*']/parent::div//input"),10);	
	}
	public WebElement getBtnFiltrar() 
	{
		return SeleniumWaiters.findElement(driver, By.xpath("//button[contains(.,'FILTRAR')]"));
	}

}
