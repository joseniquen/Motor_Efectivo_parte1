package com.qa.efe.automatizacion.pages;

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
	public List<WebElement> getValidaIngresoVigente()
	{
		return  driver.findElements(By.xpath("//h2[@id='swal2-title']"));
	}
	public WebElement getValidaIngresoVigenteButtonOk()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//button[text()='OK.']"),10);
	}
	public WebElement getTxtModeloProducto()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//mat-form-field/input"),10);
	}

	public WebElement getModeloProductoSelect() {
		return SeleniumWaiters.findElement(driver, By.xpath("//mat-option/span[1]"), 10);
	}

	public WebElement getTxPrecioProducto()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//app-product-data//label[contains(.,'Precio de venta*')]/parent::div/input"),10);
	}

	public void validarSegurosMarcados()
	{
		List<WebElement> marcados = driver.findElements(By.xpath("//span[@class='active checked labelseguro']"));
		
		if (marcados.size()!=0) {
			for (int i = 0; i < marcados.size(); i++) {
				marcados.get(i).click();
			}
		 }		
		
		else {
			System.out.println("No se encontraron seguros marcados");
		}
	}
	public WebElement getSeleccionTipoSeguro(String seguro)
	{	List<WebElement>seguros = driver.findElements(By.xpath("//span[contains(.,'"+seguro+"')]"));
		return  seguros.get(0);
	}
	public WebElement getCbxEstado()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Estado Civil*']/parent::div//select"),10);
	}
	public List<WebElement> getCbxEstadoExiste()
	{
		return  driver.findElements(By.xpath("//div/label[text()='Estado Civil*']/parent::div//select"));
	}
	public WebElement getOpcionEstado(String estado)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Estado Civil*']/parent::div//select/option[contains(.,'"+estado+"')]"),10);	
	}
	public WebElement getCbxPais()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='País de Nacimiento']/parent::div//select"),10);
	}	
	public WebElement getOpcionPais(String pais)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='País de Nacimiento']/parent::div//select/option[contains(.,'"+pais+"')]"),10);	
	}
	public WebElement getCbxTipoVivienda()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Tipo de Vivienda*']/parent::div//select"),10);
	}	
	public WebElement getOpcionTipoVivienda(String TipoVivienda)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Tipo de Vivienda*']/parent::div//select/option[contains(.,'"+TipoVivienda+"')]"),10);	
	}
	public List<WebElement> getCbxTipoViviendaExiste()
	{
		return  driver.findElements(By.xpath("//div/label[text()='Tipo de Vivienda*']/parent::div//select"));
	}
	public WebElement getTxtAntDomAnios()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//input[@id='antiguedadAniosVivienda']"),10);
	}
	public WebElement getTxtAntDomMeses()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//input[@id='antiguedadMesesVivienda']"),10);
	}
	public WebElement getTxtIngresoDeclarado()
	{
		return driver.findElement(By.id("declaredIncome"));
	}
	public String getTxtIngresoDeclaradoReadOnly()
	{
		return driver.findElement(By.id("declaredIncome")).getAttribute("readonly");
	}
	public WebElement getCheckIngreso()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//span[contains(.,'Usar Ingreso declarado')]"),10);
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
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Fecha de pago*']/parent::div/select"),10);
	}
	public WebElement getOpcionFechaPago(String fechaPago)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Fecha de pago*']/parent::div/select/option[contains(.,'"+fechaPago+"')]"),10);	
	}
	public WebElement getRequiereAval()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Requiere']/parent::div/select"),10);
	}
	public WebElement getOpcionRequiereAval(String fechaPago)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Requiere']/parent::div/select/option[contains(.,'"+fechaPago+"')]"),10);	
	}
	public WebElement getBtnSimular()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//button[contains(.,'SIMULAR')]"),10);	
	}
	public List<WebElement> getColumnas()
	{
		return  driver.findElements(By.xpath("/html/body/app-root/app-modules/app-products/div[2]/app-commercial-offer/div/div[2]/div/form/div[3]/div/div/table/thead/tr/th"));
	}
	public WebElement getBtnContinuar()
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//button[contains(.,'CONTINUAR')]"),10);	
	}
	public WebElement getSituacion()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Perfil/Situación*']/parent::div//select"),5);
	}	
	public List<WebElement> getSituacionExiste()
	{
		return  driver.findElements(By.xpath("//div/label[text()='Perfil/Situación*']/parent::div//select"));
	}	

	public WebElement getOpcionSituacion(String situacion)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Perfil/Situación*']/parent::div//select/option[contains(.,'"+situacion+"')]"),5);	
	}
	public WebElement getOcupacion()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Ocupación*']/parent::div//select"),5);
	}	
	public List<WebElement> getOcupacionExiste()
	{
		return  driver.findElements(By.xpath("//div/label[text()='Ocupación*']/parent::div//select"));
	}	
	public WebElement getOpcionOcupacion(String ocupacion)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Ocupación*']/parent::div//select/option[contains(.,'"+ocupacion+"')]"),5);	
	}
	public WebElement getCbxConyugeTipoDoc()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Tipo de documento*']/parent::div//select"),10);
	}	
	public WebElement getOpcionConyugeTipoDoc(String tipoDocumento)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Tipo de documento*']/parent::div//select/option[contains(.,'"+tipoDocumento+"')]"),5);	
	}
	public WebElement getTxtConyugeNumeroDocumento()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//input[@id='numberDoc']"),5);
	}
	public WebElement getBtnConyugeFiltrar()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//button[text()='FILTRAR']"),10);
	}
	public WebElement getCbxConyugeEstadoCivil()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/div/div[3]/form/div/div[7]/app-catalog-combo/select"),5);
	}	
	public WebElement getOpcionConyugeEstadoCivil(String conyugeEstadoCivil)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/div/div[3]/form/div/div[7]/app-catalog-combo/select/option[contains(.,'"+conyugeEstadoCivil+"')]"),5);	
	}
	public WebElement getCbxConyugeDepartamento()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Departamento*']/parent::div//select"),5);
	}	
	public WebElement getOpcionConyugeDepartamento(String departamento)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Departamento*']/parent::div//select/option[contains(.,'"+departamento+"')]"),5);	
	}
	public WebElement getCbxConyugeProvincia()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Provincia*']/parent::div//select"),5);
	}	
	public WebElement getOpcionConyugeProvincia(String provincia)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Provincia*']/parent::div//select/option[contains(.,'"+provincia+"')]"),5);	
	}
	public WebElement getCbxConyugeDistrito()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/label[text()='Distrito*']/parent::div//select"),5);
	}	
	public WebElement getOpcionConyugeDistrito(String distrito)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/label[text()='Distrito*']/parent::div//select/option[contains(.,'"+distrito+"')]"),5);	
	}
	public WebElement getCbxConyugeTipoVivienda()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/div/div[3]/div/form/div/div[4]/app-catalog-combo/select"),5);
	}	
	public WebElement getOpcionConyugeTipoVivienda(String tipoVivienda)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/div/div[3]/div/form/div/div[4]/app-catalog-combo/select/option[contains(.,'"+tipoVivienda+"')]"),5);	
	}
	public WebElement getTxtConyugeAntDomAnios()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/div/div[3]/div/form/div/div[5]/div[1]/input"),5);
	}
	public WebElement getTxtConyugeAntDomMeses()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/div/div[3]/div/form/div/div[5]/div[2]/input"),5);
	}
	public WebElement getCbxConyugePerfilSituacion()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/div/div[3]/app-spouse-higher-income/div/form/div/div[2]/div[1]/select"),5);
	}	
	public WebElement getOpcionConyugePerfilSituacion(String situacion)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/div/div[3]/app-spouse-higher-income/div/form/div/div[2]/div[1]/select/option[text()='"+situacion+"']"),5);	
	}
	public WebElement getCbxConyugeOcupacion()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/div/div[3]/app-spouse-higher-income/div/form/div/div[2]/div[2]/app-catalog-combo/select"),5);
	}	
	public WebElement getOpcionConyugeOcupacion(String conyugeOcupacion)
	{
		return  SeleniumWaiters.findClickableElement(driver,By.xpath("//div/div/div[3]/app-spouse-higher-income/div/form/div/div[2]/div[2]/app-catalog-combo/select/option[text()='"+conyugeOcupacion+"']"),5);	
	}
	public WebElement getTxtConyugeIngreso()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/div/div[3]/app-spouse-higher-income/div/form/div/div[2]/div[3]/input"),5);
	}
	public WebElement getTxtConyugeAntLabAnios()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/div/div[3]/app-spouse-higher-income/div/form/div/div[3]/div[1]/input"),5);
	}
	public WebElement getTxtConyugeAntLabMeses()
	{
		return  SeleniumWaiters.findElement(driver,By.xpath("//div/div/div[3]/app-spouse-higher-income/div/form/div/div[3]/div[2]/input"),5);
	}
	
}
