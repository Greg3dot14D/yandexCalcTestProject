package ru.greg3d.factory.elements.html;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.annotations.Timeout;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class Calc extends HtmlElement{

	@FindBy(css=".input__control")
	private TextInput textInput;
	
	@FindBy(css=".z-calculator-display__error")
	private TextBlock errorMessage;
	
	@Name("√")
	@FindBy(xpath="//span[@class='button__text' and text()='√']/..")
	private Button sqrt;
	
	@Name("cos")
	@FindBy(xpath="//span[@class='button__text' and text()='cos']/..")
	private Button cos;
	
	@Name("π")
	@FindBy(xpath="//span[@class='button__text' and text()='π']/..")
	private Button Pi;
	
	@Name("×")
	@FindBy(xpath="//span[@class='button__text' and text()='×']/..")
	private Button multiply;
	
	@Name("÷")
	@FindBy(xpath="//span[@class='button__text' and text()='÷']/..")
	private Button divide;
	
	@FindBy(xpath="//span[@class='button__text' and text()='=']/..")
	private Button result;	
	
	@FindBy(xpath="//span[@class='button__text' and text()='CE']/..")
	private Button CE;
	
	@FindBy(css=".tumbler.tumbler_size_s")
	private Tumbler tumbler;
	
	@Name("1")
	@FindBy(xpath="//span[@class='button__text' and text()='1']/..")
	private Button num_1;
	
	@Name("2")
	@FindBy(xpath="//span[@class='button__text' and text()='2']/..")
	private Button num_2;	
	
	@Name("4")
	@FindBy(xpath="//span[@class='button__text' and text()='4']/..")
	private Button num_4;
	
	@Name("5")
	@FindBy(xpath="//span[@class='button__text' and text()='5']/..")
	private Button num_5;
	
	@Name("0")
	@FindBy(xpath="//span[@class='button__text' and text()='0']/..")
	private Button num_0;	
	
	@Name(",")
	@FindBy(xpath="//span[@class='button__text' and text()=',']/..")
	private Button dot;
	
//	public Calc  clickSqrt(){
//		sqrt.click();
//		return this;
//	}
//	
//	public Calc  clickCos(){
//		cos.click();
//		return this;
//	}
//	
//	public Calc  clickPi(){
//		Pi.click();
//		return this;
//	}
//	
//	public Calc  clickMultiply(){
//		multiply.click();
//		return this;
//	}
//	
//	public Calc  clickDivide(){
//		divide.click();
//		return this;
//	}
//	
	public Calc  clickResult(){
		result.click();
		return this;
	}
	
	public Calc  clickCE(){
		CE.click();
		return this;
	}
	
	public Calc  switchTumblerToRad(){
		if(tumbler.isRightSelected())
			tumbler.click();
		return this;
	}
	
	public Calc  switchTumblerToGrad(){
		if(tumbler.isLeftSelected())
			tumbler.click();
		return this;
	}
	
	public String getResultText(){
		return textInput.getText();
	}
	
	public Calc sendKeysToTextInput(String text){
		textInput.sendKeys(text);
		return this;
	}
	
	public boolean errorMessageIsDisplayed(){
		return errorMessage.isDisplayed();
	}
}
