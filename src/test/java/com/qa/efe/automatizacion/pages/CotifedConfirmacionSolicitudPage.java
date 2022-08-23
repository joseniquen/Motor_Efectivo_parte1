package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CotifedConfirmacionSolicitudPage {
	private WebDriver driver;
	private CotifedGeneralidadesPage cotifedGeneralidadesPage;

	public CotifedConfirmacionSolicitudPage(WebDriverManager driverManager,CotifedGeneralidadesPage cotifedGeneralidadesPage) {
		this.driver = driverManager.getDriver();
		this.cotifedGeneralidadesPage=cotifedGeneralidadesPage;
	}
	public WebElement getRdbtipoDesembolso(String tipoDesembolso)
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div//label/span[contains(.,'"+tipoDesembolso+"')]"),10);
	}
	public WebElement getSelectTipoRequisitos(int i,int opcion)
	{ 	
		SeleniumWaiters.findElement(driver,By.xpath("//select[@id='select_"+i+"']"),10).click();
		return  SeleniumWaiters.findElement(driver,By.xpath("//select[@id='select_"+i+"']/option["+opcion+"]"),10);
	}
	public WebElement getClickSeleccionar(int opcion)
	{ 	
		opcion = opcion +1;
		return SeleniumWaiters.findElement(driver,By.xpath("//h3[text()='Requisitos']/parent::div/parent::div/parent::app-requirements/div[2]/div/div["+opcion+"]/div[2]/button"),10);
	}
	public WebElement getClickInsertar(int opcion)
	{ 	
		opcion = opcion +1;
		return driver.findElement(By.xpath("//h3[text()='Requisitos']/parent::div/parent::div/parent::app-requirements/div[2]/div/div["+opcion+"]/div[3]/div/div/div/div/div/label/span"));
	}
	public WebElement getCbxParentesco()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Parentesco']/parent::div//select"),10);
	}
	public WebElement getOpcionParentesco(String parentesco)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Parentesco']/parent::div//select/option[contains(.,'"+parentesco+"')]"),10);	
	}
	public WebElement getTxtNombres()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Nombres']/parent::div/input"),10);
	}
	public WebElement getTxtApellidos()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Apellidos']/parent::div/input"),10);
	}
	public WebElement getCbxPrefijo()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Prefijo']/parent::div//select"),10);
	}
	public WebElement getOpcionPrefijo(String prefijo)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Prefijo']/parent::div//select/option[contains(.,'"+prefijo+"')]"),10);	
	}
	public WebElement getTxtTelefono()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Teléfono fijo']/parent::div/input"),10);
	}
	public WebElement getTxtCelular()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Num de Celular']/parent::div/input"),10);
	}
	public WebElement getBtnAgregar()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/span/em[text()='add_circle']"),10);	
	}
	public WebElement getBtnSolicitar()
	{
		try {
			return  SeleniumWaiters.findClickableElement(driver,By.xpath("//button[contains(.,'SOLICITAR')]"),10);
		} catch (Exception e) {
			return  SeleniumWaiters.findClickableElement(driver,By.xpath("//button[contains(.,'Solicitar')]"),10);	
		}	
	}
	public void getTextSolicitar()
	{
		try {
			WebElement element = driver.findElement(By.xpath("//div/button[contains(.,'SOLICITAR')]"));
			cotifedGeneralidadesPage.scrollTo(element);
		} catch (Exception e) {
			WebElement element = driver.findElement(By.xpath("//div/button[contains(.,'Solicitar')]"));
			cotifedGeneralidadesPage.scrollTo(element);
		}
	}
	public WebElement getNroSolicitud() {
		return SeleniumWaiters.findClickableElement(driver,By.xpath("//div[3]/div/div/label[1]"), 10);
	}
	public WebElement getBtnOk()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//button[contains(.,'OK.')]"),10);	
	}
	public List<WebElement> getErrorSharePoint4()
	{
		return  driver.findElements(By.xpath("//h2[@id='swal2-title']"));	
	}
	
	public int numRequisitos()
	{
		SeleniumWaiters.waitSeconds(5);
		return  driver.findElements(By.xpath("//div[@class='m12 row']")).size();
	}
	
	public WebElement getEntidadTipoDesembolso(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Entidad']/parent::div/select"),10).click();
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Entidad']/parent::div/select/option[contains(.,'"+opcion+"')]"),10);
	}
	public WebElement getTitularTipoDesembolso()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Titular']/parent::div/input"),10);	
	}
	public WebElement getCuentaTipoDesembolso()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Cuenta']/parent::div/input"),10);	
	}
	public WebElement getDepartamentoTipoDesembolso(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Departamento']/parent::div/select"),10).click();
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Departamento']/parent::div/select/option[contains(.,'"+opcion+"')]"),10);
	}
	public WebElement getProvinciaTipoDesembolso(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Provincia']/parent::div/select"),10).click();
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Provincia']/parent::div/select/option[contains(.,'"+opcion+"')]"),10);
	}
	public WebElement getDistritoTipoDesembolso(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Distrito']/parent::div/select"),10).click();
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Distrito']/parent::div/select/option[contains(.,'"+opcion+"')]"),10);
	}
	public WebElement getTiendaTipoDesembolso(String opcion)
	{
		SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Tienda']/parent::div/select"),10).click();
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Tienda']/parent::div/select/option[contains(.,'"+opcion+"')]"),10);
	}
}