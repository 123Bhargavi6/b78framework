package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import pages.EnterTimeTrackPage;
import pages.LoginPage;

public class ValidLogin extends BaseTest
{
	@Test(priority = 1)
	public void testValidLogin()
	{
		String un=Excel.getCellData(XL_PATH, "ValidLogin",1,0);
		String pw=Excel.getCellData(XL_PATH, "ValidLogin",1,1);
//		1. enter valid un
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
		
//		2. enter valid pw
		loginPage.setPassword(pw);
		
//		3. click login button
		loginPage.clickLoginButton();
		
//		4. home page should be displayed
		EnterTimeTrackPage ETTPage=new EnterTimeTrackPage(driver);
		boolean result = ETTPage.verifyHomePageIsDisplayed(wait);
		Assert.assertEquals(result, true);
		
	}
}
