package ru.greg3d.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class PageManager {

	private WebDriver driver;

	public YandexRuPage yandexRuPage;
	public YandexRuCalcPage yandexRuCalcPage;

	public PageManager(WebDriver driver) {
		this.driver = driver;
		yandexRuPage = initHTMLElements(new YandexRuPage(this));
		yandexRuCalcPage = initHTMLElements(new YandexRuCalcPage(this));
	}

	private <T extends Page> T initHTMLElements(T page) {
	
		PageFactory.initElements(
                new HtmlElementDecorator(
                        new HtmlElementLocatorFactory(driver)), page);
		
		return page;
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}

}
