package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	
	WebDriver driver;

	public ManageFooterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//a[contains(@class,'small-box-footer') and contains(@href,'admin/list-footertext')]") WebElement manage_footer_btn;
	@FindBy(xpath="//a[contains(@role,'button') and contains(@href,'Footertext/edit?edit=1')]") WebElement action_btn;
	//@FindBy(xpath="//tr[td[1]]//a[contains(@href,'Footertext/edit?edit=1')]  ") WebElement action_btn;

	@FindBy(xpath="//textarea[@id='content']") WebElement address_txt;
	@FindBy(xpath="//input[@id='email']") WebElement email_txt;
	@FindBy(xpath="//input[@id='phone']") WebElement phone_txt;
	@FindBy(xpath="//button[@name='Update']") WebElement update_btn;
	@FindBy(xpath="//button[@data-dismiss='alert']") WebElement alert_box;
	
	public void clickManageFooter() {
		
		manage_footer_btn.click();
	}
	
	public void clearAll() {
		
		address_txt.clear();
		email_txt.clear();
		phone_txt.clear();
	}
	
	public void clickActionButton() {
		
		action_btn.click();
		
	}
	
	public void enterAddress(String address) {
		
		address_txt.sendKeys(address);
	}
	
	public void enterEmail(String email) {
		
		email_txt.sendKeys(email);
	}
	
	public void enterPhoneNumber(String phone_number) {
		
		phone_txt.sendKeys(phone_number);
	}
	
	public void clickUpdateButton() {
		
		update_btn.click();
	}
	
	public boolean isAlertDisplayed() {
		
		return alert_box.isDisplayed();
	}
	
	public boolean isUpdateButtonDisplayed() {
		
		return update_btn.isDisplayed();
	}

}
