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
import ru.greg3d.util.Tools;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class YandexRuCalcPage extends AnyPage implements ClipboardOwner{

	@FindBy(css=".serp-header__search2")
	public HtmlElement arrow;
	
	@FindBy(css=".serp-item.z-calculator")
	private Calc calc ;
	
	public YandexRuCalcPage(PageManager pages) {
		super(pages);
	}
	
	public YandexRuCalcPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.cssSelector(".serp-item.z-calculator")));
		return this;
	}
	
	public YandexRuCalcPage clickSqrt(){
		calc.sqrt.click();
		return this;
	}
	
	public YandexRuCalcPage clickCos(){
		calc.cos.click();
		return this;
	}
	
	public YandexRuCalcPage clickPi(){
		calc.Pi.click();
		return this;
	}
	
	public YandexRuCalcPage clickMultiply(){
		calc.multiply.click();
		return this;
	}
	
	public YandexRuCalcPage clickDivide(){
		calc.divide.click();
		return this;
	}
	
	public YandexRuCalcPage clickResult(){
		calc.result.click();
		return this;
	}
	
	public YandexRuCalcPage clickCE(){
		calc.CE.click();
		return this;
	}
	
	public YandexRuCalcPage switchTumblerToRad(){
		if(calc.tumbler.isGradSelected())
			calc.tumbler.click();
		return this;
	}
	
	public YandexRuCalcPage switchTumblerToGrad(){
		if(calc.tumbler.isRadSelected())
			calc.tumbler.click();
		return this;
	}
	
	public String getInputText(){
		//return Optional.of(calc.textInput.getWrappedElement().getAttribute("value")).orElse("");
		return calc.textInput.getText();
	}
	
	
	public String getResultText(){
		return calc.textInput.getText();
	}
	
	public YandexRuCalcPage setTextInput(String text){
		calc.textInput.sendKeys(text);
		return this;
	}
	
	public YandexRuCalcPage setTextInputByCtrlV(String text){
		Tools.setClipboardContents(text, this);
		//setClipboardContents (text);
		calc.textInput.sendKeys(Keys.CONTROL + "v");
		return this;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		
	}
}
