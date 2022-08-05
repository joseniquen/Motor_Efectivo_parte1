package com.qa.efe.automatizacion.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
	
	private Properties properties;
	
	public PropertiesManager() {
		properties = loadProperties();
	}
	
	public Properties loadProperties() {
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return null;
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            
            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
