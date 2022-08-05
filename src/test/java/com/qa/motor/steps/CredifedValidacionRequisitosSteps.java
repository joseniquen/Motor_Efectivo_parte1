package com.qa.motor.steps;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.motor.pages.CredifedGeneralidadesPage;
import com.qa.motor.pages.CredifedValidacionRequisitosPage;
import com.qa.motor.shared.SeleniumWaiters;
import com.qa.motor.shared.devices.managers.WebDriverManager;

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
	
	@When("continuo a aprobacion de la solicitud")
	public void aprob_solicitud()
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
				credifedValidacionRequisitosPage.click_seleccionar_Archivo().click();
				SeleniumWaiters.waitSeconds(5);
				try { 
					String[] commands = new String[]{}; 
					commands = new String[]{"C:\\Users\\jniquen\\Downloads\\PhotoUpload.exe"};
					Runtime.getRuntime().exec(commands); 
				} catch (IOException e) {}
				SeleniumWaiters.waitSeconds(15);
				//credifedGeneralidadesPage.scrollTo(credifedValidacionRequisitosPage.click_cargar_archivo(i));
				credifedValidacionRequisitosPage.click_cargar_archivo(i).click();
				System.out.println("numero de botonddd "+i);
				SeleniumWaiters.waitSeconds(15);

			}
			credifedValidacionRequisitosPage.ckeck_list_doc(i).click();
		}
	}
}
