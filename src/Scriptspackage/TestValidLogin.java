package Scriptspackage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompage.LoginPage;

public class TestValidLogin extends BaseTest{

	@Test
	public void testvalidLogin() throws Exception
	{
		LoginPage login=new LoginPage(driver);
		String username = Lib.getCellData("LoginData", "validLogin", 1, 0);
		String password = Lib.getCellData("LoginData", "validLogin", 1, 1);
				
		login.setUsername(username);
		login.setPassword(password);
		
		login.clickBtn();
//		Thread.sleep(2000);//we can throw this beacause it is not a generic function
		
//		Assert.fail("focebilly failing");//we will not do it in the real time
		
		//validate the home page is displayed
//		String actualTitle=driver.getTitle();
//		if(actualTitle.equalsIgnoreCase("i dont know"))
//		{
//			System.out.println("login successfull");
//		}
//		else
//		{
//			System.out.println("login failed");
//		}
//		we will never use in real time
		
//		String actualTitle=driver.getTitle();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains("actiTI"));
		
		String actualTitle=driver.getTitle();
		
		String expectedTitle="actiTIME - Login";//actiTIME -  Login
		//we have to use SoftAssert for this
		Assert.assertEquals(actualTitle,expectedTitle);//expectedTitle from pagesource or requirement
		//this is Hard Assert
		//try this with the String expectedTitle="something not title";
		
		
		
		
	}


}
