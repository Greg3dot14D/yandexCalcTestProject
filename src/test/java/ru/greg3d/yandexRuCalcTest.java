package ru.greg3d;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class yandexRuCalcTest extends TestBase{

	@BeforeMethod
	public void presets(){
		app.getYandexRuCalcHelpe().setTumblerToGrad();
		app.getYandexRuCalcHelpe().clearResult();
	} 
	
	@BeforeClass
	public void openCalcPageTest(){
		app.getYandexRuHelper().searchText("«калькулятор»");
		Assert.assertTrue(app.getYandexRuCalcHelpe().isYandexRuCalcPageLoaded());
	}
	
	@Test(dataProvider="inputValueOfStringToCalcDataProvider")
	public void inputStringArgsTestCalc(String inputArg, String expectedResult){
		Assert.assertEquals(app.getYandexRuCalcHelpe().getCalcResultByInputStringArg(inputArg), expectedResult);
	}
	
	@DataProvider
	private Object[][] inputValueOfStringToCalcDataProvider() {
		return new Object[][] {
				{ "sqrt(144)","12" },
				{ "cos(Pi/2)","0" },
				{ "1,5 * 100","150" }
			};
	};	
	
	@Test(dataProvider="multiplyTestDataProvider")
	public void testMultiply(String arg1, String arg2, String result){
		Assert.assertEquals(app.getYandexRuCalcHelpe().getMultiplyOf(arg1, arg2), result);
	}
	
	@DataProvider
	private Object[][] multiplyTestDataProvider() {
		return new Object[][] {
				{ "1,5","100", "150" }
			};
	};
	
	@Test(dataProvider="cosTestDataProvider")
	public void testCos(String arg, String result){
		Assert.assertEquals(app.getYandexRuCalcHelpe().getCosOf(arg), result);
	}
	
	@DataProvider
	private Object[][] cosTestDataProvider() {
		return new Object[][] {
				{ "Pi/2", "0" }
			};
	};
	
	
	@Test(dataProvider="sqrtTestDataProvider")
	public void testSqrt(String arg, String result){
		Assert.assertEquals(app.getYandexRuCalcHelpe().getSqrtOf(arg), result);
	}
	
	@DataProvider
	private Object[][] sqrtTestDataProvider() {
		return new Object[][] {
				{ "144", "12" }
			};
	};
	
	

	
}
