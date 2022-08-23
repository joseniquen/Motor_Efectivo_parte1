package com.qa.efe.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedInfoDomiciliariaAvalPage {
	private WebDriver driver;

	public CredifedInfoDomiciliariaAvalPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public WebElement selectDepartamento(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:departamentoSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:departamentoSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement selectProvincia(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:provinciaSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:provinciaSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement selectDistrito(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:distritoSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:distritoSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement ingresoDireccionDomiciliaria()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-UbicacionGeograficaCV1:direccionCompleta"),10);
	}
	public WebElement clickBtnUbicarMapa()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-UbicacionGeograficaCV1:ubicarMapaButton"),10);
	}
	public WebElement selectReferencia(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:tipoReferenciaSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:tipoReferenciaSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public WebElement ingresarReferencia()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-UbicacionGeograficaCV1:referenciaText"),10);
	}
	public WebElement clickAceptarUbicarMapa()
	{
		driver.switchTo().frame(driver.findElement(By.id("framegeo")));
		return SeleniumWaiters.findElement(driver, By.xpath("//a[@id='u-accept']"), 10);
	}
	
	public WebElement tipoPropiedad(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:tipoPropiedadSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:tipoPropiedadSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	
	public WebElement ingresarAntiguedadDomAnios()
	{
		return SeleniumWaiters.findElement(driver,By.id("decimal-input-UbicacionGeograficaCV1:antDomAniosInteger"),10);
	}
	
	public WebElement ingresarAntiguedadDomMeses()
	{
		return SeleniumWaiters.findElement(driver,By.id("decimal-input-UbicacionGeograficaCV1:antDomMesesInteger"),10);
	}
	
}
