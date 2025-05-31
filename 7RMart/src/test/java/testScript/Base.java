package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constant.Constants;
import utilities.WaitUtility;
public class Base {

	public WebDriver driver;
	public FileInputStream referenceVariable;
	public Properties properties;
	
	@BeforeMethod(alwaysRun = true)
	
	public void initializeBrowser() {
	
	driver=new ChromeDriver();
	driver.get("https://groceryapp.uniqassosiates.com/admin");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
	driver.manage().window().maximize();

	
}

//	public void initializeBrowser(String browser) throws Exception {
//
//		try {
//
//			properties = new Properties();
//			referenceVariable = new FileInputStream(Constants.CONFIGFILE);
//			properties.load(referenceVariable);
//
//		} catch (Exception e) {
//
//			System.out.println("Invalid URL");
//
//		}
//
//		if (browser.equalsIgnoreCase("chrome")) {
//
//			driver = new ChromeDriver();
//
//		} else if (browser.equalsIgnoreCase("edge")) {
//
//			driver = new EdgeDriver();
//
//		} else if (browser.equalsIgnoreCase("firefox")) {
//
//			driver = new FirefoxDriver();
//		} else {
//
//			throw new Exception("Inavlid Browser");
//		}
//		driver.get("https://groceryapp.uniqassosiates.com/admin");
//		driver.manage().window().maximize();
//	}

//	@AfterMethod(alwaysRun = true)
//
//	public void driverQuit() throws IOException {
//
//		driver.quit();
//
//	}
}
