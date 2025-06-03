package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {

	WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(@href,'Category/add')]")
	WebElement new_btn;
	@FindBy(xpath = "//input[@id='category']")
	WebElement category_txt;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement group_select;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choose_btn;
	@FindBy(xpath = "//input[@name='top_menu' and @value='yes']")
	WebElement top_menu_yes_rd;
	@FindBy(xpath = "//input[@name='top_menu' and @value='no']")
	WebElement top_menu_no_rd;
	@FindBy(xpath = "//input[@name='show_home' and @value='yes']")
	WebElement left_menu_yes_rd;
	@FindBy(xpath = "//input[@name='show_home' and @value='no']")
	WebElement left_menu_no_rd;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save_btn;
	@FindBy(xpath = "//button[@data-dismiss='alert']")
	WebElement alert_box;
//	@FindBy(xpath = "//tr[td[contains(text(),'Mobiles')]]//a[contains(@href,'category/delete')]")
//	WebElement del_btn;
	@FindBy(xpath = "//button[@data-dismiss='alert']")
	WebElement delete_alert_box;

	 

	public void javaScriptExcecuter() {

		PageUtility pageUtility = new PageUtility();
		pageUtility.usingJavaScriptExcecuter(driver, "window.scrollBy(0,document.body.scrollHeight)", "");

	}

	public ManageCategoryPage clickNewButton() {

		new_btn.click();
		return this;
	}

	public ManageCategoryPage enterCategory(String category) {

		category_txt.sendKeys(category);
		return this;
	}

	public ManageCategoryPage selectGroup() {

		group_select.click();
		return this;
	}

	public ManageCategoryPage uploadImage() {

		javaScriptExcecuter();

		WaitUtility wait_utility = new WaitUtility();
		wait_utility.waitForVisibilityOfElementLocated(driver, top_menu_yes_rd);

		FileUploadUtility file_upload_utility = new FileUploadUtility();
		file_upload_utility.fileUploadUsingSendKeys(choose_btn, Constants.MOBILEIMAGE);
		
		return this;
	}

	public ManageCategoryPage selectTopMenuRadioButton(String value) {

		if (value.contentEquals("yes")) {

			top_menu_yes_rd.click();
		} else {

			top_menu_no_rd.click();
		}
		return this;
	}

	public ManageCategoryPage selectLeftMenuRadioButton(String value) {

		if (value.contentEquals("yes")) {

			left_menu_yes_rd.click();
		} else {

			left_menu_no_rd.click();
		}
		
		return this;
	}

	public ManageCategoryPage clickSaveButton() {

		save_btn.click();
		return this;

	}

	public boolean isAlertDisplayed() {

		return alert_box.isDisplayed();
	}

	public ManageCategoryPage clickDelete(String category_name) {	
			
		WebElement del_btn=driver.findElement(By.xpath("//tr[td[contains(text(),'"+category_name+"')]]//a[contains(@href,'category/delete')]"));
		del_btn.click();
		driver.switchTo().alert().accept();
		return this;
		

	}

	public boolean isDeleteAlertIsDisplayed() {

		return delete_alert_box.isDisplayed();
	}

}
