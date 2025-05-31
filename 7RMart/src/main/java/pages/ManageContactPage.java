package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	
	WebDriver driver;
	
	public ManageContactPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[contains(@class,'small-box-footer') and contains(@href,'admin/list-contact')]") WebElement mange_contact_btn;
	@FindBy(xpath="//a[@role='button']") WebElement action_btn;
	@FindBy(xpath="//input[@id='phone']") WebElement phone_txt;
	@FindBy(xpath="//input[@id='email']") WebElement email_txt;
	@FindBy(xpath="//textarea[@name='address']") WebElement address_txt;
	@FindBy(xpath="//textarea[@name='del_time']") WebElement del_time_txt;
	@FindBy(xpath="//input[@id='del_limit']") WebElement del_charge_txt;
	@FindBy(xpath="//button[@name='Update']") WebElement update_btn;
	@FindBy(xpath="//button[@data-dismiss='alert']") WebElement alert_box;
	
	public void clearAll() {
		
		phone_txt.clear();
		email_txt.clear();
		address_txt.clear();
		del_time_txt.clear();
		del_charge_txt.clear();
	}
	
	public void clcickManageContact() {
		
		mange_contact_btn.click();
	}
	
	public void clickActionButton() {
		
		action_btn.click();
	}
	
	public void enterPhoneNumber(String phone_number) {
		
		phone_txt.sendKeys(phone_number);

	}
	
	public void enterEmai(String email) {
		
		email_txt.sendKeys(email);
	}
	
	public void enterAddress(String address) {
		
		address_txt.sendKeys(address);
	}
	
	public void enterDeliveryTime(String delivery_time) {
		
		del_time_txt.sendKeys(delivery_time);
	}
	
	public void enterDeliveryCharge(String delivery_charge) {
		
		del_charge_txt.sendKeys(delivery_charge);
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
