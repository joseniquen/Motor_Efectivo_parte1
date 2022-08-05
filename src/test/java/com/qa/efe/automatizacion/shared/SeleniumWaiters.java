package com.qa.efe.automatizacion.shared;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaiters {
	public static WebElement findElement(WebDriver driver, By by) {
		return findElement(driver, by, 10000);
	}
	
	public static WebElement findElement(WebDriver driver, By by, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public static WebElement findClickableElement(WebDriver driver, By by,  int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public static void waitSeconds(int secondsToWait) {
		try {
			Thread.sleep(secondsToWait * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
