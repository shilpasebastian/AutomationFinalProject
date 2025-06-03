package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageFooterTest extends Base {
	ManageFooterPage manage_footer_page;
	HomePage home_page;
	
	@Test(description = "Verifying the update button is displayed")
	
	public void verifyTheUpdateButtonIsDisplayed() throws IOException{
		
		String user_name = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage login_page = new LoginPage(driver);
		login_page.enterUserName(user_name).enterPassword(password);
		home_page=login_page.clickTheSignInButton();
		
		manage_footer_page=home_page.clickManageFooterMoreInfo();
		manage_footer_page.clickActionButton();
		Boolean isUpdateButtonDisplayed=manage_footer_page.isUpdateButtonDisplayed();
		Assert.assertTrue(isUpdateButtonDisplayed,Constants.MANAGE_FOOTER_UPDATEBUTTON__DISPLAY);
		
	}
	
	@Test(description="Verifying the user is able to manage footer text")

	public void verifyTheUserIsAbleToManageFooterText() throws IOException {

		String user_name = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage login_page = new LoginPage(driver);
		login_page.enterUserName(user_name).enterPassword(password);
		home_page=login_page.clickTheSignInButton();
		
		manage_footer_page=home_page.clickManageFooterMoreInfo();
		manage_footer_page.clickActionButton();		
		String address=ExcelUtility.getStringData(1, 0, "managefooter");
		String email=ExcelUtility.getStringData(1, 1, "managefooter");
		String phone_number=ExcelUtility.getLongData(1, 2, "managefooter");
		manage_footer_page.clearAll().enterAddress(address).enterEmail(email)
		.enterPhoneNumber(phone_number).clickUpdateButton();

//		manage_footer_page.enterAddress(address);
//		manage_footer_page.enterEmail(email);
//		manage_footer_page.enterPhoneNumber(phone_number);
//		manage_footer_page.clickUpdateButton();
		
		Boolean isAlertDisplayed=manage_footer_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Constants.MANAGE_FOOTER_TEXT);
		
	}

}
