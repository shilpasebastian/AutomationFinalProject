package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	public HomePage home_page;
	
	@Test(groups= {"regression"},description = "Verifying the user is able to login using valid credentials")
	
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
	
		String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1,1, "loginpage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name).enterPassword(password);
		home_page=login_page.clickTheSignInButton();
		Boolean isHomePageAvailable=login_page.isDashBoardDisplayed();
		Assert.assertTrue(isHomePageAvailable,Constants.LOGIN_VALID_CREDENTIALS);
		
	}
	
	@Test(description = "Verifying the user is unable to login using a invalid username and an valid password")
	
	public void verifyTheUserIsUnableToLoginUsingInvalidUserNameAndValidPassword() throws IOException {
		
		String user_name=ExcelUtility.getStringData(3, 0, "loginpage");
		String password=ExcelUtility.getStringData(3,1, "loginpage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name).enterPassword(password);
		home_page=login_page.clickTheSignInButton();
		Boolean isAlertDisplayed=login_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Constants.LOGIN_INCORRECT_USERNAME);
		
	}
	
	@Test(description = "Verifying the user is unable to login using a valid username and an invalid password")
	
	public void verifyTheUserIsUnableToLoginUsingValidUserNameAndInvalidPassword() throws IOException {
		
		String user_name=ExcelUtility.getStringData(2, 0, "loginpage");
		String password=ExcelUtility.getStringData(2, 1, "loginpage");
	    LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name).enterPassword(password);
		home_page=login_page.clickTheSignInButton();
		Boolean isAlertDisplayed=login_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Constants.LOGIN_INCORRECT_PASSWORD);
	}
	
	@Test(dataProvider ="LoginProvider",description = "Verifying the user is unable to login using invalid credentials")

	public void verifyTheUserIsAbleToLoginUsingInvalidCredentials(String user_name,String password) throws IOException {
	
	//String user_name=ExcelUtility.getStringData(4, 0, "loginpage");
	//String password=ExcelUtility.getStringData(4, 1, "loginpage");
	LoginPage login_page=new LoginPage(driver);
	login_page.enterUserName(user_name).enterPassword(password);
	home_page=login_page.clickTheSignInButton();
	Boolean isAlertDisplayed=login_page.isAlertDisplayed();
	Assert.assertTrue(isAlertDisplayed,Constants.LOGIN_INVALID_CREDENTIALS);
}

	@DataProvider(name="LoginProvider")
	public Object[][] getDataFromTestData() throws IOException{
		return new Object[][] {{ExcelUtility.getStringData(4, 0,"loginpage"),ExcelUtility.getStringData(4, 1, "loginpage")}};
		
	
	
	}
		
	
	
	}


