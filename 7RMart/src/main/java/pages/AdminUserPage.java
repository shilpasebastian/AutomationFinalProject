package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUserPage {
	
	WebDriver driver;
	
	public AdminUserPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}	
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement new_btn;
	@FindBy(xpath="//input[@id='username']") WebElement userName_txt;
	@FindBy(xpath="//input[@id='password']") WebElement password_txt;
	@FindBy(xpath="//select[contains(@class,'form-control') and contains(@id,'user_type')]") WebElement userType_ddl;
	@FindBy(xpath="//button[@name='Create']") WebElement save_btn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert_box;
	
	PageUtility page_utility=new PageUtility();

	public AdminUserPage clickNewButton() {
		
		new_btn.click();
		return this;
	}
	
	public AdminUserPage enterUserName(String username) {
		
		userName_txt.sendKeys(username);
		return this;
	}
	
	public AdminUserPage enterPassword(String password) {
		
		password_txt.sendKeys(password);
		return this;
	}
	
	public AdminUserPage selectUserTypeDropDwon(String value) {
		
		page_utility.selectByVisibleValue(userType_ddl, value);
		return this;
		
	}
	
	public AdminUserPage clickSaveButton() {
		
		save_btn.click();
		return this;
	}
	
	public boolean isAlertDisplayed() {
		
		return alert_box.isDisplayed();
		
	}

}
