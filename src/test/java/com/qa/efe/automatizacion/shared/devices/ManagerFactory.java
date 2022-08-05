package com.qa.efe.automatizacion.shared.devices;

import com.qa.efe.automatizacion.shared.devices.managers.ChromeManager;
import com.qa.efe.automatizacion.shared.devices.managers.EdgeManager;
import com.qa.efe.automatizacion.shared.devices.managers.FirefoxManager;

import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.picocontainer.PicoFactory;


public class ManagerFactory implements ObjectFactory {
	
	private PicoFactory delegate = new PicoFactory();

    public ManagerFactory() {
        switch (Device.getDevice()) {
            case FIREFOX:
                addClass(FirefoxManager.class);
                break;
            case CHROME:
                addClass(ChromeManager.class);
                break;
            case EDGE:
                addClass(EdgeManager.class);
                break;
            default: // if no device is specified, use Chrome
                addClass(ChromeManager.class);
        }
    }

    @Override
    public void start() {
        delegate.start();
    }

    @Override
    public void stop() {
        delegate.stop();
    }

    @Override
    public boolean addClass(Class<?> aClass) {
        return delegate.addClass(aClass);
    }

    @Override
    public <T> T getInstance(Class<T> aClass) {
        return delegate.getInstance(aClass);
    }
}
