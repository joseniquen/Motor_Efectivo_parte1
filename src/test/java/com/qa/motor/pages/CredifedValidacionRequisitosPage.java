package com.qa.motor.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.motor.shared.SeleniumWaiters;
import com.qa.motor.shared.devices.managers.WebDriverManager;

public class CredifedValidacionRequisitosPage {
	private WebDriver driver;

	public CredifedValidacionRequisitosPage( WebDriverManager driverManager) {
		this.driver = driverManager.getDriver();
	}
	public WebElement aprob_solicitud() {
		return SeleniumWaiters.findElement(driver, By.id("button-button-CheckListRequisitosCV:continuarAprobacionButton"),10000);
  
	}
	public List<WebElement> nro_list_doc() {
		return driver.findElements(By.xpath("//*[@id=\"div_13_1_3_1_4_1_3\"]/div[2]/div[2]/div/table/tbody/tr"));
  
	}
	public WebElement ckeck_list_doc(int opcion) {
		return SeleniumWaiters.findElement(driver,By.id("switch-toggler-CheckListRequisitosCV:listaDocumentosTable:correcto1["+opcion+"]"),10000);
  
	}
	public List<WebElement> ckeck_list_doc_exists(int opcion) {
		return driver.findElements(By.xpath("//*[@id=\"div_13_1_3_1_4_1_3\"]/div[2]/div[2]/div/table/tbody/tr["+opcion+"]/td[3]//table/tbody/tr/td[3]/div/div/i"));
  
	}
	public WebElement cargar_archivo(int opcion) {
		return SeleniumWaiters.findElement(driver,By.id("button-button-CheckListRequisitosCV:listaDocumentosTable:documentosSustento["+opcion+"]:AddButton"),10000);
  
	}
	
	public WebElement click_seleccionar_Archivo() {
		return SeleniumWaiters.findElement(driver, By.xpath("//*[@id='div_10_1_1_1_1_r26']/div//div[text()='Seleccionar...']"),10000);
		 
	}
	public WebElement click_cargar_archivo(int opcion) {
		System.out.println("numero de boton "+opcion);
		return SeleniumWaiters.findElement(driver, By.id("button-button-CheckListRequisitosCV:listaDocumentosTable:documentosSustento["+opcion+"]:UploadButton"),10000);
		 
	}
}
