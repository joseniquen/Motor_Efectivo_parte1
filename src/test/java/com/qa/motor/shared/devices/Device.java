package com.qa.motor.shared.devices;

public enum Device {
    FIREFOX, CHROME, EDGE;

    /**
     * allows the browser selected to be passed in with a case insensitive name
     *
     * @param b - the string name of the browser
     * @return Browser: the enum version of the browser
     * @throws InvalidDeviceException If a browser that is not one specified in the
     *                                Selenium.Browser class is used, this exception will be thrown
     */
    public static Device lookup(String b) throws InvalidDeviceException {
        for (Device browser : Device.values()) {
            if (browser.name().equalsIgnoreCase(b)) {
                return browser;
            }
        }
        throw new InvalidDeviceException("The selected device " + b + " is not an applicable choice");
    }

    public static Device getDevice() {
        Device device = Device.CHROME;
        if (System.getProperty("device") != null) {
            try {
                device = Device.lookup(System.getProperty("device"));
            } catch (Exception e) {
                System.out.println("Provided device does not match options. Using Chrome instead. " + e);
            }
        }
        return device;
    }
}