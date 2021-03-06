package ru.greg3d.applogic.implementations;

import ru.greg3d.applogic.interfaces.INavigationHelper;

public class NavigationHelper extends DriverBasedHelper implements INavigationHelper {

	private String baseUrl;

	public NavigationHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
		this.baseUrl = manager.getBaseUrl();
	}

	public void openMainPage() {
		driver.get(baseUrl);
	}

	public void openUrl(String url){
		driver.get(url);
	}
	
	public void openRelativeUrl(String url) {
		driver.get(baseUrl + url);
	}

}
