/**
 * @author greg3d
 *
 */
package ru.greg3d.events;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.greg3d.util.WaitUtils;

public class WebEventListener extends AbstractWebDriverEventListener {

	private static Logger LOG = LoggerFactory.getLogger(WebEventListener.class);
	
	private String getElementLocator(String locator){
		return new String ("Element.[" + locator.split(" -> ")[1]);
	} 
	
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		LOG.debug("beforeChangeValueOf: [{}] = [{}]", getElementLocator(element.toString()), Optional.of(element.getAttribute("value")).orElse(""));
	}
	
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		LOG.debug("afterChangeValueOf: [{}] = [{}]", getElementLocator(element.toString()), Optional.of(element.getAttribute("value")).orElse(""));
	}
	
	public void beforeNavigateTo(String url, WebDriver driver) {
		//LOG.debug("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		 //LOG.debug("Navigated to: '" + url + "'");
		WaitUtils.WaitPageIsNotActive(driver);
		WaitUtils.WaitPageIsActive(driver);
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		LOG.debug("beforeClickOn [{}]",getElementLocator(element.toString()));
		// Wait element is clickable
		WaitUtils.waitElementIsClickable(driver, element, 10);
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		// Дожидаемся обновления формы после клика, после клика может идти findBy, которого еще нет на форме до окончания обновления 
		LOG.debug("afterClickOn [{}]",getElementLocator(element.toString()));
		WaitUtils.WaitPageIsNotActive(driver);
		WaitUtils.WaitPageIsActive(driver);
	}

	public void onException(Throwable error, WebDriver driver) {
		LOG.error("Error occurred: " + error);
	}
}