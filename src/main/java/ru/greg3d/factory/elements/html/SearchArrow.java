package ru.greg3d.factory.elements.html;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@SuppressWarnings("serial")
public class SearchArrow extends HtmlElement{
	
	@FindBy(css=SearchArrowData.button_css)
	private Button searchButton;
	
	@FindBy(id=SearchArrowData.input_id)
	private TextInput inputText;
	
	@FindBy(css=SearchArrowData.resultsList_css)
	private WebElement serpList;

	public SearchArrow clickSearchButton(){
		searchButton.click();
		return this;
	}
	
	public SearchArrow inputText(String text){
		inputText.sendKeys(text);
		return this;
	}

}
