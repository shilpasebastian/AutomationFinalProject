package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
public void selectByVisibleValue(WebElement element,String value) {
		
		Select select =new Select(element);
		select.selectByValue(value);
		
	}

public void usingJavaScriptExcecuter(WebDriver driver,String value1,String value2) {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript(value1,value2);
}

}
