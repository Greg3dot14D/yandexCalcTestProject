package ru.greg3d.calc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import ru.greg3d.applogic.implementations.*;
import ru.greg3d.applogic.interfaces.*;

@Listeners({TestBase.LogListener.class})
public class TestBase {
	
	protected IApplicationManager app;

	protected static Logger LOG = LoggerFactory.getLogger(TestBase.class);

	//@BeforeSuite
	//@BeforeTest
	@Parameters({"capabilities"})
	public void SuiteSetup(String capabilities) {
		app = new ApplicationManager(capabilities);
	}
	
	@BeforeTest
	public void SuiteSetup() {
		//app = new ApplicationManager("android_chrome");
		app = new ApplicationManager("firefox");
		//app = new ApplicationManager("chrome");
		//app = new ApplicationManager("fake");
	}	
	
	//@AfterSuite(alwaysRun = true)
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		app.stop();
	}
	
	public static class LogListener implements IInvokedMethodListener{

		@Override
		public void afterInvocation(IInvokedMethod m, ITestResult res) {
//			LOG.info("<<< @Test " + m.getTestMethod().getMethodName());
			
			String logResult = String.format("<<< @Test [%2s] delay: %2d ms",m.getTestMethod().getMethodName(),(m.getTestResult().getEndMillis() - m.getTestResult().getStartMillis()));
			
			switch(m.getTestResult().getStatus()){
			case 2:
				LOG.error(logResult + " <<< failed");
				break;
			case 3:
				LOG.warn(logResult + " <<< skipped");
				break;
			default:
				LOG.info(logResult + " <<< passed");
				break;
			}
		}

		@Override
		public void beforeInvocation(IInvokedMethod m, ITestResult res) {
			LOG.info(">>> @Test " + m.getTestMethod().getMethodName());
		}
	}
}
