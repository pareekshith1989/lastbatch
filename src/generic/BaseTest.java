package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant{
	public WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		//set the path of driver
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		
		//launch the browser
		driver=new ChromeDriver();//WebDriver driver in here we get null pointer exception in the driver.close() because that will be ponting to global WebDriver driver =null
//		enter url
		driver.get(Lib.getPropertyValue("URL"));
		
		
		String ito=Lib.getPropertyValue("IMPLICIT_WAIT");//so being the 10 seconds is coming from the config properties class
		long time = Long.parseLong(ito);	//to parse string value into long type because implicitlyWait() takes only Long value
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
		
		
	}

	@AfterMethod
	public void tearDown(ITestResult res){
		//capture screen shot if test case failed
		if(ITestResult.FAILURE==res.getStatus())
		{
			Lib.captureScreenshot(driver, res.getName());
		}
		
		
		
		
		//close the browser
		driver.close();
	}

}
