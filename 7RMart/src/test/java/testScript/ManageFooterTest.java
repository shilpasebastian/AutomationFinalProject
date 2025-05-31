package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageFooterTest extends Base {
	
	@Test
	
	public void verifyTheUpdateButtonIsDisplayed() throws IOException{
		
		String user_name = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage login_page = new LoginPage(driver);
		login_page.enterUserName(user_name);
		login_page.enterPassword(password);
		login_page.clickTheSignInButton();
		
		ManageFooterPage manage_footer_page=new ManageFooterPage(driver);
		manage_footer_page.clickManageFooter();	
		manage_footer_page.clickActionButton();
		Boolean isUpdateButtonDisplayed=manage_footer_page.isUpdateButtonDisplayed();
		Assert.assertTrue(isUpdateButtonDisplayed);
		
	}
	
	@Test

	public void verifyTheUserIsAbleToManageFooterText() throws IOException {

		String user_name = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage login_page = new LoginPage(driver);
		login_page.enterUserName(user_name);
		login_page.enterPassword(password);
		login_page.clickTheSignInButton();
		
		ManageFooterPage manage_footer_page=new ManageFooterPage(driver);
		manage_footer_page.clickManageFooter();
		manage_footer_page.clickActionButton();
		manage_footer_page.clearAll();	
		
		String address=ExcelUtility.getStringData(1, 0, "managefooter");
		String email=ExcelUtility.getStringData(1, 1, "managefooter");
		String phone_number=ExcelUtility.getLongData(1, 2, "managefooter");
		manage_footer_page.enterAddress(address);
		manage_footer_page.enterEmail(email);
		manage_footer_page.enterPhoneNumber(phone_number);
		manage_footer_page.clickUpdateButton();
		Boolean isAlertDisplayed=manage_footer_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed);
		
	}

}
