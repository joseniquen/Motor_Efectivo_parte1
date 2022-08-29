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
		return SeleniumWaiters.findElement(driver,By.id("text-input-InformacionDomiciliariaCV:direccionCompleta"),10);
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
}
