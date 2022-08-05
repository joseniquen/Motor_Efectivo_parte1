package com.qa.efe.automatizacion.config;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/resources/feature", 
		glue= {"com.qa.motor.steps"},
		monochrome = true,
		plugin= {
				"pretty", 
				"junit:target/cucumber-reports/junit/junit.xml",		
				"json:target/cucumber-reports/json/cucumber.json",
				"html:target/cucumber-reports/html"
		}
)
public class CucumberRunner {

}
