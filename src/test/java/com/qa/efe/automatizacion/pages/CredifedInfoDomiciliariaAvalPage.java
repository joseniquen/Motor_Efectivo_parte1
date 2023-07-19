package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedInfoDomiciliariaAvalPage {
	private WebDriver driver;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;

	public CredifedInfoDomiciliariaAvalPage( WebDriverManager driverManager,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.driver = driverManager.getDriver();
		this.credifedGeneralidadesPage=credifedGeneralidadesPage;
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
		return SeleniumWaiters.findElement(driver,By.id("text-input-UbicacionGeograficaCV1:nombreViaText"),10);
	}
	public void scrollReferencia() {
		WebElement element = SeleniumWaiters.findElement(driver,By.xpath("//span[text()='Referencia']"),10);
		credifedGeneralidadesPage.scrollTo(element);
	}
	public List<WebElement> selectViaValida(String opcion)
	{
		return driver.findElements(By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:tipoViaSingle_Select']/option[text()='"+opcion+"']"));
	}
	public WebElement selectVia(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:tipoViaSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:tipoViaSingle_Select']/option[text()='"+opcion+"']"),10);
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
		return SeleniumWaiters.findElement(driver, By.xpath("//a[@id='u-accept']"), 20);
	}
	
	public WebElement tipoPropiedad(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:tipoPropiedadSingle_Select']"),10).click();
		return SeleniumWaiters.findElement(driver,By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:tipoPropiedadSingle_Select']/option[text()='"+opcion+"']"),10);
	}
	public List<WebElement> tipoPropiedadValida(String opcion)
	{
		return driver.findElements(By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:tipoPropiedadSingle_Select']/option[text()='"+opcion+"']"));
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
