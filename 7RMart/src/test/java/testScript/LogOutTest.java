package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.AdminUserPage;
import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base{
	@Test(description="Verifying the user is able to logout")
	
	public void verifyTheUserIsAbleTologOut() throws IOException{
	
	String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
	String password=ExcelUtility.getStringData(1,1, "loginpage");
	LoginPage login_page=new LoginPage(driver);
	login_page.enterUserName(user_name);
	login_page.enterPassword(password);
	login_page.clickTheSignInButton();	
	LogOutPage logout_page=new LogOutPage(driver);
	logout_page.clickAdminDropDwon();
	logout_page.clickLogOutButton();
	Boolean isUserNameFieldDisplayed=logout_page.isUserNameFieldDisplayed();
	Assert.assertTrue(isUserNameFieldDisplayed,Constants.LOGOUT);
	
	
	}

}
