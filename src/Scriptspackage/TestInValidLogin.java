package Scriptspackage;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompage.LoginPage;

//@Listeners(fully qualified name of listeners class)
//this will be particular to this only class
public class TestInValidLogin extends BaseTest {
	@Test
	public void testInValidLogin() throws Exception
	{
		LoginPage login=new LoginPage(driver);
		int rowCount = Lib.getRowCount("LoginData", "inValidLogin");
		for (int row = 1; row <=rowCount; row++) {
			String username = Lib.getCellData("LoginData", "inValidLogin", row, 0);
			String password = Lib.getCellData("LoginData", "inValidLogin", row, 1);
			
			login.setUsername(username);
			login.setPassword(password);
			login.clickBtn();
			Thread.sleep(2000);
			
			
		}
	}
}
