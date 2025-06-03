package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base{
	
	@Test(description = "Verifying the update button is displayed")
	
	public void verifyTheUpdateButtonIsDisplayed() throws IOException{
		
		String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1,1, "loginpage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name);
		login_page.enterPassword(password);
		login_page.clickTheSignInButton();	
		
		ManageContactPage manage_contact_page=new ManageContactPage(driver);
		manage_contact_page.clcickManageContact();
		manage_contact_page.clickActionButton();
		Boolean isUpdateButtonDisplayed=manage_contact_page.isUpdateButtonDisplayed();
		Assert.assertTrue(isUpdateButtonDisplayed,Constants.MANAGE_CONTACT_UPDATEBUTTON__DISPLAY);
		
	}
	
	@Test(description="Verifying the user is able to edit contact")
	
	public void verifyUserIsAbleToEditContact() throws IOException{
		
		String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1,1, "loginpage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name);
		login_page.enterPassword(password);
		login_page.clickTheSignInButton();	
		
		ManageContactPage manage_contact_page=new ManageContactPage(driver);
		manage_contact_page.clcickManageContact();
		manage_contact_page.clickActionButton();
		manage_contact_page.clearAll();
		manage_contact_page.enterPhoneNumber(ExcelUtility.getLongData(1, 0, "managecontact"));
		manage_contact_page.enterEmai(ExcelUtility.getStringData(1, 1, "managecontact"));
		manage_contact_page.enterAddress(ExcelUtility.getStringData(1, 2, "managecontact"));
		manage_contact_page.enterDeliveryTime(ExcelUtility.getIntegerData(1, 3, "managecontact"));
		manage_contact_page.enterDeliveryCharge(ExcelUtility.getIntegerData(1, 4, "managecontact"));
		manage_contact_page.clickUpdateButton();
		Boolean isAlertDisplayed=manage_contact_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Constants.MANAGE_CONTACT_EDIT__CONTACT);
	}

}
