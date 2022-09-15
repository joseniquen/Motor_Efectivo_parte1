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
		return driver.findElements(By.xpath("//*[@id='div_13_1_3_1_4_1_3']/div[3]/div[3]/div/table/tbody/tr"));
	}
	public WebElement ckeckListDoc(int opcion) {
		return SeleniumWaiters.findElement(driver,By.id("switch-off-CheckListRequisitosCV:listaDocumentosTable:correcto1["+opcion+"]"),10);
  
	}
	public List<WebElement> ckeckListDocIsChecked(int opcion) {
		return driver.findElements(By.xpath("//*[@id='div_13_1_3_1_4_1_3_1_4_r"+opcion+"']/div/input[@checked='checked']"));
		
	}
	public List<WebElement> ckeckListDocExists(int opcion) {
		return driver.findElements(By.xpath("//*[@id='div_13_1_3_1_4_1_3']/div[3]/div[3]/div/table/tbody/tr["+opcion+"]/td[3]//table/tbody/tr/td[3]/div/div[3]/i"));
	}
	
	
	
	public WebElement ckeckListDocExists2(int opcion) {
		try {
			return SeleniumWaiters.findElement(driver,By.xpath("//*[@id='div_8_1_2_r"+opcion+"']/div[3]/div[3]/div/table/tbody/tr/td[1]/div/div/a"),1);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public WebElement cargarArchivo(int opcion) {
		return SeleniumWaiters.findElement(driver,By.id("button-button-CheckListRequisitosCV:listaDocumentosTable:documentosSustento["+opcion+"]:Panel1:Panel_Header1:Horizontal_Layout1:AddButton"),10);
	}
	
	public List<WebElement> clickSeleccionarArchivo() {
		List<WebElement> MiListaEsp;
		List<WebElement> MiListaEng;
		List<WebElement> MiLista;
		MiListaEsp=driver.findElements( By.xpath("//div[text()='Select...']"));
		MiListaEng=driver.findElements( By.xpath("//div[text()='Seleccionar...']"));
		if(MiListaEsp.size()!=0) {
			MiLista=MiListaEsp;
			return MiLista;	 
		}else {
			MiLista=MiListaEng;
			return MiLista;	 
		}
	}
	public List<WebElement> clickSeleccionarArchivoEsp() {
		return driver.findElements( By.xpath("//div[text()='Seleccionar...']"));		 
	}
	public WebElement clickCargarArchivo(int opcion) {
		System.out.println("numero de boton "+opcion);
		return SeleniumWaiters.findElement(driver, By.id("button-button-CheckListRequisitosCV:listaDocumentosTable:documentosSustento["+opcion+"]:Horizontal_Layout4:DocPropertiesModal:DocPropertiesPanel:Vertical_Layout3:UploadButton"),10);
		 
	}
}
