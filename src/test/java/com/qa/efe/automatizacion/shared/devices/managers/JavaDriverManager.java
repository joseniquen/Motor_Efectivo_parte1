package com.qa.efe.automatizacion.shared.devices.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.qa.efe.automatizacion.config.PropertiesManager;

import net.sourceforge.marathon.javadriver.JavaDriver;
import net.sourceforge.marathon.javadriver.JavaProfile;
import net.sourceforge.marathon.javadriver.JavaProfile.LaunchMode;
import net.sourceforge.marathon.javadriver.JavaProfile.LaunchType;

public class JavaDriverManager {

	private WebDriver driver;
	private PropertiesManager propertiesManager;
	
	public JavaDriverManager(PropertiesManager propertiesManager) {
		this.propertiesManager = propertiesManager;
		setupManager();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setupManager() {
		String posRoute = propertiesManager.getProperties().getProperty("gea.pos");
        JavaProfile profile = new JavaProfile(LaunchMode.COMMAND_LINE);
        profile.setLaunchType(LaunchType.FX_APPLICATION);
        profile.setCommand(posRoute);
        driver = new JavaDriver(profile);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
