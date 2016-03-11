package ru.greg3d.applogic.interfaces;

public interface IYandexRuCalcHelper {
	String getCalcResultByInputStringArg(String inputArg);
	void setTumblerToGrad();
	void clearResult();
	boolean isYandexRuCalcPageLoaded();
	String getMultiplyOf(String arg1, String arg2);
	String getCosOf(String arg);
	String getSqrtOf(String arg);
}
