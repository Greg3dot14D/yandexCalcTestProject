package ru.greg3d.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import ru.greg3d.factory.elements.html.Calc;
import ru.greg3d.util.Fields;
import ru.greg3d.util.Tools;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class YandexRuCalcPage extends AnyPage{

	@FindBy(css=".serp-header__search2")
	public HtmlElement arrow;
	
	@FindBy(css=".serp-item.z-calculator")
	public Calc calc ;

	public YandexRuCalcPage(PageManager pages) {
		super(pages);
	}
	
	public YandexRuCalcPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.cssSelector(".serp-item.z-calculator")));
		return this;
	}

	public YandexRuCalcPage setTextInputByCopyPast(String text){
		Tools.setClipboardContents(text, this);
		calc.textInput.sendKeys(Keys.CONTROL + "v");
		return this;
	}

}
