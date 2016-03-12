package ru.greg3d.applogic.implementations;

import ru.greg3d.CalcModel;
import ru.greg3d.applogic.interfaces.IYandexRuCalcHelper;
import ru.greg3d.util.Fields;
import ru.yandex.qatools.htmlelements.element.Button;

public class YandexRuCalcHelper extends DriverBasedHelper implements
		IYandexRuCalcHelper {

	public YandexRuCalcHelper(ApplicationManager manager) {
		super(manager.getWebDriver());
	}

	public void setTumblerToRad() {
		pages.yandexRuCalcPage.calc.switchTumblerToRad();
	}

	public void setTumblerToGrad() {
		pages.yandexRuCalcPage.calc.switchTumblerToGrad();
	}

	public void clearResult() {
		pages.yandexRuCalcPage.calc.clickCE();
	}

	public boolean isYandexRuCalcPageLoaded() {
		pages.yandexRuCalcPage.ensurePageLoaded();
		return true;
	}

	public boolean errorMessageIsDisplayed() {
		return pages.yandexRuCalcPage.calc.errorMessage.isDisplayed();
	}

	public String getResultByCopyPastArgs(String args) {
		return pages.yandexRuCalcPage.setTextInputByCopyPast(args).calc
				.clickResult().getResultText();
	}

	public String getResultByClickButtons(CalcModel model) {
		for (String buttonName : model.getClicksSequenceList()) {
			((Button) Fields.getFieldByAnnotationName(
					pages.yandexRuCalcPage.calc, buttonName)).click();
		}
		return pages.yandexRuCalcPage.calc.clickResult().getResultText();
	}

	public String getResultByTypingText(String args) {
		return pages.yandexRuCalcPage.calc.setTextInput(args).clickResult()
				.getResultText();
	}

}
