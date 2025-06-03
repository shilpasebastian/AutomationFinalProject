package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base{
	
	public AdminUserPage admin_user_page;
	public HomePage home_page;
	
	@Test(retryAnalyzer = reTry.ReTry.class,description = "Verifying the user is able to add adminuser")
	
	public void verifyTheUserIsAbleToAddAdminUser() throws IOException {
			
		String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1,1, "loginpage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name).enterPassword(password);
		home_page=login_page.clickTheSignInButton();	
		FakerUtility faker_utility=new FakerUtility();
		String username_AdminUserTest=faker_utility.creatARandomFirstName();
		String password_AdminUserTest=faker_utility.creatARandomLastName();
//		String username_AdminUserTest=ExcelUtility.getStringData(0, 1, "adminuser");
//		String password_AdminUserTest=ExcelUtility.getIntegerData(1, 1, "adminuser");	
		String userType=ExcelUtility.getStringData(2, 1, "adminuser");
		admin_user_page=home_page.clickAdminUserMoreInfo();
		admin_user_page.clickNewButton();
		admin_user_page.enterUserName(username_AdminUserTest).enterPassword(password_AdminUserTest).selectUserTypeDropDwon(userType).clickSaveButton();
		Boolean isAlertDisplayed=admin_user_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Constants.ADMIN_USER_ADD_ADMIN);
		
	}


}
