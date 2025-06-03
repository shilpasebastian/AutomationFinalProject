package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	ManageNewsPage mange_news_page;
	HomePage home_page;
	
	@Test(description="Verifying the user is able to add manage news")
	
	public void verifyTheUserIsAbleToAddMangeNews() throws IOException {
		
		String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		String news=ExcelUtility.getStringData(0, 1, "managenewspage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name).enterPassword(password);
		home_page=login_page.clickTheSignInButton();
	    mange_news_page=home_page.clickManageNewsOption();
		mange_news_page.clickNewButton().enterNews(news).clickSaveButton();
		Boolean isAlertDisplayed=mange_news_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Constants.MANAGE_NEWS);
		
	}

}
