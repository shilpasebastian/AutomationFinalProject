package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	
	HomePage home_page;
	LoginPage login_page;

	@Test(description="Verifying the user is able to logout")
		
	public void verifyTheUserIsAbleTologOut() throws IOException{
	
	String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
	String password=ExcelUtility.getStringData(1,1, "loginpage");
	login_page=new LoginPage(driver);
	login_page.enterUserName(user_name).enterPassword(password);
	home_page=login_page.clickTheSignInButton();	
	home_page.clickAdminDropDwon();
	login_page=home_page.clickLogOutButton();
	Boolean isUserNameFieldDisplayed=home_page.isUserNameFieldDisplayed();
	Assert.assertTrue(isUserNameFieldDisplayed,Constants.LOGOUT);
	
	
	}

}
