package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void selectByVisibleValue(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);

	}

	public void selectByVisibleText(WebElement element, String visibleText) {

		Select select = new Select(element);
		select.selectByVisibleText(visibleText);

	}

	public void selectByIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public void usingJavaScriptExcecuter(WebDriver driver, String value1, String value2) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(value1, value2);
	}

	public void doubleClick(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement drag, WebElement drop) {

		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
	}

	public void mouseHover(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void clickUsingJavaScriptExcecuter(WebDriver driver, String value, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(value, element);
	}

	public void sendKeysUsingJavaScriptExcecuter(WebDriver driver, String value, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(value, element);
	}

}
