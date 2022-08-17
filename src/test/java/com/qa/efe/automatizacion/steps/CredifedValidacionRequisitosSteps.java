package com.qa.efe.automatizacion.steps;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedValidacionRequisitosPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CredifedValidacionRequisitosSteps {

	private CredifedValidacionRequisitosPage credifedValidacionRequisitosPage;
	private CredifedGeneralidadesPage credifedGeneralidadesPage;
	private WebDriver driver;
	public CredifedValidacionRequisitosSteps( WebDriverManager driverManager,CredifedValidacionRequisitosPage credifedValidacionRequisitosPage,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.driver = driverManager.getDriver();
		this.credifedValidacionRequisitosPage = credifedValidacionRequisitosPage;
		this.credifedValidacionRequisitosPage = credifedValidacionRequisitosPage;
	}
	
	@Then("Continuo a aprobacion de la solicitud")
	public void continuoAprobacionSolicitud()
	{
		credifedValidacionRequisitosPage.aprob_solicitud().click();
	}
	@When("check list de documentos")
	public void ckeck_list_doc()
	{
		List<WebElement> elements = credifedValidacionRequisitosPage.nro_list_doc();
		System.out.println("aa "+elements.size());
		for (int i = 0; i < elements.size(); i++) {
			if(credifedValidacionRequisitosPage.ckeck_list_doc_exists(i+1).size()!=0) {
				System.out.println("el doc adjunto si existe");
			}else {
				credifedValidacionRequisitosPage.cargar_archivo(i).click();
				SeleniumWaiters.waitSeconds(5);
				credifedValidacionRequisitosPage.click_seleccionar_Archivo().get(i).click();
				SeleniumWaiters.waitSeconds(5);
				try { 
					String[] commands = new String[]{}; 
					commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
					Runtime.getRuntime().exec(commands); 
				} catch (IOException e) {}
				SeleniumWaiters.waitSeconds(15);
				credifedValidacionRequisitosPage.click_cargar_archivo(i).click();
				System.out.println("numero de botonddd "+i);
				SeleniumWaiters.waitSeconds(15);

			}
			if(credifedValidacionRequisitosPage.ckeck_list_doc_isChecked(i).size()==0) {
				credifedValidacionRequisitosPage.ckeck_list_doc(i).click();
			}			
		}
	}
}
