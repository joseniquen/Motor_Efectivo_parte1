package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.Keys;

import com.qa.efe.automatizacion.pages.CotifedNbkNoReniecPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class CotifedNbkNoReniecSteps {
	private CotifedNbkNoReniecPage cotifedNbkNoReniecPage;

	public CotifedNbkNoReniecSteps(CotifedNbkNoReniecPage cotifedNbkNoReniecPage
			 ) {
		this.cotifedNbkNoReniecPage = cotifedNbkNoReniecPage;
	}
	
	@When("Ingreso datos personales")
	public void IngresoDatosPersonales(DataTable datos) {
		boolean existePag = cotifedNbkNoReniecPage.validarLink();
		if( existePag == true)
		{
			List<Map<String, String>> items = datos.asMaps(String.class, String.class);
			for (int i = 0; i < items.size(); i++) {
				Map<String, String> item = items.get(i);
				cotifedNbkNoReniecPage.getTxtPrimerNombre().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				cotifedNbkNoReniecPage.getTxtPrimerNombre().sendKeys(item.get("primer_nombre"));
				cotifedNbkNoReniecPage.getTxtSegundoNombre().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				cotifedNbkNoReniecPage.getTxtSegundoNombre().sendKeys(item.get("segundo_nombre"));
				cotifedNbkNoReniecPage.getTxtApellidoPaterno().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				cotifedNbkNoReniecPage.getTxtApellidoPaterno().sendKeys(item.get("apellido_paterno"));
				cotifedNbkNoReniecPage.getTxtApellidoMaterno().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				cotifedNbkNoReniecPage.getTxtApellidoMaterno().sendKeys(item.get("apellido_materno"));
				cotifedNbkNoReniecPage.getCbxSexo().click();
				cotifedNbkNoReniecPage.getOpcionSexo(item.get("sexo")).click();
				cotifedNbkNoReniecPage.getCbxEstadoCivil().click();
				cotifedNbkNoReniecPage.getOpcionEstadoCivil(item.get("estado_civil")).click();
				cotifedNbkNoReniecPage.getInputNac(item.get("fecha_nac"));
				SeleniumWaiters.waitSeconds(3);
			}
		}else {
			System.out.println("No es una p??gina de nbk-no-reniec");
		}
	}
	
	@When("Ingreso informacion de vivienda")
	public void ingresoInformacionVivienda(DataTable infoVivienda) {
		boolean existePag = cotifedNbkNoReniecPage.validarLink();
		if(existePag == true)
		{
			List<Map<String, String>> items = infoVivienda.asMaps(String.class, String.class);
			for (int i = 0; i < items.size(); i++) {
				Map<String, String> item = items.get(i);
				cotifedNbkNoReniecPage.getCbxDepartamento().click();
				cotifedNbkNoReniecPage.getOpcionDepartamento(item.get("departamento")).click();
				cotifedNbkNoReniecPage.getCbxProvincia().click();
				cotifedNbkNoReniecPage.getOpcionProvincia(item.get("provincia")).click();
				cotifedNbkNoReniecPage.getCbxDistrito().click();
				cotifedNbkNoReniecPage.getOpcionDistrito(item.get("distrito")).click();
				cotifedNbkNoReniecPage.getCbxTipoVivienda().click();
				cotifedNbkNoReniecPage.getOpcionTipoVivienda(item.get("tipo_vivienda")).click();
				SeleniumWaiters.waitSeconds(3);
			}
		}else
		{
			System.out.println("No es una p??gina de nbk-no-reniec");	
		}
		
	}

	@When("Ingreso informacion laboral")
	public void ingresoInformacionLaboral(DataTable infoLaboral) {
		boolean existePag = cotifedNbkNoReniecPage.validarLink();
		if(existePag == true)
		{
			List<Map<String, String>> items = infoLaboral.asMaps(String.class, String.class);
			for (int i = 0; i < items.size(); i++) {
				Map<String, String> item = items.get(i);
				cotifedNbkNoReniecPage.getCbxSituacion().click();
				cotifedNbkNoReniecPage.getOpcionSituacion(item.get("situacion")).click();
				cotifedNbkNoReniecPage.getCbxOcupacion().click();
				cotifedNbkNoReniecPage.getOpcionOcupacion(item.get("ocupacion")).click();
				cotifedNbkNoReniecPage.getTxtIngreso().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				cotifedNbkNoReniecPage.getTxtIngreso().sendKeys(item.get("ingreso"));
				cotifedNbkNoReniecPage.getTxtAntLabAnios().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				cotifedNbkNoReniecPage.getTxtAntLabAnios().sendKeys(item.get("ant_laboral_anios"));
				cotifedNbkNoReniecPage.getTxtAntLabMeses().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				cotifedNbkNoReniecPage.getTxtAntLabMeses().sendKeys(item.get("ant_laboral_meses"));
				SeleniumWaiters.waitSeconds(3);
			}
			cotifedNbkNoReniecPage.getBtnFiltrar().click();
		}else
		{
			System.out.println("No es una p??gina de nbk-no-reniec");	
		}	
	}	
}










