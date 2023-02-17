package com.qa.efe.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedInfoDomiciliariaPage {
	private WebDriver driver;

	public CredifedInfoDomiciliariaPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public WebElement selectDepartamento(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:departamentoSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:departamentoSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement selectProvincia(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:provinciaSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:provinciaSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement selectDistrito(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:distritoSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:distritoSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement ingresoDireccionDomiciliaria()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-InformacionDomiciliariaCV:nombreViaText"),10);
	}
	public WebElement clickBtnUbicarMapa()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-InformacionDomiciliariaCV:ubicarMapaButton"),10);
	}
	public WebElement selectReferencia(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:tipoReferenciaSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:tipoReferenciaSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement ingresarReferencia()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-InformacionDomiciliariaCV:referenciaText"),10);
	}
	public WebElement clickAceptarUbicarMapa()
	{
		driver.switchTo().frame(driver.findElement(By.id("framegeo")));
		return SeleniumWaiters.findElement(driver, By.xpath("//a[@id='u-accept']"), 20);
	}
	public WebElement selectVia(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:tipoViaSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:tipoViaSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement ingresoNumeroDireccionDomiciliaria()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-InformacionDomiciliariaCV:numeroViaText"),10);
	}
	public WebElement ingresoAgrupacion()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-InformacionDomiciliariaCV:nombreAgrupacionText"),10);
	}
	public WebElement ingresoDivision()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-InformacionDomiciliariaCV:nombreDivisionText"),10);
	}
	public WebElement ingresoSubdivision()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-InformacionDomiciliariaCV:nombreSubdivisionText"),10);
	}
	public WebElement ingresoInterior()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-InformacionDomiciliariaCV:nombreInteriorText"),10);
	}
	public void refreshPage()
	{
		driver.navigate().refresh();
	}

}
