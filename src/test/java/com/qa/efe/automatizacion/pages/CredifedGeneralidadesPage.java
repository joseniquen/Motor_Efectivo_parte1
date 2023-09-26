package com.qa.efe.automatizacion.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.shared.NavigationHelpers;

import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;
import com.qa.efe.automatizacion.stores.IntegracionStore;

public class CredifedGeneralidadesPage {
	private WebDriver driver;
	private IntegracionStore integracionStore;

	public CredifedGeneralidadesPage( WebDriverManager driverManager,IntegracionStore integracionStore) {
		this.driver = driverManager.getDriver();
		this.integracionStore=integracionStore;

	}
	public void cambioIframe(String titleIframe)
	{
		driver.switchTo().frame(SeleniumWaiters.findElement(driver,By.xpath("//iframe[@title='"+titleIframe+"']"),50));
	}
	public void iframeDefecto() {
		driver.switchTo().defaultContent();
	}
	public boolean verificarAlertaRoja()
	{
		if (SeleniumWaiters.findElement(driver,By.xpath("//span[contains(.,'Error en Ejecución de Servicio')]/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div[@style='display: block;']"),10).isDisplayed()) {
			System.out.println("true");
			return true;
		}else {
			System.out.println("false");
			return false;
		}
			
	}
	public List<WebElement> AceptarAlertaRoja()
	{
			return driver.findElements(By.xpath("//button[contains(.,'Aceptar')]/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div[@style='display: block;']//button[contains(.,'Aceptar')]"));
		
	}
	public WebElement clickBtnGuardar()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-MenuEditarCV1:buttonGuardar"),10);
	}
	public WebElement clickBtnSobreescribirDatos()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-ModalMenuEditarGuardar:buttonAceptar"),10);
	}
	public WebElement clickBtnContinuar()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//button[text()='Continuar >>']"),10);
	}
	public WebElement clickBtnCancelar()
	{
		return SeleniumWaiters.findElement(driver,By.id("button-button-MenuEditarCV1:buttonCancelar"),10);
	}
	public void scrollTo(WebElement element) {
		NavigationHelpers.scrollToElement(driver, element);
	}
	public WebElement pestañasMenu(String opcion)
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//button[text()='"+opcion+"']"),10);
	}	
	public List<WebElement> validarMenuInicial(String titleIframe)
	{
		return driver.findElements(By.xpath("//iframe[@title='"+titleIframe+"']"));
	}
	
	public List<WebElement> listaIframe()
	{
		return driver.findElements(By.tagName("iframe"));
	}
	
	public WebElement validarMenuInicialCambiar(String titleIframe)
	{
		try {
			return SeleniumWaiters.findElement(driver,By.xpath("//iframe[@title='"+titleIframe+"']"),10);
		} catch (Exception e) {
			return null;
		}	
	}
	
	public List<WebElement> validarMenuInicialIframe()
	{
		return driver.findElements(By.xpath("//iframe[@style='border: 0px; height: 100%; width: 100%; display: block']"));
	}
	public WebElement clickMenuInicialAnalizar()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//div/button[text()='Datos Titular']"),10);
	}	
	public WebElement clickMenuInicialAnalizarAval()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//div/button[text()='Datos Aval']"),10);
	}
	public WebElement clickMenuInicialAprobar()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//div/button[text()='Validar Requisitos']"),15);
	}	
	public WebElement clickMenuInicialExepcion()
	{
		return SeleniumWaiters.findElement(driver,By.xpath("//div/button[text()='Observaciones']"),15);
	}
	public void captura_pantalla(int a) throws IOException {
		 switch (a) {
	        case 1:
				captura_pantalla_credifed_analizar("target", "credifed captura_");
	            break;
	        case 2:
				captura_pantalla_credifed_analizar_aval("target", "credifed captura_");
	            break;
	        case 3:
				captura_pantalla_credifed_enviar_obs("target", "credifed captura_");
	            break;
	        case 4:
				captura_pantalla_credifed_aprobar_obs("target", "credifed captura_");
	            break;
	        default:
				captura_pantalla_credifed_aprobar("target", "credifed captura_");
	            break;
	    }
	}
	public void captura_pantalla_credifed_analizar(String ruta, String nombre) throws IOException {
		//SeleniumWaiters.waitSeconds(5);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String newString1 = ruta.replace("\\", "\\\\");
		FileUtils.copyFile(scrFile, new File(newString1+"\\credifed analizar\\"+nombre+integracionStore.captura_incremental_cretifed+".png"));
		integracionStore.captura_incremental_cretifed = integracionStore.captura_incremental_cretifed +1;
	}
	public void captura_pantalla_credifed_analizar_aval(String ruta, String nombre) throws IOException {
		//SeleniumWaiters.waitSeconds(5);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String newString1 = ruta.replace("\\", "\\\\");
		FileUtils.copyFile(scrFile, new File(newString1+"\\credifed analizar aval\\"+nombre+integracionStore.captura_incremental_cretifed+".png"));
		integracionStore.captura_incremental_cretifed = integracionStore.captura_incremental_cretifed +1;
	}
	public void captura_pantalla_credifed_enviar_obs(String ruta, String nombre) throws IOException {
		//SeleniumWaiters.waitSeconds(5);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String newString1 = ruta.replace("\\", "\\\\");
		FileUtils.copyFile(scrFile, new File(newString1+"\\credifed enviar obs\\"+nombre+integracionStore.captura_incremental_cretifed+".png"));
		integracionStore.captura_incremental_cretifed = integracionStore.captura_incremental_cretifed +1;
	}
	public void captura_pantalla_credifed_aprobar_obs(String ruta, String nombre) throws IOException {
		//SeleniumWaiters.waitSeconds(5);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String newString1 = ruta.replace("\\", "\\\\");
		FileUtils.copyFile(scrFile, new File(newString1+"\\credifed aprobar obs\\"+nombre+integracionStore.captura_incremental_cretifed+".png"));
		integracionStore.captura_incremental_cretifed = integracionStore.captura_incremental_cretifed +1;
	}
	public void captura_pantalla_credifed_aprobar(String ruta, String nombre) throws IOException {
		//SeleniumWaiters.waitSeconds(5);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String newString1 = ruta.replace("\\", "\\\\");
		FileUtils.copyFile(scrFile, new File(newString1+"\\credifed aprobar\\"+nombre+integracionStore.captura_incremental_cretifed+".png"));
		integracionStore.captura_incremental_cretifed = integracionStore.captura_incremental_cretifed +1;
	}
}
