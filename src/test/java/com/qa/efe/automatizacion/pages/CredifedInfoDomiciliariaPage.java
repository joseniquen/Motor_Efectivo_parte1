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
	public WebElement select_departamento(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:departamentoSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:departamentoSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement select_provincia(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:provinciaSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:provinciaSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement select_distrito(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:distritoSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:distritoSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement ingreso_direccion_domiciliaria()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-InformacionDomiciliariaCV:direccionCompleta"),10000);
	}
	public WebElement click_btn_ubicar_mapa()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-InformacionDomiciliariaCV:ubicarMapaButton"),10000);
	}
	public WebElement select_referencia(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:tipoReferenciaSingle_Select']"),10000).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-InformacionDomiciliariaCV:tipoReferenciaSingle_Select']/option[text()='"+opcion+"']"),10000);
	}
	public WebElement ingresar_referencia()
	{
		return SeleniumWaiters.findElement(driver,By.id("text-input-InformacionDomiciliariaCV:referenciaText"),10000);
	}
	public WebElement click_aceptar_ubicar_mapa()
	{
		driver.switchTo().frame(driver.findElement(By.id("framegeo")));
		return SeleniumWaiters.findElement(driver, By.xpath("//a[@id='u-accept']"), 10000);
	}
}
