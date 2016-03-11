package ru.greg3d.applogic.implementations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.greg3d.pages.PageManager;

public class DriverBasedHelper {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected PageManager pages;

	protected static Logger LOG = LoggerFactory.getLogger(DriverBasedHelper.class);
	
	public DriverBasedHelper(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		pages = new PageManager(driver);
	}

}
