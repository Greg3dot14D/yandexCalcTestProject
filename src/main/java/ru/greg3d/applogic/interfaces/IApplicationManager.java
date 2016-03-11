package ru.greg3d.applogic.interfaces;

public interface IApplicationManager {

	INavigationHelper getNavigationHelper();
	void stop();
	IYandexRuCalcHelper getYandexRuCalcHelpe();
	IYandexRuHelper getYandexRuHelper();
}
