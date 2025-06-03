package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class ManageCategoryTest extends Base{
	ManageCategoryPage manage_category_page;
	HomePage home_page;
	
	@Test(description = "Verifying the user is able to add new category")
	
	public void verifyTheUserIsAbleToAddNewCategory() throws IOException {
		
		String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1,1, "loginpage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name).enterPassword(password);
		home_page=login_page.clickTheSignInButton();
		
	    manage_category_page=home_page.clickManageCategoryMoreInfo();
		manage_category_page.clickNewButton();
		String category_name=ExcelUtility.getStringData(1, 0, "managecategory");
		String top_menu=ExcelUtility.getStringData(1, 1, "managecategory");
		String left_menu=ExcelUtility.getStringData(1, 2, "managecategory");
		manage_category_page.enterCategory(category_name).selectGroup()
		.uploadImage().selectTopMenuRadioButton(top_menu).selectLeftMenuRadioButton(left_menu).clickSaveButton();
		Boolean isAlertDisplayed=manage_category_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Constants.MANAGE_CAT_ADD_NEW_CAT);
		
	}
	
	@Test(description = "Verifying the user is able to delete category")
	
	public void verifyTheUserIsAbleToDeleteCategory() throws IOException{
		
		String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1,1, "loginpage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name).enterPassword(password);
		home_page=login_page.clickTheSignInButton();
		
		manage_category_page=home_page.clickManageCategoryMoreInfo();
		try {
		manage_category_page.clickDelete(ExcelUtility.getStringData(1, 0, "managecategory"));
		Boolean isDeleteAlertDisplayed=manage_category_page.isDeleteAlertIsDisplayed();
		Assert.assertTrue(isDeleteAlertDisplayed,Constants.MANAGE_CAT_DELETE__CAT);
		}
		catch (Exception e) {
			
			System.out.println("The Category is not exist");
		}
		
		
		
	}

}
