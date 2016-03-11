package ru.greg3d.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.greg3d.util.Fields;
import ru.greg3d.util.WaitUtils;

/*
 * Abstract class representation of a Page in the UI. Page object pattern
 * 
 * @author Sebastiano Armeli-Battana
 */
public abstract class Page{

	protected String url = "/";
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected PageManager pages;
	
	protected Logger LOG = LoggerFactory.getLogger(Page.class);
	
	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	public Page(PageManager pages) {
		this.pages = pages;
		driver = pages.getWebDriver();
		wait = new WebDriverWait(driver, 10);
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public Page ensurePageLoaded() {
		return this;
	}
	
	public boolean pageIsOpen(){
		LOG.debug("pageIsOpen, wiat '{}' was '{}'", this.getUrl(), driver.getCurrentUrl());
		return driver.getCurrentUrl().contains(this.getUrl());
	}
	
	private String getUrl(){
		return (Fields.getValueOfString(this, "url")); 
	}

	public boolean waitPageLoaded() {
		try {
			ensurePageLoaded();
			return true;
		} catch (TimeoutException to) {
			return false;
		}
	}
	
	public boolean waitPageRefreshed(){
		WaitUtils.WaitPageIsNotActive(driver);
		return WaitUtils.WaitPageIsActive(driver);
	}
}
