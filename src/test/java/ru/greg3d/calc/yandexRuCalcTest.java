package ru.greg3d.calc;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.greg3d.model.calc.CalcModel;

public class yandexRuCalcTest extends TestBase {

	private final String errorMessage = "Ошибка";

	@BeforeMethod
	public void presets() {
		app.getYandexRuCalcHelpe().setTumblerToGrad();
		app.getYandexRuCalcHelpe().clearResult();
	}

	@BeforeClass
	public void openCalcPageTest() {
		app.getYandexRuHelper().searchText("«калькулятор»");
		Assert.assertTrue(app.getYandexRuCalcHelpe().isYandexRuCalcPageLoaded());
	}

	// проверка при вводе невалидных данных путем копипаста
	@Test(dataProvider = "inputArgsByCopyPastInValidDataProvider")
	public void testCalc_inputArgsByCopyPast_testInValidData(String args,
			String expectedResult) {
		app.getYandexRuCalcHelpe().getResultByCopyPastArgs(args);	
		Assert.assertTrue(app.getYandexRuCalcHelpe()
					.errorMessageIsDisplayed());
	}

	@DataProvider
	private Object[][] inputArgsByCopyPastInValidDataProvider() {
		return new Object[][] {
				{ "sqrt(144)", errorMessage },
				{ "cos(Pi/2)", errorMessage }
			};
	};
	
	// проверка при вводе валидных данных путем копипаста
	@Test(dataProvider = "inputArgsByCopyPastValidDataProvider")
	public void testCalc_inputArgsByCopyPast_testValidData(String args,
			String expectedResult) {
			Assert.assertEquals(app.getYandexRuCalcHelpe()
					.getResultByCopyPastArgs(args), expectedResult);
	}
	
	@DataProvider
	private Object[][] inputArgsByCopyPastValidDataProvider() {
		return new Object[][] {
				{ "1,5 * 100", "150" }
			};
	};

	// проверка при вводе данных путем набора текста с клавиатуры
	@Test(dataProvider = "inputArgsByTypingTextDataProvider")
	public void testCalc_inputArgsByTypingText_testValidData(String args, String result) {
		Assert.assertEquals(app.getYandexRuCalcHelpe().getResultByTypingText(args), result);
	}

	@DataProvider
	private Object[][] inputArgsByTypingTextDataProvider() {
		return new Object[][] {
					{ "cp/2", "0" },
					{ "1,5*100", "150" },
				};
	};

	// проверка при вводе данных путем нажатия кнопок калькулятора
	@Test(dataProvider = "inputArgsByClickButtonsDataProvider")
	public void testCalc_inputArgsByClickButtons_testValidData(CalcModel clicksSequence,
			String result) {
		Assert.assertEquals(
				app.getYandexRuCalcHelpe().getResultByClickButtons(
						clicksSequence), result,
				"Sequence of clicks :" + clicksSequence.getClicksSequenceText());
	}

	@DataProvider
	private Object[][] inputArgsByClickButtonsDataProvider() {
		return new Object[][] {
				{
					CalcModel.newSequence()
						.clickOne()
						.clickFore()
						.clickFore()
						.clickSqrt()
						, "12" },
				{
					CalcModel.newSequence()
						.clickCos()
						.clickPi()
						.clickDiv()
						.clickTwo()
						, "0" },
				{
					CalcModel.newSequence()
						.clickOne()
						.clickDot()
						.clickFive()
						.clickMul()
						.clickOne()
						.clickZero()
						.clickZero()
						, "150" }
			};
	};

}
