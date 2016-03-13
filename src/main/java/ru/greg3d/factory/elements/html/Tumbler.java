package ru.greg3d.factory.elements.html;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class Tumbler extends HtmlElement{

	@FindBy(css=".tumbler__input.tumbler__input_side_left")
	private HtmlElement left;
	
	@FindBy(css=".tumbler__input.tumbler__input_side_right")
	private HtmlElement right;
	
	public boolean isLeftSelected(){
		return left.isSelected();
	}
	
	public boolean isRightSelected(){
		return right.isSelected();
	}

}
