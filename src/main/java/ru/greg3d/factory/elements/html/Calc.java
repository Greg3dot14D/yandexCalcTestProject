package ru.greg3d.factory.elements.html;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class Calc extends HtmlElement{

	@FindBy(css=".input__control")
	public TextInput textInput;
	
	@FindBy(xpath="//span[@class='button__text' and text()='√']/..")
	public Button sqrt;
	
	@FindBy(xpath="//span[@class='button__text' and text()='cos']/..")
	public Button cos;
	
	@FindBy(xpath="//span[@class='button__text' and text()='π']/..")
	public Button Pi;
	
	@FindBy(xpath="//span[@class='button__text' and text()='×']/..")
	public Button multiply;
	
	@FindBy(xpath="//span[@class='button__text' and text()='÷']/..")
	public Button divide;
	
	@FindBy(xpath="//span[@class='button__text' and text()='=']/..")
	public Button result;	
	
	@FindBy(xpath="//span[@class='button__text' and text()='CE']/..")
	public Button CE;
	
	@FindBy(css=".tumbler.tumbler_size_s")
	public Tumbler tumbler;
}
