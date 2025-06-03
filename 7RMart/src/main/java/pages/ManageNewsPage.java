package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']") WebElement newBtn;
	@FindBy(xpath ="//textarea[@id='news']") WebElement newsTextarea;
	@FindBy(xpath ="//button[@type='submit']") WebElement saveBtn;
	@FindBy(xpath ="//button[@data-dismiss='alert']") WebElement alert;
	
	public ManageNewsPage clickNewButton() {
		
		newBtn.click();
		return this;
	}
	
	public ManageNewsPage enterNews(String news) {
		
		newsTextarea.sendKeys(news);
		return this;
	}
	
	public ManageNewsPage clickSaveButton() {
		
		saveBtn.click();
		return this;
	}
	
	public boolean isAlertDisplayed() {
		
		return alert.isDisplayed();
	}

}
