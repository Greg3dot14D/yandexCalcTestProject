package ru.greg3d.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import ru.greg3d.factory.elements.html.Calc;
import ru.greg3d.util.Fields;
import ru.greg3d.util.Tools;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class YandexRuCalcPage extends AnyPage{

	private static final String calcCssSelector = ".serp-item.z-calculator";
	
	@FindBy(css=".serp-header__search2")
	public HtmlElement arrow;
	
	@FindBy(css=calcCssSelector)
	public Calc calc ;

	public YandexRuCalcPage(PageManager pages) {
		super(pages);
	}
	
	public YandexRuCalcPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.cssSelector(calcCssSelector)));
		return this;
	}

	public YandexRuCalcPage setTextInputByCopyPast(String text){
		Tools.setClipboardContents(text, this);
		calc.sendKeysToTextInput(Keys.CONTROL + "v");
		return this;
	}

	public YandexRuCalcPage clickCalcButtonByAnnotationName(String annotationName){
		((Button) Fields.getFieldByAnnotationName(
				this.calc, annotationName)).click();
		return this;
	}
}
