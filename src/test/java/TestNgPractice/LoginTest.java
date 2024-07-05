package TestNgPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
	}
	
	@Test(description= "Checking login page title")
	public void loginPageTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Account Login", "====title is mismatched====");
		
	}
	
	@Test(description="Checking Login page url..")
	public void loginPageUrlTest() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("route=account/login"), "===url is not matched====");
	}
	
	@Test(description= "Checking Login page logo..")
	public void loginPageLogoTest() {
		boolean flag = driver.findElement(By.cssSelector("img.img-responsive")).isDisplayed();
		Assert.assertEquals(flag, true, "====Title is missing====");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
