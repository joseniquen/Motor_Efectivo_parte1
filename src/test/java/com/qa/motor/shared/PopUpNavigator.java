package com.qa.motor.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;

import com.qa.motor.shared.devices.managers.JavaDriverManager;

public class PopUpNavigator {

	private WebDriver driver;
	private int currentWindowIndex;
	
	public PopUpNavigator(JavaDriverManager manager) {
		this.driver = manager.getDriver();
		this.currentWindowIndex = 0;
	}
	
	public List<String> getWindows() {
		return new ArrayList<>(driver.getWindowHandles());
	}
	
	public String getWindowId(int windowIndex) {
		List<String> windows = this.getWindows();
		if(windowIndex >= windows.size()) {
			throw new RuntimeException("Windows is not available");
		}
		return windows.get(windowIndex);
	}
	
	public WebDriver focusWindow() {
		currentWindowIndex++;
		return focusCurrentIndex();
	}
	
	private WebDriver focusCurrentIndex() {
		return driver.switchTo().window(getWindowId(currentWindowIndex));
	}
	
	public WebDriver unfocusWindow() {
		currentWindowIndex--;
		return focusCurrentIndex();
	}
	
	public void onFocusedWindow(Consumer<WebDriver> doOnFocused) {
		focusWindow();
		doOnFocused.accept(driver);
		unfocusWindow();
	}
	
	public <T> T onFocusedWindow(Function<WebDriver, T> doOnFocused) {
		focusWindow();
		T value = doOnFocused.apply(driver);
		unfocusWindow();
		return value;
	}
}
