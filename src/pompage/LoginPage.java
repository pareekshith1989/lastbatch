package pompage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	

	//declare the elements
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="pwd")
	private WebElement pwd;
	
	@FindBy(xpath="//a[@id='loginButton']") //    customize xpath====>  //div[contains(text(),'Login')]
	private WebElement loginBtn;
	//initialize elements
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		/**we can define this***> keyword with  (LoginPage.class)  it represents current class objects**/
		/** 	we write this statement inside the constructor, so that when the object of this pom class
		  	is created from another class, it will invoke the constructor and initialize all the 
		  	elements which are declared in the pom class.
		 **/
	}
	
	//utilize the elements
	
	public void setUsername(String un)
	{
		username.sendKeys(un);
	}

	public void setPassword(String pswd)
	{
		pwd.sendKeys(pswd);
	}
	public void clickBtn()
	{
		loginBtn.click();
}}
