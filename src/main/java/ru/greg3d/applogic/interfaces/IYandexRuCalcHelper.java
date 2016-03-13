package ru.greg3d.applogic.interfaces;

import ru.greg3d.model.calc.CalcModel;

public interface IYandexRuCalcHelper {

	void setTumblerToRad();
	void setTumblerToGrad();
	void clearResult();
	boolean isYandexRuCalcPageLoaded();

	String getResultByCopyPastArgs(String args);	
	String getResultByClickButtons(CalcModel args);
	String getResultByTypingText(String args);
	boolean errorMessageIsDisplayed();
}
