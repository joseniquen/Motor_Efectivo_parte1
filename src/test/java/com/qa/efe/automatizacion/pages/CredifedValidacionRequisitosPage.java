package com.qa.efe.automatizacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

public class CredifedValidacionRequisitosPage {
	private WebDriver driver;

	public CredifedValidacionRequisitosPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public WebElement aprobSolicitud() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-CheckListRequisitosCV:continuarAprobacionButton"),10);
  
	}
	public List<WebElement> nroListDoc() {
		return driver.findElements(By.xpath("//*[@id=\"div_13_1_3_1_4_1_3\"]/div[2]/div[2]/div/table/tbody/tr"));
  
	}
	public WebElement ckeckListDoc(int opcion) {
		return SeleniumWaiters.findElement(driver,By.id("switch-toggler-CheckListRequisitosCV:listaDocumentosTable:correcto1["+opcion+"]"),10);
  
	}
	public List<WebElement> ckeckListDocIsChecked(int opcion) {
		return driver.findElements(By.xpath("//*[@id='switch-toggler-CheckListRequisitosCV:listaDocumentosTable:correcto1["+opcion+"]']/parent::div/input[@checked='checked']"));
  
	}
	public List<WebElement> ckeckListDocExists(int opcion) {
		return driver.findElements(By.xpath("//*[@id=\"div_13_1_3_1_4_1_3\"]/div[2]/div[2]/div/table/tbody/tr["+opcion+"]/td[3]//table/tbody/tr/td[3]/div/div/i"));
  
	}
	public WebElement cargarArchivo(int opcion) {
		return SeleniumWaiters.findElement(driver,By.id("button-button-CheckListRequisitosCV:listaDocumentosTable:documentosSustento["+opcion+"]:AddButton"),10);
  
	}
	
	public List<WebElement> clickSeleccionarArchivo() {
		List<WebElement> MiLista;
		try {
			MiLista=driver.findElements( By.xpath("//div[text()='Seleccionar...']"));
		} catch (Exception e) {
			MiLista=driver.findElements( By.xpath("//div[text()='Select...']"));
		}
		System.out.println("Mi Lista:"+MiLista);
		return MiLista;	 
	}
	public List<WebElement> clickSeleccionarArchivoEsp() {
		return driver.findElements( By.xpath("//div[text()='Seleccionar...']"));		 
	}
	public WebElement clickCargarArchivo(int opcion) {
		System.out.println("numero de boton "+opcion);
		return SeleniumWaiters.findElement(driver, By.id("button-button-CheckListRequisitosCV:listaDocumentosTable:documentosSustento["+opcion+"]:UploadButton"),10);
		 
	}
}
