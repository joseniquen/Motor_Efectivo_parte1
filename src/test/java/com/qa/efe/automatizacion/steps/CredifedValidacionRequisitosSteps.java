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
	private CredifedGeneralidadesPage credifedGeneralidadesPage;


	public CredifedValidacionRequisitosSteps(CredifedValidacionRequisitosPage credifedValidacionRequisitosPage,CredifedGeneralidadesPage credifedGeneralidadesPage) {
		this.credifedValidacionRequisitosPage = credifedValidacionRequisitosPage;
		this.credifedValidacionRequisitosPage = credifedValidacionRequisitosPage;
		this.credifedGeneralidadesPage = credifedGeneralidadesPage;

	}
	
	@Then("Continuo a aprobacion de la solicitud {int}")
	public void continuoAprobacionSolicitud(int a)
	{
		credifedValidacionRequisitosPage.aprobSolicitud().click();
		try {
			credifedGeneralidadesPage.captura_pantalla(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Doy check a la lista de documentos")
	public void ckeckListaDocumentos()
	{
		List<WebElement> elements = credifedValidacionRequisitosPage.nroListDoc();
		System.out.println("Archivos a cargar: "+elements.size());
		int j=2;
		int k=3;
		for (int i = 0; i < elements.size(); i++) {
			if(credifedValidacionRequisitosPage.ckeckListDocExists2(j)!=null) {
				System.out.println("el doc adjunto si existe");
			}else {
				credifedValidacionRequisitosPage.cargarArchivo(i).click();
				System.out.println("Está en la posición: "+elements.get(i));
				SeleniumWaiters.waitSeconds(5);
				credifedValidacionRequisitosPage.clickSeleccionarArchivo().get(i).click();
				SeleniumWaiters.waitSeconds(5);
				
				try { 
					String[] commands = new String[]{}; 
					commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
					Runtime.getRuntime().exec(commands); 
				} catch (IOException e) {}
				SeleniumWaiters.waitSeconds(15);
				credifedValidacionRequisitosPage.clickCargarArchivo(i).click();
				System.out.println("numero de boton "+i);
				SeleniumWaiters.waitSeconds(15);
			}
			if(credifedValidacionRequisitosPage.ckeckListDocIsChecked(k).size()==0) {
				credifedValidacionRequisitosPage.ckeckListDoc(i).click();
			}		
			k=k+6;
			j=j+6;
		}
	}
}
