package com.qa.efe.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedInfoLaboralPage {
	private WebDriver driver;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;

	public CredifedInfoLaboralPage( WebDriverManager driverManager,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.driver = driverManager.getDriver();
		this.credifedGeneralidadesPage=credifedGeneralidadesPage;
	}
	public WebElement getCentroTrabajo() {
		return SeleniumWaiters.findElement(driver, By.id("text-input-UbicacionGeograficaCV1:centroTrabajoText"),10);
	}
	public WebElement getRucCentroTrabajo() {
		return SeleniumWaiters.findElement(driver, By.id("maskedtext-input-UbicacionGeograficaCV1:rucTrabajoText"),10);
	}
	public WebElement getTipoTelefonoFijo(String opcion) {
		SeleniumWaiters.findElement(driver, By.id("singleselect-UbicacionGeograficaCV1:telefonoFijoSelect"),10).click();
		return SeleniumWaiters.findElement(driver, By.xpath("//select[@id='singleselect-UbicacionGeograficaCV1:telefonoFijoSelect']/option[text()='"+opcion+"']"),10);
	}
	public WebElement getTelefonoFijoLima() {
		return SeleniumWaiters.findElement(driver, By.id("maskedtext-input-UbicacionGeograficaCV1:telefonoLima"),10);
	}
	public WebElement getTelefonoFijoOtros() {
		return SeleniumWaiters.findElement(driver, By.id("maskedtext-input-UbicacionGeograficaCV1:telefonoOtros"),10);
	}
	public WebElement getCelular() {
		return SeleniumWaiters.findElement(driver, By.id("maskedtext-input-UbicacionGeograficaCV1:celularTrabajoText"),10);
	}
	public WebElement selectDepartamento(String opcion)
	{
		WebElement longitud = driver.findElement(By.id("div_5_1_1_1")); 
		System.out.println(longitud);
		credifedGeneralidadesPage.scrollTo(longitud);
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
		return SeleniumWaiters.findElement(driver,By.id("text-input-UbicacionGeograficaCV1:direccionPrincipalCompleta"),10);
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
	
	public WebElement loadingPage() {
		try {
			return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='loadingPage'][@style='display: none;']"),10);
		} catch (Exception e) {
			return null;
		}
	}
	
	public WebElement clickAceptarUbicarMapa()
	{
		driver.switchTo().frame(driver.findElement(By.id("framegeo")));	
		return SeleniumWaiters.findElement(driver, By.xpath("//a[@id='u-accept']"), 20);
	}
}
