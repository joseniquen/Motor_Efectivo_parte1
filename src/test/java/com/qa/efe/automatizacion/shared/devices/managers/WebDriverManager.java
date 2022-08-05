package com.qa.efe.automatizacion.shared.devices.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface WebDriverManager {
    public WebDriver getDriver();
    
    public WebDriverWait getWait();
    
    public void setDriver(WebDriver driver);

    public void setupManager();
    
    public default void teardownManager() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
