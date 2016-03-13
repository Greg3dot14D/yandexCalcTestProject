package ru.greg3d.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	private static long WAIT_START_AJAX_IN_MILLISECONDS = 100;
	private static long WAIT_FINISH_AJAX_IN_SECONDS = 5;
	
	public static void setWaitStartAjaxInMilliseconds(long delay){
		WAIT_START_AJAX_IN_MILLISECONDS = delay;
	}
	
	public static void setWaitFinishAjaxInSeconds(long delay){
		WAIT_FINISH_AJAX_IN_SECONDS = delay;
	}
	
	public static WebElement waitElementIsClickable(WebDriver driver, WebElement element, Integer waitTimeInSeconds) {
	    if (waitTimeInSeconds == null) {
	    	waitTimeInSeconds = 10;
	    }
	    WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
	    return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
		//
		// Дожидаемся состояния страницы $.active = 0
		//
	public static boolean WaitPageIsActive(WebDriver driver){
    	WebDriverWait wait = new WebDriverWait(driver, WAIT_FINISH_AJAX_IN_SECONDS * 1000);
    	try{
    	wait.until(new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver d) {
        		if(((JavascriptExecutor)d).executeScript("return $.active").toString().equals("0"))
        			return true;
        		return false;
            }
         });
    	}catch(Exception e){
    		return false;
    	}
    	return true;
    }
	
		//
		// Дожидаемся состояния страницы $.active = 1
		//
	public static boolean WaitPageIsNotActive(WebDriver driver){
    	WebDriverWait wait = new WebDriverWait(driver, 5/100, WAIT_START_AJAX_IN_MILLISECONDS);

    	try{
    	wait.until(new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver d) {
        		if(((JavascriptExecutor)d).executeScript("return $.active").toString().equals("1"))
        			return true;
        		return false;
            }
         });
    	}catch(Exception e){
    		return false;
    	}
    	return true;
    }
	
	public static void delay(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
