package com.qa.efe.automatizacion.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.efe.automatizacion.pages.CredifedOfertaComercialPage;
import com.qa.efe.automatizacion.shared.SeleniumWaiters;
import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.en.When;

public class CredifedOfertaComercialSteps {
	private WebDriver driver;
	private CredifedOfertaComercialPage credifedOfertaComercialPage;
	public CredifedOfertaComercialSteps( WebDriverManager driverManager,CredifedOfertaComercialPage credifedOfertaComercialPage) {
		this.driver = driverManager.getDriver();
		this.credifedOfertaComercialPage = credifedOfertaComercialPage;
	}
	@When("doy click en simular")
	public void click_simular()
	{
		credifedOfertaComercialPage.click_simular().click();
	}
	@When("doy click en aprobar")
	public void click_aprobar()
	{
		credifedOfertaComercialPage.click_aprobar().click();
	}
	@When("doy click en aceptar solicitud de credito")
	public void click_aceptar()
	{
		
		credifedOfertaComercialPage.click_aceptar().click();
		credifedOfertaComercialPage.click_confirmar().click();
	}
	@When("verificar que estemos en la pantalla resumen del credito")
	public void verificar_pantalla_resumen()
	{
		credifedOfertaComercialPage.verificar_resumen_sol();
	}
	@When("verificar que la solicitud de credito haya sido aprobada correctamente")
	public void verificar_sol_aprobada()
	{
		SeleniumWaiters.waitSeconds(30);
		List<WebElement> element = credifedOfertaComercialPage.verificar_sol_aprobada();
		List<WebElement> element1 = credifedOfertaComercialPage.verificar_excepciones();
		if (element1.size()!=0) {
			System.out.println("La solicitud de credito contiene una excepcion");
		} else {
			System.out.println("Su solicitud ah sido registrada y aprobada correctamente ");
		}
	}
}
