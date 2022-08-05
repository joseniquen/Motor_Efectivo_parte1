package com.qa.efe.automatizacion.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CotifedOfertaComercialPage {
	private WebDriver driver;

	public CotifedOfertaComercialPage( WebDriverManager driverManager
			 ) {
		this.driver = driverManager.getDriver();
	}
	public WebElement getValidaIngresoVigente()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//h2[@id='swal2-title']"),20000);
	}
	public WebElement getValidaIngresoVigenteButtonOk()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//button[text()='OK.']"),20000);
	}
	public WebElement getTxtModeloProducto()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//mat-form-field/input"),20000);
	}

	public WebElement getModeloProductoSelect() {
		return SeleniumWaiters.findElement(driver, By.xpath("//mat-option/span[1]"), 10000);
	}

	public WebElement getTxPrecioProducto()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//app-product-data//label[contains(.,'Precio de venta*')]/parent::div/input"),10000);
	}

	public void validarSegurosMarcados()
	{
		List<WebElement> marcados = driver.findElements(By.xpath("//span[@class='active checked labelseguro']"));
		
		if (marcados.size()!=0) {
			System.out.println("Se encontraron: "+marcados.size()+" seguros marcados");
			
			for (int i = 0; i < marcados.size(); i++) {
				//Desmarcar todos los seguros que vienen marcados por defecto u obligatorios
				marcados.get(i).click();
			}
		 }		
		
		else {
			System.out.println("No se encontraron seguros");
		}
	}
	public WebElement getSeleccionTipoSeguro(String seguro)
	{	List<WebElement>seguros = driver.findElements(By.xpath("//span[contains(.,'"+seguro+"')]"));
		return  seguros.get(0);
	}
	public WebElement getCbxEstado()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Estado Civil*']/parent::div//select"),20000);
	}
	public List<WebElement> getCbxEstado_existe()
	{
		return  driver.findElements(By.xpath("//div/label[text()='Estado Civil*']/parent::div//select"));
	}
	public WebElement getOpcionEstado(String estado)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Estado Civil*']/parent::div//select/option[contains(.,'"+estado+"')]"),10000);	
	}
	public WebElement getCbxPais()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='País de Nacimiento']/parent::div//select"),20000);
	}	
	public WebElement getOpcionPais(String pais)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='País de Nacimiento']/parent::div//select/option[contains(.,'"+pais+"')]"),10000);	
	}
	public WebElement getCbxTipoVivienda()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Tipo de Vivienda*']/parent::div//select"),20000);
	}	
	public WebElement getOpcionTipoVivienda(String TipoVivienda)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Tipo de Vivienda*']/parent::div//select/option[contains(.,'"+TipoVivienda+"')]"),10000);	
	}
	public List<WebElement> getCbxTipoVivienda_existe()
	{
		return  driver.findElements(By.xpath("//div/label[text()='Tipo de Vivienda*']/parent::div//select"));
	}
	public WebElement getTxtAntDomAnios()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//input[@id='antiguedadAniosVivienda']"),20000);
	}
	public WebElement getTxtAntDomMeses()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//input[@id='antiguedadMesesVivienda']"),20000);
	}
	public WebElement getTxtIngresoDeclarado()
	{
		return driver.findElement(By.id("declaredIncome"));
	}	
	public WebElement getCheckIngreso()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//span[contains(.,'Usar Ingreso declarado')]"),20000);
	}	
	public WebElement getTxtAntLabAnios()
	{
		return driver.findElement(By.id("antiguedadAniosLaboralPrincipal"));
	}
	public WebElement getTxtAntLabMeses()
	{
		return driver.findElement(By.id("antiguedadLabMesesPrincipal"));
	}
	public WebElement getTxtInicial()
	{
		return driver.findElement(By.id("initialFee"));
	}
	public WebElement getTxtCantidadASolicitar()
	{
		return driver.findElement(By.id("quantitySol"));
	}
	public WebElement getCbxFechaPago()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Fecha de pago*']/parent::div/select"),20000);
	}
	public WebElement getOpcionFechaPago(String fechaPago)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Fecha de pago*']/parent::div/select/option[contains(.,'"+fechaPago+"')]"),10000);	
	}
	public WebElement getBtnSimular()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//button[contains(.,'SIMULAR')]"),10000);	
	}
	public List<WebElement> getColumnas()
	{
		return  driver.findElements(By.xpath("/html/body/app-root/app-modules/app-products/div[2]/app-commercial-offer/div/div[2]/div/form/div[3]/div/div/table/thead/tr/th"));
	}
	public WebElement getBtnContinuar()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//button[contains(.,'CONTINUAR')]"),10000);	
	}
}
