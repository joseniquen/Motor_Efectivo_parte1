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
	
	public WebElement click_procesos()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='dashboard-menu-item-2015.27']/div/div[2]/a"),10);
	}
	public WebElement ingresar_proceso()
	{
		SeleniumWaiters.findElement(driver,By.id("editor_BaseTextDirectionMixin_0"),10).click();
		return SeleniumWaiters.findElement(driver,By.id("frag0_BaseTextDirectionMixin_0"),10);
	}
	public WebElement ver_instancia()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[@title='Pulse para ver la instancia.']"),10);
	}
	public WebElement ver_instancia_en()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//a[@title='Click to view instance.']"),10);
	}
	public WebElement mostrar_mas()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='Data1_DataFactory_DataControl']/div[3]"),10);
	}
	public WebElement click_analizar_sol_credito()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='TaskRow_0']//a[@title='Pulse para trabajar en la tarea']"),10);
	}
	public WebElement click_analizar_sol_credito_en()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='TaskRow_0']//a[@title='Click to work on the task']"),10);
	}
	public WebElement click_reclamar_tarea()
	{
		return SeleniumWaiters.findElement(driver,By.id("ClaimDialog_0_claim"),10);
	}
	public List<WebElement> valida_existe_reclamar_tarea()
	{
		return driver.findElements(By.xpath("//*[@id='dijit_Dialog_0']"));
	}
	public WebElement compruebo_agencia() {
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='Data1_DataFactory_DataControl_DataPair_0']/span[2]"),10);
	}
	public WebElement compruebo_nroDoc() {
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='Data1_DataFactory_DataControl_DataPair_2']/span[2]"),10);
	}
	public WebElement compruebo_linea_producto() {
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='Data1_DataFactory_DataControl_DataPair_6']/span[2]"),10);
	}
	public WebElement compruebo_nro_sol() {
		return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='Data1_DataFactory_DataControl_DataPair_12']/span[2]"),10);
	}
}
