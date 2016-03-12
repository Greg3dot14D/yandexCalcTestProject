package ru.greg3d;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

	// проверка при вводе данных путем копипаста
	@Test(dataProvider = "inputArgsByCopyPastDataProvider")
	public void testCalc_inputArgsByCopyPast(String args,
			String expectedResult) {
		// Проверяем ввод невалидной последовательности символов
		if (expectedResult.equals(errorMessage)) {
			Assert.assertEquals(app.getYandexRuCalcHelpe()
					.getResultByCopyPastArgs(args), args);
			Assert.assertTrue(app.getYandexRuCalcHelpe()
					.errorMessageIsDisplayed());
		}
		// Проверяем ввод валидной последовательности символов
		else
			Assert.assertEquals(app.getYandexRuCalcHelpe()
					.getResultByCopyPastArgs(args), expectedResult);
	}

	@DataProvider
	private Object[][] inputArgsByCopyPastDataProvider() {
		return new Object[][] {
				{ "sqrt(144)", errorMessage },
				{ "cos(Pi/2)", errorMessage },
				{ "1,5 * 100", "150" }
			};
	};

	// проверка при вводе данных путем набора текста с клавиатуры
	@Test(dataProvider = "typingTextSequenceTestDataProvider")
	public void testCalc_inputArgsByTypingText(String args, String result) {
		Assert.assertEquals(app.getYandexRuCalcHelpe().getResultByTypingText(args), result);
	}

	@DataProvider
	private Object[][] typingTextSequenceTestDataProvider() {
		return new Object[][] {
					{ "cp/2", "0" },
					{ "1,5*100", "150" },
				};
	};

	// проверка при вводе данных путем нажатия кнопок калькулятора
	@Test(dataProvider = "buttonsClicksSequenceTestDataProvider")
	public void testCalc_inputArgsByClickButtons(CalcModel clicksSequence,
			String result) {
		Assert.assertEquals(
				app.getYandexRuCalcHelpe().getResultByClickButtons(
						clicksSequence), result,
				clicksSequence.getClicksSequence());
	}

	@DataProvider
	private Object[][] buttonsClicksSequenceTestDataProvider() {
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
