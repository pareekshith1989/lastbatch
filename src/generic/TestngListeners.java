package generic;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestngListeners implements ISuiteListener,ITestListener{

	//connect it with the suite file with the help of 
//	<listeners>
//	<listener class-name="generic.TestngListeners"></listener>
//	</listeners>
//	
	
	
	@Override
	public void onStart(ISuite suite) {
		Reporter.log(suite.getName()+"---->suite started",true);//
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log(suite.getName()+"---->suite is finished",true);
	}

	@Override
	public void onTestStart(ITestResult testmethod) {
		Reporter.log(testmethod.getName()+"---->test method is started",true);		
	}

	@Override
	public void onTestSuccess(ITestResult testmethod ) {
		Reporter.log(testmethod.getName()+"---->test method is passed",true);
	}

	@Override
	public void onTestFailure(ITestResult testmethod) {
		Reporter.log(testmethod.getName()+"---->test method is failed",true);	
		
		//lib.captureScreenshot()
		//we can implement the screenshot in this method
	}

	@Override
	public void onTestSkipped(ITestResult testmethod) {
		Reporter.log(testmethod.getName()+"---->test method is skipped",true);		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		//we never implement this if test is fail then it is fail only
	}

	@Override
	public void onStart(ITestContext testblock) {
		Reporter.log(testblock.getName()+"---->Smoketest block started",true);//		
	}

	@Override
	public void onFinish(ITestContext testblock) {
		Reporter.log(testblock.getName()+"---->Smoketest block finished",true);//		
	}

	
}
