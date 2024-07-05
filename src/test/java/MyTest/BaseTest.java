package MyTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import SeleniumBasics.BrowserException;

public class BaseTest {

	WebDriver driver;

	@Parameters({"browser", "url"})
	@BeforeTest
	public void setUp(String browserName, String url) {
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver= new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver =  new EdgeDriver();
			break;
		case "safari":
			driver= new SafariDriver();
			break;

		default:
			System.out.println("Please pass the right browser.." +browserName);
			throw new BrowserException("Wrong browser passed..");

		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}
