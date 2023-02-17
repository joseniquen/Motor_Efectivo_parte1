package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.pages.CotifedConfirmacionSolicitudPage;
import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.stores.File;
import com.qa.efe.automatizacion.stores.IntegracionStore;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CotifedConfirmacionSolicitudSteps {
	private CotifedConfirmacionSolicitudPage cotifedConfirmacionSolicitudPage;
	private CotifedGeneralidadesPage cotifedGeneralidadesPage;
	private IntegracionStore integracionStore;
	private File file;

	public CotifedConfirmacionSolicitudSteps(  
			CotifedConfirmacionSolicitudPage cotifedConfirmacionSolicitudPage,
			IntegracionStore integracionStore,
			CotifedGeneralidadesPage cotifedGeneralidadesPage,
			File file
			 ) {
		this.cotifedConfirmacionSolicitudPage = cotifedConfirmacionSolicitudPage;
		this.integracionStore=integracionStore;
		this.file=file;
		this.cotifedGeneralidadesPage=cotifedGeneralidadesPage;
	}
	
	@When("Elijo tipo de desembolso {string}")
	public void elijoTipoDesembolso(String tipoDesembolso)
	{
		cotifedGeneralidadesPage.cargarDatos();
		SeleniumWaiters.waitSeconds(5);
		cotifedConfirmacionSolicitudPage.getRdbtipoDesembolso(tipoDesembolso).click();
		if(tipoDesembolso.equals("Desembolso en otra tienda")) {
			cotifedConfirmacionSolicitudPage.getDepartamentoTipoDesembolso("LIMA").click();
			cotifedConfirmacionSolicitudPage.getProvinciaTipoDesembolso("LIMA").click();
			cotifedConfirmacionSolicitudPage.getDistritoTipoDesembolso("SANTIAGO DE SURCO").click();
			cotifedConfirmacionSolicitudPage.getTiendaTipoDesembolso("OFICINA PRINCIPAL").click();
		}
	}
	
	@When("Elijo departamento {string} provincia {string} distrito {string} y tienda {string}")
	public void elijoDepartamentoProvinciaDistritoTienda(String departamento,String provincia,String distrito,String tienda) {
		cotifedConfirmacionSolicitudPage.getDepartamentoTipoDesembolso(departamento).click();
		cotifedConfirmacionSolicitudPage.getProvinciaTipoDesembolso(provincia).click();
		cotifedConfirmacionSolicitudPage.getDistritoTipoDesembolso(distrito).click();
		cotifedConfirmacionSolicitudPage.getTiendaTipoDesembolso(tienda).click();
	}
	
	@When ("Selecciono la entidad tipo {string}")
	public void seleccionoEntidadTipoEfectiva(String entidad) {
		cotifedGeneralidadesPage.cargarDatos();
		cotifedConfirmacionSolicitudPage.getEntidadTipoDesembolso(entidad).click();
	}
	
	@When ("Ingreso numero titular")
	public void ingresoNumTitular() {
		cotifedConfirmacionSolicitudPage.getTitularTipoDesembolso().sendKeys(integracionStore.dni);
	}
	
	@When ("Ingreso numero de cuenta {string} y CCI {string}")
	public void ingresoNumeroCuenta(String cuenta, String cci) {
		String valor = cotifedConfirmacionSolicitudPage.obtenerValorSelectEntidad().getText();	
		cotifedConfirmacionSolicitudPage.getCuentaTipoDesembolso().sendKeys(cuenta);
		if(valor.equals("OTRO")) {
			cotifedConfirmacionSolicitudPage.getCuentaTipoDesembolsoCci().sendKeys(cci);
		}else {}
	}
		
		

	@When("Selecciono requisito y cargo archivo")
	public void seleccionoRequisitoCargoArchivo ()
	{	
		int divs = cotifedConfirmacionSolicitudPage.numRequisitos();
		for (int i = 0; i < divs; i++) {
			if(cotifedConfirmacionSolicitudPage.getSelectTipoRequisitos(i,2).getText().equals("DNI")) {
				if(integracionStore.tipo_documento.equals("CARNET.EXTRANJERIA")) {
					cotifedConfirmacionSolicitudPage.getSelectTipoRequisitos(i,3).click();
					cotifedConfirmacionSolicitudPage.getClickSeleccionar(i).click();
					do {
						if(cotifedConfirmacionSolicitudPage.getErrorSharePoint4()!=null) {
							cotifedConfirmacionSolicitudPage.getBtnOk().click();
						}
						cotifedConfirmacionSolicitudPage.getClickInsertar(i).click();
						try { 
							String[] commands = new String[]{}; 
							commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
							Runtime.getRuntime().exec(commands); 
						} catch (IOException e) {
							System.out.println("Error dentro del catch:" +cotifedConfirmacionSolicitudPage.getErrorSharePoint4());
						}
						SeleniumWaiters.waitSeconds(7);
						cotifedGeneralidadesPage.cargarDatos3();
					} while (cotifedConfirmacionSolicitudPage.getErrorSharePoint4()!=null);
				}else if(integracionStore.tipo_documento.equals("D.N.I.")){
					cotifedConfirmacionSolicitudPage.getSelectTipoRequisitos(i,2).click();
					cotifedConfirmacionSolicitudPage.getClickSeleccionar(i).click();
					do {
						if(cotifedConfirmacionSolicitudPage.getErrorSharePoint4()!=null) {
							cotifedConfirmacionSolicitudPage.getBtnOk().click();
						}
						cotifedConfirmacionSolicitudPage.getClickInsertar(i).click();
						try { 
							String[] commands = new String[]{}; 
							commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
							Runtime.getRuntime().exec(commands); 
						} catch (IOException e) {
							System.out.println("Error dentro del catch:" +cotifedConfirmacionSolicitudPage.getErrorSharePoint4());
						}
						SeleniumWaiters.waitSeconds(7);
						cotifedGeneralidadesPage.cargarDatos3();
					} while (cotifedConfirmacionSolicitudPage.getErrorSharePoint4()!=null);		
				}
			}
			else if(cotifedConfirmacionSolicitudPage.getSelectTipoRequisitos(i,2).getText().equals("DNI REVERSO")) {
				if(integracionStore.tipo_documento.equals("CARNET.EXTRANJERIA")) {
					cotifedConfirmacionSolicitudPage.getSelectTipoRequisitos(i,3).click();
					cotifedConfirmacionSolicitudPage.getClickSeleccionar(i).click();
					do {
						if(cotifedConfirmacionSolicitudPage.getErrorSharePoint4()!=null) {
							cotifedConfirmacionSolicitudPage.getBtnOk().click();
						}
						cotifedConfirmacionSolicitudPage.getClickInsertar(i).click();
						try { 
							String[] commands = new String[]{}; 
							commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
							Runtime.getRuntime().exec(commands); 
						} catch (IOException e) {
							System.out.println("Error dentro del catch:" +cotifedConfirmacionSolicitudPage.getErrorSharePoint4());
						}
						SeleniumWaiters.waitSeconds(7);
						cotifedGeneralidadesPage.cargarDatos3();
					} while (cotifedConfirmacionSolicitudPage.getErrorSharePoint4()!=null);
				}else if(integracionStore.tipo_documento.equals("D.N.I.")){
					cotifedConfirmacionSolicitudPage.getSelectTipoRequisitos(i,2).click();
					cotifedConfirmacionSolicitudPage.getClickSeleccionar(i).click();
					do {
						if(cotifedConfirmacionSolicitudPage.getErrorSharePoint4()!=null) {
							cotifedConfirmacionSolicitudPage.getBtnOk().click();
						}
						cotifedConfirmacionSolicitudPage.getClickInsertar(i).click();
						try { 
							String[] commands = new String[]{}; 
							commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
							Runtime.getRuntime().exec(commands); 
						} catch (IOException e) {
							System.out.println("Error dentro del catch:" +cotifedConfirmacionSolicitudPage.getErrorSharePoint4());
						}
						SeleniumWaiters.waitSeconds(7);
						cotifedGeneralidadesPage.cargarDatos3();
					} while (cotifedConfirmacionSolicitudPage.getErrorSharePoint4()!=null);
				}
			}else {
				cotifedConfirmacionSolicitudPage.getSelectTipoRequisitos(i,2).click();
				cotifedConfirmacionSolicitudPage.getClickSeleccionar(i).click();
				do {
					if(cotifedConfirmacionSolicitudPage.getErrorSharePoint4()!=null) {
						cotifedConfirmacionSolicitudPage.getBtnOk().click();
					}
					cotifedConfirmacionSolicitudPage.getClickInsertar(i).click();
					try { 
						String[] commands = new String[]{}; 
						commands = new String[]{"src\\test\\resources\\autoit\\PhotoUploadSharepoint.exe"};
						Runtime.getRuntime().exec(commands); 
					} catch (IOException e) {
						System.out.println("Error dentro del catch:" +cotifedConfirmacionSolicitudPage.getErrorSharePoint4());
					}
					SeleniumWaiters.waitSeconds(6);
					cotifedGeneralidadesPage.cargarDatos3();
				} while (cotifedConfirmacionSolicitudPage.getErrorSharePoint4()!=null);
			}
		}	
	}
	
	@When("Ingreso referencias telefonicas")
	public void ingresoReferenciasTelefonicas(DataTable referencias) {
		List<Map<String, String>> items = referencias.asMaps(String.class, String.class);
		cotifedConfirmacionSolicitudPage.scrollReferencias();
		for (int i = 0; i < items.size(); i++) {
			Map<String, String> item = items.get(i);
			cotifedConfirmacionSolicitudPage.getCbxParentesco().click();
			cotifedConfirmacionSolicitudPage.getOpcionParentesco(item.get("parentesco")).click();
			cotifedConfirmacionSolicitudPage.getTxtNombres().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			cotifedConfirmacionSolicitudPage.getTxtNombres().sendKeys(item.get("nombres"));
			cotifedConfirmacionSolicitudPage.getTxtApellidos().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			cotifedConfirmacionSolicitudPage.getTxtApellidos().sendKeys(item.get("apellidos"));
			cotifedConfirmacionSolicitudPage.getCbxPrefijo().click();
			cotifedConfirmacionSolicitudPage.getOpcionPrefijo(item.get("prefijo")).click();
			cotifedConfirmacionSolicitudPage.getTxtTelefono().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			cotifedConfirmacionSolicitudPage.getTxtTelefono().sendKeys(item.get("telefono_fijo"));
			cotifedConfirmacionSolicitudPage.getTxtCelular().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			cotifedConfirmacionSolicitudPage.getTxtCelular().sendKeys(item.get("celular"));
			cotifedConfirmacionSolicitudPage.getBtnAgregar().click();
			SeleniumWaiters.waitSeconds(5);
		}
	}

	@When("Doy click en el boton solicitar")
	public void doyClickBotonSolicitar() {
		cotifedConfirmacionSolicitudPage.getBtnSolicitar().click();
	}
	
	@When("Obtengo el numero de solicitud")
	public void obtengoNumeroSolicitud() {	
		cotifedConfirmacionSolicitudPage.getTextSolicitar();
		String nroSolicitud = cotifedConfirmacionSolicitudPage.getNroSolicitud().getText();
		file.cargarDatos(integracionStore.dni,nroSolicitud);
		System.out.println(nroSolicitud);
		System.out.println("Dni: "+integracionStore.dni);
	}
	
	@When("Valido la observación de la edad del titular")
	public void observacionesTitular() {
		System.out.println(cotifedConfirmacionSolicitudPage.getObservacionesTitular().getText());
	}
	
	@Then("Termino la solicitud")
	public void terminarSolicitud() {	
		cotifedConfirmacionSolicitudPage.getBtnOk().click();
	}
	
}










