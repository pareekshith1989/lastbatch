package Scriptspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.BaseTest;

public class JavaScriptDemo extends BaseTest{
	
	//enter sendkeys using Javascriptexcecutor
	
	
		
//problem only with performing action and not in fetching the adress 
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Selenium\\BrowserDrivers\\chromedriver (2).exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		WebElement loginbtn=driver.findElement(By.xpath(""));
		jse.executeScript("arguments[0].click()", loginbtn);
	}
	
	
}
