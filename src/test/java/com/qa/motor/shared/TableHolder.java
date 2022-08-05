package com.qa.motor.shared;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableHolder {

	private final WebElement table;
	private final int width;
	private List<String> tableContent;
	
	public TableHolder(WebElement table, int width) {
		this.table = table;
		this.width = width;
		this.configureTable();
	}	
	
	private void configureTable() {
		this.tableContent =  this.table.findElement(By.cssSelector(".::all-cells"))
				.findElements(By.tagName("text"))
				.stream()
				.filter((el) -> !el.getText().isEmpty())
				.map(WebElement::getText)
				.collect(Collectors.toList());
	}
	
	private int toIndex(int row, int col) {
		return row * width + col;
	}
	
	public String get(int row, int col) {
		return tableContent.get(this.toIndex(row, col));
	}
}
