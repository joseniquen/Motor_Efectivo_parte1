package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedDashboardPage {

	private WebDriver driver;

	public CredifedDashboardPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	
	public WebElement clickProcesos()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[@title='Procesos']"),10);
	}
	public WebElement clickProcesosIN()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[@title='Processes']"),10);
	}
	public WebElement clickMostarmas()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[contains(.,'Mostrar más...')]"),10);
	}
	public WebElement clickMostarmasIN()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[contains(.,'Show more...')]"),10);
	}
	public WebElement ingresarProceso()
	{
		SeleniumWaiters.findElement(driver,By.id("editor_BaseTextDirectionMixin_0"),10).click();
		return SeleniumWaiters.findElement(driver,By.id("frag0_BaseTextDirectionMixin_0"),10);
	}
	public WebElement verInstancia()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[@title='Pulse para ver la instancia.']"),10);
	}
	public WebElement verInstanciaEn()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[@title='Click to view instance.']"),10);
	}
	public WebElement verObs()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[@title='Pulse para ver la instancia.' and contains(.,'Aprobar Observaciones')]"),10);
	}
	public WebElement verObsEn()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[@title='Click to view instance.' and contains(.,'Aprobar Observaciones')] "),10);
	}
	public List<WebElement> listVerInstancia()
	{
		try {
			return driver.findElements(By.xpath("//a[@title='Click to view instance.']"));
		} catch (Exception e) {
			return driver.findElements(By.xpath("//a[@title='Pulse para ver la instancia.']"));
		}
	}
	public WebElement aprobacionExcepcion() {
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id=\"TaskRow_0\"]/div/div[2]/div/div[1]/div[1]/span/a/span[2]"),10);
	}
	public WebElement mostrarMas()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='Data1_DataFactory_DataControl']/div[3]"),10);
	}
	public WebElement clickAnalizarSolCredito()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[@title='Pulse para trabajar en la tarea']"),10);
	}
	public WebElement clickAnalizarSolCreditoEn()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[@title='Click to work on the task']"),10);
	}
	public WebElement clickAprobarSolCredito()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[@title='Pulse para trabajar en la tarea']"),10);
	}
	public WebElement clickAprobarSolCreditoEn()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[@title='Click to work on the task']"),10);
	}
	public WebElement clickReclamarTarea()
	{
		return SeleniumWaiters.findElement(driver,By.id("ClaimDialog_0_claim"),10);
	}
	public List<WebElement> validaExisteReclamarTarea()
	{
		return driver.findElements(By.xpath("//*[@id='dijit_Dialog_0']"));
	}
	public WebElement comprueboAgencia() {
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='Data1_DataFactory_DataControl_DataPair_0']/span[2]"),10);
	}
	public WebElement comprueboNroDoc() {
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='Data1_DataFactory_DataControl_DataPair_5']/span[2]"),10);
	}
	public WebElement comprueboLineaProducto() {
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='Data1_DataFactory_DataControl_DataPair_9']/span[2]"),10);
	}
	public WebElement comprueboNroSol() {
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='Data1_DataFactory_DataControl_DataPair_15']/span[2]"),10);
	}
	public WebElement clickRecibidaSolicitud() {
		return SeleniumWaiters.findElement(driver,By.id("button-button-InicioSolicitudCV1:recibidaButton"),10);
	}
}
