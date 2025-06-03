package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@class,'small-box-footer') and contains(@href,'admin/list-admin')]") WebElement more_info_btn;
	@FindBy(xpath="//a[contains(@href,'list-news' )and contains(@class,'nav-link')]") WebElement manageNewsOPtion;
	@FindBy(xpath="//a[contains(@class,'small-box-footer') and contains(@href,'admin/list-contact')]") WebElement mange_contact_btn;
	@FindBy(xpath = "//a[contains(@class,'small-box-footer') and contains(@href,'admin/list-category')]")
	WebElement manage_category_btn;
	@FindBy(xpath="//a[contains(@class,'small-box-footer') and contains(@href,'admin/list-footertext')]") WebElement manage_footer_btn;
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin_dd;
	@FindBy(xpath="//a[contains(@href,'admin/logout') and contains(@class,'dropdown-item')]") WebElement logout_btn;
	@FindBy(xpath="//input[@name='username']") WebElement usernameField;

    public AdminUserPage clickAdminUserMoreInfo() {
		
		more_info_btn.click();
		return new AdminUserPage(driver);
	}
    
    public ManageNewsPage clickManageNewsOption() {
    	
    	manageNewsOPtion.click();
    	return new ManageNewsPage(driver);
    	
    	}
    
    public ManageContactPage clcickManageContactMoreInfo() {
		
		mange_contact_btn.click();
		return new ManageContactPage(driver);
	}
    
    public ManageCategoryPage clickManageCategoryMoreInfo() {

		manage_category_btn.click();
		return new ManageCategoryPage(driver);
	}
    
    public ManageFooterPage clickManageFooterMoreInfo() {
		
		manage_footer_btn.click();
		return new ManageFooterPage(driver);
	}
	
	
	public void clickAdminDropDwon() {
		
		admin_dd.click();
		
	}
	
	public void clickLogOutButton() {
		
		logout_btn.click();
	}
	
   public boolean isUserNameFieldDisplayed() {
		
		return usernameField.isDisplayed();
		
		
	}
	

}
