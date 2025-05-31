package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class ManageCategoryTest extends Base{
	
	@Test
	
	public void verifyTheUserIsAbleToAddNewCategory() throws IOException {
		
		String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1,1, "loginpage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name);
		login_page.enterPassword(password);
		login_page.clickTheSignInButton();
		
		ManageCategoryPage manage_category_page=new ManageCategoryPage(driver);
		manage_category_page.clickManageCategory();
		manage_category_page.clickNewButton();
		String category_name=ExcelUtility.getStringData(1, 0, "managecategory");
		manage_category_page.enterCategory(category_name);
		manage_category_page.selectGroup();
		manage_category_page.uploadImage();
		String top_menu=ExcelUtility.getStringData(1, 1, "managecategory");
		manage_category_page.selectTopMenuRadioButton(top_menu);
		String left_menu=ExcelUtility.getStringData(1, 2, "managecategory");
		manage_category_page.selectLeftMenuRadioButton(left_menu);
		manage_category_page.clickSaveButton();
		Boolean isAlertDisplayed=manage_category_page.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed);
		
	}
	
	@Test
	
	public void verifyTheUserIsAbleToDeleteCategory() throws IOException{
		
		String user_name=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1,1, "loginpage");
		LoginPage login_page=new LoginPage(driver);
		login_page.enterUserName(user_name);
		login_page.enterPassword(password);
		login_page.clickTheSignInButton();
		
		ManageCategoryPage manage_category_page=new ManageCategoryPage(driver);
		manage_category_page.clickManageCategory();
		try {
		manage_category_page.clickDelete(ExcelUtility.getStringData(1, 0, "managecategory"));
		Boolean isDeleteAlertDisplayed=manage_category_page.isDeleteAlertIsDisplayed();
		Assert.assertTrue(isDeleteAlertDisplayed);
		}
		catch (Exception e) {
			
			System.out.println("The Category is not exist");
		}
		
		
		
	}

}
