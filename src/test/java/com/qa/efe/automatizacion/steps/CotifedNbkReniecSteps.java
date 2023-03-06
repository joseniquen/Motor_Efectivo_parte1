package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;
import com.qa.efe.automatizacion.pages.CotifedNbkReniecPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CotifedNbkReniecSteps {
	private CotifedNbkReniecPage cotifedNbkReniecPage;
	private CotifedGeneralidadesPage generalidadesPage;

	String link="http://10.167.19.35:9080/cotifed/cotizador/nbk-reniec";
	
	public CotifedNbkReniecSteps(CotifedNbkReniecPage cotifedNbkReniecPage,CotifedGeneralidadesPage generalidadesPage) {
		this.cotifedNbkReniecPage = cotifedNbkReniecPage;	
		this.generalidadesPage = generalidadesPage;		

	}
	
	/*@When("obtener link")
	public void obtenerLink() {
		String linkReturn = cotifedNbkReniecPage.validarLinkNbkReniec();
		System.out.println("eeeeeeeeeste es el link: "+linkReturn);
		
		if(linkReturn.equals(link)) {
			System.out.println("IF -> Estoy en pagina nbk-reniec");
		}
		else {
			System.out.println("ELSE -> NO estoy en pagina nbk-reniec");
		}
	}*/
	
	@When("Ingreso informacion de vivienda nbk")
	public void ingresoInformacionViviendaNbk(DataTable infoVivienda) {
		cotifedNbkReniecPage.confirmarAlertaIngresoVigente();
		SeleniumWaiters.waitSeconds(5);
		cotifedNbkReniecPage.confirmarAlertaIngresoVigente();
		boolean existePag =  cotifedNbkReniecPage.validarLinkNbkReniec();
		if(existePag == true) {
			List<Map<String, String>> items = infoVivienda.asMaps(String.class, String.class);
			for (int i = 0; i < items.size(); i++) {
				Map<String, String> item = items.get(i);
				cotifedNbkReniecPage.getCbxDepartamento().click();
				cotifedNbkReniecPage.getOpcionDepartamento(item.get("departamento")).click();
				cotifedNbkReniecPage.getCbxProvincia().click();
				cotifedNbkReniecPage.getOpcionProvincia(item.get("provincia")).click();
				cotifedNbkReniecPage.getCbxDistrito().click();
				cotifedNbkReniecPage.getOpcionDistrito(item.get("distrito")).click();
				cotifedNbkReniecPage.getCbxVivienda().click();
				cotifedNbkReniecPage.getOpcionVivienda(item.get("tipo_de_vivienda")).click();
			}
		}else {
			System.out.println("No es una página de nbk-reniec");
		}
		try {
			generalidadesPage.captura_pantalla_cotifed("target", "cotifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@When("Ingreso informacion laboral nbk")
	public void ingresoInformacionLaboral(DataTable infoLaboral) {
		boolean existePag =  cotifedNbkReniecPage.validarLinkNbkReniec();
		if(existePag == true) {
			List<Map<String, String>> items = infoLaboral.asMaps(String.class, String.class);
			for (int i = 0; i < items.size(); i++) {
				Map<String, String> item = items.get(i);
				cotifedNbkReniecPage.getCbxPerfil().click();
				cotifedNbkReniecPage.getOpcionPerfil(item.get("perfil")).click();
				cotifedNbkReniecPage.getCbxOcupacion().click();
				cotifedNbkReniecPage.getOpcionOcupacion(item.get("ocupacion")).click();
				System.out.println("1");
				SeleniumWaiters.waitSeconds(2);
				if (cotifedNbkReniecPage.getTxtIngresoValida().size()!=0) {
					System.out.println("CAMPO NO EXISTE");
				}
				else{
					System.out.println("2");
					cotifedNbkReniecPage.getTxtIngreso().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
					cotifedNbkReniecPage.getTxtIngreso().sendKeys(item.get("ingreso"));
				}				
				if (cotifedNbkReniecPage.getAntAniosValida().size()!=0) {
					System.out.println("CAMPO NO EXISTE");
				}
				else{
					cotifedNbkReniecPage.getAntAnios().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
					cotifedNbkReniecPage.getAntAnios().sendKeys(item.get("ant_laboral_anios"));
				}
				if (cotifedNbkReniecPage.getAntMesesValida().size()!=0) {
					System.out.println("CAMPO NO EXISTE");
				}
				else{
					cotifedNbkReniecPage.getAntMeses().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
					cotifedNbkReniecPage.getAntMeses().sendKeys(item.get("ant_laboral_meses"));
				}
			}
			cotifedNbkReniecPage.getBtnFiltrar().click();
		}
		else {
			System.out.println("No es una página de nbk-reniec");
		}
		
		try {
			generalidadesPage.captura_pantalla_cotifed("target", "cotifed captura_");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
