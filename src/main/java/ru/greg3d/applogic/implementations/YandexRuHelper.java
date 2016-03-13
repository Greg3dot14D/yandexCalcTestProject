package ru.greg3d.applogic.implementations;

import ru.greg3d.applogic.interfaces.IYandexRuHelper;

public class YandexRuHelper extends DriverBasedHelper implements IYandexRuHelper{

	public YandexRuHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
	}
	
	public void searchText(String text){
		pages.yandexRuPage.arrow
			.inputText(text)
			.clickSearchButton();
	}
}
