package ru.greg3d.pages;

import org.openqa.selenium.support.FindBy;

import ru.greg3d.factory.elements.html.SearchArrow;

public class YandexRuPage extends AnyPage{

	@FindBy(css=".home-arrow")
	public SearchArrow arrow;
	
	public YandexRuPage(PageManager pages) {
		super(pages);
	}
}
