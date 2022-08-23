package com.qa.efe.automatizacion.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.efe.automatizacion.shared.devices.managers.WebDriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class WebSharedSteps {
	private final WebDriverManager manager;
	
	public WebSharedSteps(WebDriverManager manager) {
		this.manager = manager;
	}
	
	@Before("@web")
	public void setup() {
		manager.getDriver().manage().window().maximize();
	}
	
	@BeforeStep("@web")
	public void takeScreenhot(Scenario scenario) {
		byte[] screenshot = ((TakesScreenshot)manager.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}
	
	@After("@web")
	public void tearDown() {

	}
}
