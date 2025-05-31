package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	
WebDriver driver;
	
	public LogOutPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin_dd;
	@FindBy(xpath="//a[contains(@href,'admin/logout') and contains(@class,'dropdown-item')]") WebElement logout_btn;
	@FindBy(xpath="//input[@name='username']") WebElement usernameField;

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
