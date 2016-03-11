package ru.greg3d.applogic.implementations;

import ru.greg3d.applogic.interfaces.IYandexRuCalcHelper;


public class YandexRuCalcHelper extends DriverBasedHelper implements IYandexRuCalcHelper{

	public YandexRuCalcHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
	}
	
	public void setTumblerToRad(){
		pages.yandexRuCalcPage.switchTumblerToRad();
	}
	
	public void setTumblerToGrad(){
		pages.yandexRuCalcPage.switchTumblerToGrad();
	}
	
	public String getCalcResultByInputStringArg(String inputArg) {
		//return pages.yandexRuCalcPage.setTextInput(inputArg).clickResult().getResultText();
		return pages.yandexRuCalcPage.setTextInputByCtrlV(inputArg).clickResult().getResultText();
	}

	public void clearResult() {
		pages.yandexRuCalcPage.clickCE();
	}

	public boolean isYandexRuCalcPageLoaded() {
		// TODO Auto-generated method stub
		pages.yandexRuCalcPage.ensurePageLoaded();
		return true;
	}

	public String getMultiplyOf(String arg1, String arg2) {
		return pages.yandexRuCalcPage.setTextInput(arg1)
			.clickMultiply()
			.setTextInput(arg2)
			.clickResult()
			.getResultText();
	}

	public String getCosOf(String arg) {
		return pages.yandexRuCalcPage.clickCos()
			.setTextInput(arg)
			.clickResult()
			.getResultText();
	}

	public String getSqrtOf(String arg) {
		return pages.yandexRuCalcPage
				.setTextInput(arg)
				.clickSqrt()
				.clickResult()
				.getResultText();
	}
}
