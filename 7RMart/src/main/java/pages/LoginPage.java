package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']") WebElement usernameField;
	@FindBy(xpath="//input[@name='password']") WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']") WebElement signIn_btn;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dash_board;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alert_box;


	public LoginPage enterUserName(String userName) {
		
		usernameField.sendKeys(userName);
		return this;
		
	}
	
	public LoginPage enterPassword(String password) {
		
		passwordField.sendKeys(password);
		return this;
		
	}
	
	public HomePage clickTheSignInButton() {
		
		signIn_btn.click();
		return new HomePage(driver);
		
	}
	
	public boolean isDashBoardDisplayed() {
		
		return dash_board.isDisplayed();
		
		
	}
	
	public boolean isAlertDisplayed() {
		
		return alert_box.isDisplayed();
		
		
	}


}
