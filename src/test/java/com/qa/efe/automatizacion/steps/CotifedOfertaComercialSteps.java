package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.efe.automatizacion.pages.CotifedGeneralidadesPage;

import com.qa.efe.automatizacion.pages.CotifedOfertaComercialPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CotifedOfertaComercialSteps {
	private CotifedOfertaComercialPage cotifedOfertaComercialPage;
	private WebDriver driver;
	private CotifedGeneralidadesPage generalidadesPage;

	public CotifedOfertaComercialSteps( WebDriverManager driverManager,CotifedGeneralidadesPage generalidadesPage, CotifedOfertaComercialPage cotifedOfertaComercialPage
			 ) {
		this.driver = driverManager.getDriver();
		this.cotifedOfertaComercialPage = cotifedOfertaComercialPage;
		this.generalidadesPage=generalidadesPage;
	}
	@When("Valido que se recupero ingreso vigente")
	public void validoIngresoVigente() {
		if(cotifedOfertaComercialPage.getValidaIngresoVigente().size()!=0) {
			cotifedOfertaComercialPage.getValidaIngresoVigenteButtonOk().click();
		}
		generalidadesPage.cargarDatos();
	}
	@Then("Ingreso modelo de producto {string}")
	public void ingreso_modelo_producto(String modelo) {
		cotifedOfertaComercialPage.getTxtModeloProducto().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtModeloProducto().sendKeys(modelo);
	}

	@Then("seleciono coincidencia de modelo de producto")
	public void seleciono_coincidencia_modelo_producto( ){
		cotifedOfertaComercialPage.getModeloProductoSelect().click();
		SeleniumWaiters.waitSeconds(5);
	}
	
	@Then("Ingreso precio de venta de producto {string}")
	public void ingreso_precio_producto(String precio) {
		cotifedOfertaComercialPage.getTxPrecioProducto().click();
		cotifedOfertaComercialPage.getTxPrecioProducto().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxPrecioProducto().sendKeys(precio);
	}
	
	@And("Valido seguros marcados")
	public void validoSegurosMarcados() {
		cotifedOfertaComercialPage.validarSegurosMarcados();
	}
	
	@And("Selecciono seguros")
	public void seleccionoSeguros(DataTable seguros) {
		List<Map<String, String>> items = seguros.asMaps(String.class, String.class);
		for (int i = 0; i < items.size(); i++) {
			Map<String, String> item = items.get(i);
			cotifedOfertaComercialPage.getSeleccionTipoSeguro(item.get("seguros")).click();
		}
	}
	
	@And("Titular selecciono estado civil {string}")
	public void titularSeleccionoEstadoCivil(String estado) {
		if (cotifedOfertaComercialPage.getCbxEstadoExiste().size()!=0) {
			cotifedOfertaComercialPage.getCbxEstado().click();
			cotifedOfertaComercialPage.getOpcionEstado(estado).click();
		}
		else{
			System.out.println("Campo deshabilitado");
		}
	}
	
	@And("Titular selecciono pais {string}")
	public void titularSeleccionoPais(String pais) {
		cotifedOfertaComercialPage.getCbxPais().click();
		cotifedOfertaComercialPage.getOpcionPais(pais).click();
	}
	
	@And("Titular selecciono tipo de vivienda {string}")
	public void titularSeleccionoTipoVivienda(String tipoVivienda) {
		if (cotifedOfertaComercialPage.getCbxTipoViviendaExiste().size()!=0) {
			cotifedOfertaComercialPage.getCbxTipoVivienda().click();
			cotifedOfertaComercialPage.getOpcionTipoVivienda(tipoVivienda).click();
		}
		else{
			System.out.println("campo deshabilitado");
		}
	}
	
	@And("Titular ingreso antiguedad domicialiaria en años {string}")
	public void titularIngresoAntiguedadDomicialiariaAnios(String anios) {
		cotifedOfertaComercialPage.getTxtAntDomAnios().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtAntDomAnios().sendKeys(anios);
	}
	
	@And("Titular ingreso antiguedad domicialiaria en meses {string}")
	public void titularIngresoAntiguedadDomicialiariaMeses(String meses) {
		cotifedOfertaComercialPage.getTxtAntDomMeses().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtAntDomMeses().sendKeys(meses);
	}
	
	@And("Titular ingreso declarado {string}")
	public void titularIngresoDeclarado(String ingresoDeclarado) {	
		if (cotifedOfertaComercialPage.getTxtIngresoDeclaradoReadOnly()==null) {
			cotifedOfertaComercialPage.getTxtIngresoDeclarado().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			cotifedOfertaComercialPage.getTxtIngresoDeclarado().sendKeys(ingresoDeclarado);	
		}else if(cotifedOfertaComercialPage.getTxtIngresoDeclaradoReadOnly().equals("true")) {
			System.out.println("EL CHECK ESTÁ MARCADO");
		}
		generalidadesPage.cargarDatos();
	}
	
	@And("Titular doy check a usar ingreso declarado")
	public void titularDoyCheckUsarIngresoDeclarado() {
		if (cotifedOfertaComercialPage.getTxtIngresoDeclaradoReadOnly()==null) {
			cotifedOfertaComercialPage.getCheckIngreso().click();
		}else if(cotifedOfertaComercialPage.getTxtIngresoDeclaradoReadOnly().equals("true")) {
				System.out.println("EL CHECK ESTÁ SELECCIONADO");	
		}	
	}
	
	@And("Titular ingreso situacion {string}")
	public void titularIngresoSituacion(String situacion) {
		if(cotifedOfertaComercialPage.getSituacionExiste().size()!=0) {
			if (cotifedOfertaComercialPage.getSituacion().isEnabled()) {
				cotifedOfertaComercialPage.getSituacion().click();
				cotifedOfertaComercialPage.getOpcionSituacion(situacion).click();
			}
			else{
				System.out.println("campo deshabilitado");
			}
		}else {
			System.out.println("campo no existe");
		}
		generalidadesPage.cargarDatos();	
	}
	
	@And("Titular ingreso ocupacion {string}")
	public void TitularIngresoOcupacion(String ocupacion) {
		if(cotifedOfertaComercialPage.getOcupacionExiste().size()!=0) {
			if (cotifedOfertaComercialPage.getOcupacion().isEnabled()) {
				cotifedOfertaComercialPage.getOcupacion().click();
				cotifedOfertaComercialPage.getOpcionOcupacion(ocupacion).click();
			}
			else{
				System.out.println("campo deshabilitado");
			}
		}else {
			System.out.println("campo no existe");
		}
		generalidadesPage.cargarDatos();	
	}
	
	@And("Titular ingreso antiguedad laboral en años {string}")
	public void titularIngresoAntiguedadLaboralAnios(String LabAnios) {
		cotifedOfertaComercialPage.getTxtAntLabAnios().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtAntLabAnios().sendKeys(LabAnios);
	}
	
	@And("Titular ingreso antiguedad laboral en meses {string}")
	public void titularIngresoAntiguedadLaboralMeses(String LabMeses) {
		cotifedOfertaComercialPage.getTxtAntLabMeses().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtAntLabMeses().sendKeys(LabMeses);
	}
	
	@When("Titular ingreso inicial {string}")
	public void Titular_ingreso_inicial(String inicial) {
		cotifedOfertaComercialPage.getTxtInicial().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtInicial().sendKeys(inicial);
	}
	
	@And("Titular ingreso cantidad a solicitar {string}")
	public void titularIngresoCantidadASolicitar(String cantidadASolicitar) {
		cotifedOfertaComercialPage.getTxtCantidadASolicitar().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtCantidadASolicitar().sendKeys(cantidadASolicitar);
	}
	
	@And("Titular selecciono fecha de pago {string}")
	public void titularFechaPago(String fechaPago) {
		SeleniumWaiters.waitSeconds(3);
		cotifedOfertaComercialPage.getCbxFechaPago().click();
		SeleniumWaiters.waitSeconds(2);
		cotifedOfertaComercialPage.getOpcionFechaPago(fechaPago).click();
		generalidadesPage.cargarDatos();
	}
	
	@When("Titular selecciono requisito {string}")
	public void titularSeleccionoRequisito(String requisito) {
		SeleniumWaiters.waitSeconds(3);
		cotifedOfertaComercialPage.getRequiereAval().click();
		SeleniumWaiters.waitSeconds(2);
		cotifedOfertaComercialPage.getOpcionRequiereAval(requisito).click();
		generalidadesPage.cargarDatos();
	}
	
	@And("Doy click en el boton simular")
	public void doyClickBotonSimular() {
		cotifedOfertaComercialPage.getBtnSimular().click();
		generalidadesPage.cargarDatos();
	}
	
	@When("Elijo campaña {string} con plazo {string}")
	public void elijoCampaniaConPlazo(String campania,String plazo)
	{
		List<String> columns = cotifedOfertaComercialPage.getColumnas()
				.stream()
				.map(we -> we.getText())
				.collect(Collectors.toList());
		List<String> columnss =new ArrayList<String>();
		for (int i = 0; i < columns.size(); i++) {
		List<String> palabras =	Arrays.asList(columns.get(i));
		columnss.add(palabras.get(0));
		}
		int columnIndex = columnss.indexOf(campania);
		columnIndex=columnIndex+1;
		String xpathForCreditSelection = "//table/tbody/tr/td/p[text()='"+plazo+"']/parent::td/parent::tr/td["+columnIndex+"]/div";
		SeleniumWaiters.findElement(driver,By.xpath(xpathForCreditSelection),10).click();
		generalidadesPage.cargarDatos();
	}
	
	@When("Doy click en el boton continuar")
	public void doyClickBotonContinuar() {
		cotifedOfertaComercialPage.getBtnContinuar().click();
		generalidadesPage.cargarDatos();
	}
	
	@And("Conyuge selecciono tipo de documento {string}")
	public void conyugeSeleccionoTipoDocumento(String conyugeTipoDocumento) {
		cotifedOfertaComercialPage.getCbxConyugeTipoDoc().click();
		cotifedOfertaComercialPage.getOpcionConyugeTipoDoc(conyugeTipoDocumento).click();
	}
	
	@And("Conyuge ingreso numero de documento {string}")
	public void conyugeIngresoNumeroDocumento(String conyugeNumeroDocumento) {
		cotifedOfertaComercialPage.getTxtConyugeNumeroDocumento().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtConyugeNumeroDocumento().sendKeys(conyugeNumeroDocumento);
	}
	@And("Conyuge doy click en filtrar")
	public void conyugeDoyClickFiltrar() {
		cotifedOfertaComercialPage.getBtnConyugeFiltrar().click();
		generalidadesPage.cargarDatos();

	}
	
	@And("Conyuge selecciono estado civil {string}")
	public void conyugeSeleccionoEstadoCivil(String conyugeEstadoCivil) {
		cotifedOfertaComercialPage.getCbxConyugeEstadoCivil().click();
		cotifedOfertaComercialPage.getOpcionConyugeEstadoCivil(conyugeEstadoCivil).click();
	}
	
	@And("Conyuge selecciono departamento {string}")
	public void conyugeSeleccionoDepartamento(String conyugeDepartamento) {
		cotifedOfertaComercialPage.getCbxConyugeDepartamento().click();
		cotifedOfertaComercialPage.getOpcionConyugeDepartamento(conyugeDepartamento).click();
	}
	
	@And("Conyuge selecciono provincia {string}")
	public void conyugeSeleccionoProvincia(String conyugeProvincia) {
		cotifedOfertaComercialPage.getCbxConyugeProvincia().click();
		cotifedOfertaComercialPage.getOpcionConyugeProvincia(conyugeProvincia).click();
	}
	
	@And("Conyuge selecciono distrito {string}")
	public void conyugeSeleccionoDistrito(String conyugeDistrito) {
		cotifedOfertaComercialPage.getCbxConyugeDistrito().click();
		cotifedOfertaComercialPage.getOpcionConyugeDistrito(conyugeDistrito).click();
	}
	
	@And("Conyuge selecciono tipo de vivienda {string}")
	public void conyugeSeleccionoTipoVivienda(String conyugeTipoVivienda) {
		cotifedOfertaComercialPage.getCbxConyugeTipoVivienda().click();
		cotifedOfertaComercialPage.getOpcionConyugeTipoVivienda(conyugeTipoVivienda).click();
	}
	
	@And("Conyuge ingreso antiguedad domiciliaria en años {string}")
	public void conyugeIngresoAntiguedadDomiciliariaAnios(String conyugeAntDomAnios) {
		cotifedOfertaComercialPage.getTxtConyugeAntDomAnios().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtConyugeAntDomAnios().sendKeys(conyugeAntDomAnios);
	}
	
	@And("Conyuge ingreso antiguedad domiciliaria en meses {string}")
	public void conyugeIngresoAntiguedadDomiciliariaMeses(String conyugeAntDomMeses) {
		cotifedOfertaComercialPage.getTxtConyugeAntDomMeses().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtConyugeAntDomMeses().sendKeys(conyugeAntDomMeses);
	}
	
	@And("Conyuge selecciono perfil situacion {string}")
	public void conyugeSeleccionoPerfilSituacion(String conyugePerfilSituacion) {
		cotifedOfertaComercialPage.getCbxConyugePerfilSituacion().click();
		cotifedOfertaComercialPage.getOpcionConyugePerfilSituacion(conyugePerfilSituacion).click();
	}
	
	@And("Conyuge selecciono ocupacion {string}")
	public void conyugeSeleccionoOcupacion(String conyugeOcupacion) {
		cotifedOfertaComercialPage.getCbxConyugeOcupacion().click();
		cotifedOfertaComercialPage.getOpcionConyugeOcupacion(conyugeOcupacion).click();
	}
	
	@And("Conyuge ingreso ingreso {string}")
	public void conyugeIngresoIngreso(String conyugeIngreso) {
		cotifedOfertaComercialPage.getTxtConyugeIngreso().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtConyugeIngreso().sendKeys(conyugeIngreso);
	}
	
	@And("Conyuge ingreso antiguedad laboral en años {string}")
	public void conyugeIngresoAntiguedadLaboralAnios(String conyugeAntLabAnios) {
		cotifedOfertaComercialPage.getTxtConyugeAntLabAnios().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtConyugeAntLabAnios().sendKeys(conyugeAntLabAnios);
	}
	
	@And("Conyuge ingreso antiguedad laboral en meses {string}")
	public void conyugeIngresoAntiguedadLaboralMeses(String conyugeAntLabMeses) {
		cotifedOfertaComercialPage.getTxtConyugeAntLabMeses().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		cotifedOfertaComercialPage.getTxtConyugeAntLabMeses().sendKeys(conyugeAntLabMeses);
	}
}
