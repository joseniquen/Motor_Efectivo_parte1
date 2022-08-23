package com.qa.efe.automatizacion.steps;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.pages.CredifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CredifedValidacionRequisitosPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CredifedValidacionRequisitosSteps {

	private CredifedValidacionRequisitosPage credifedValidacionRequisitosPage;

	public CredifedValidacionRequisitosSteps(CredifedValidacionRequisitosPage credifedValidacionRequisitosPage,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.credifedValidacionRequisitosPage = credifedValidacionRequisitosPage;
		this.credifedValidacionRequisitosPage = credifedValidacionRequisitosPage;
	}
	
	@Then("Continuo a aprobacion de la solicitud")
	public void continuoAprobacionSolicitud()
	{
		credifedValidacionRequisitosPage.aprobSolicitud().click();
	}
	
	@When("Doy check a la lista de documentos")
	public void ckeckListaDocumentos()
	{
		List<WebElement> elements = credifedValidacionRequisitosPage.nroListDoc();
		System.out.println("aa "+elements.size());
		for (int i = 0; i < elements.size(); i++) {
			if(credifedValidacionRequisitosPage.ckeckListDocExists(i+1).size()!=0) {
				System.out.println("el doc adjunto si existe");
			}else {
				credifedValidacionRequisitosPage.cargarArchivo(i).click();
				SeleniumWaiters.waitSeconds(5);
				credifedValidacionRequisitosPage.clickSeleccionarArchivoEsp().get(i).click();
				SeleniumWaiters.waitSeconds(5);
				try { 
					String[] commands = new String[]{}; 
					commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
					Runtime.getRuntime().exec(commands); 
				} catch (IOException e) {}
				SeleniumWaiters.waitSeconds(15);
				credifedValidacionRequisitosPage.clickCargarArchivo(i).click();
				System.out.println("numero de botonddd "+i);
				SeleniumWaiters.waitSeconds(15);

			}
			if(credifedValidacionRequisitosPage.ckeckListDocIsChecked(i).size()==0) {
				credifedValidacionRequisitosPage.ckeckListDoc(i).click();
			}			
		}
	}
}
