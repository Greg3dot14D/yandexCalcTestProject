package ru.greg3d.applogic.implementations;

import org.openqa.selenium.WebDriver;

import ru.greg3d.applogic.interfaces.IApplicationManager;
import ru.greg3d.applogic.interfaces.INavigationHelper;
import ru.greg3d.applogic.interfaces.IYandexRuCalcHelper;
import ru.greg3d.applogic.interfaces.IYandexRuHelper;
import ru.greg3d.browsers.BrowserDriver;
import ru.greg3d.browsers.TracingWebDriver;
import ru.greg3d.factory.fake.fakeDriver;
import ru.greg3d.util.*;

public class ApplicationManager implements IApplicationManager {

	private INavigationHelper navHelper;
	private IYandexRuHelper yandexRuHelper;
	private IYandexRuCalcHelper yandexRuCalcHelper;

	private WebDriver driver;
	private String baseUrl;

	public ApplicationManager() {
		this(null);
	}

	public ApplicationManager(String capabilitiesName) {
		this.baseUrl = PropertyLoader.loadProperty("site.url");
		if (capabilitiesName.equals("fake"))
			driver = fakeDriver.getDriver();
		else
			driver = new TracingWebDriver(
					BrowserDriver.getEventFiringWebDriver(BrowserDriver.newDriver(capabilitiesName)));
		navHelper = new NavigationHelper(this);
		yandexRuHelper = new YandexRuHelper(this);
		yandexRuCalcHelper = new YandexRuCalcHelper(this);

		getNavigationHelper().openMainPage();
	}

	//@Override
	public INavigationHelper getNavigationHelper() {
		return navHelper;
	}

	//@Override
	public IYandexRuHelper getYandexRuHelper() {
		return yandexRuHelper;
	}

	//@Override
	public IYandexRuCalcHelper getYandexRuCalcHelpe() {
		return yandexRuCalcHelper;
	}

	protected WebDriver getWebDriver() {
		return driver;
	}

	protected String getBaseUrl() {
		return baseUrl;
	}

	//@Override
	public void stop() {
		if (driver != null) {
			driver.quit();
		}
	}
}
