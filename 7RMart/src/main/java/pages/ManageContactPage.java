package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageContactPage {
	
	WebDriver driver;
	
	public ManageContactPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@role='button']") WebElement action_btn;
	@FindBy(xpath="//input[@id='phone']") WebElement phone_txt;
	@FindBy(xpath="//input[@id='email']") WebElement email_txt;
	@FindBy(xpath="//textarea[@name='address']") WebElement address_txt;
	@FindBy(xpath="//textarea[@name='del_time']") WebElement del_time_txt;
	@FindBy(xpath="//input[@id='del_limit']") WebElement del_charge_txt;
	@FindBy(xpath="//button[@name='Update']") WebElement update_btn;
	@FindBy(xpath="//button[@data-dismiss='alert']") WebElement alert_box;
	
	public ManageContactPage clearAll() {
		
		phone_txt.clear();
		email_txt.clear();
		address_txt.clear();
		del_time_txt.clear();
		del_charge_txt.clear();
		return this;
	}
	
	public void javaScriptExcecuter() {

		PageUtility pageUtility = new PageUtility();
		pageUtility.usingJavaScriptExcecuter(driver, "window.scrollBy(0,document.body.scrollHeight)", "");

	}
	
	public ManageContactPage clickActionButton() {
		
		action_btn.click();
		return this;
	}
	
	public ManageContactPage enterPhoneNumber(String phone_number) {
		
		phone_txt.sendKeys(phone_number);
		return this;

	}
	
	public ManageContactPage enterEmai(String email) {
		
		email_txt.sendKeys(email);
		return this;
	}
	
	public ManageContactPage enterAddress(String address) {
		
		address_txt.sendKeys(address);
		return this;
	}
	
	public ManageContactPage enterDeliveryTime(String delivery_time) {
		
		del_time_txt.sendKeys(delivery_time);
		return this;
	}
	
	public ManageContactPage enterDeliveryCharge(String delivery_charge) {
		
		del_charge_txt.sendKeys(delivery_charge);
		return this;
	}
	
	public ManageContactPage clickUpdateButton() {
		
		javaScriptExcecuter();
		WaitUtility wait_utility = new WaitUtility();
		wait_utility.waitForVisibilityOfElementLocated(driver, update_btn);
		update_btn.click();
		return this;
		
	}
	
	public boolean isAlertDisplayed() {
		
		return alert_box.isDisplayed();
	}
	
	public boolean isUpdateButtonDisplayed() {
		
		return update_btn.isDisplayed();
	}

}
