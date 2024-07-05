package MyTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonHomePageTest extends BaseTest {

	@Test(description = "Checking login page title", priority =1)
	public void loginPageTitleTest() {
		String title = driver.getTitle();
//		Assert.assertEquals(title, 
//				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", 
//				"====title is mismatched====");
		Assert.assertTrue(title.contains("Online Shopping site in India"), "====title is mismatched====");

	}

	@Test(description = "Checking Login page url..", priority =2)
	public void loginPageUrlTest() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("amazon"), "===url is not matched====");
	}

	@Test(description = "Checking Login page logo..", priority =3)
	public void loginPageLogoTest() {
		boolean flag = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
		Assert.assertEquals(flag, true, "====Logo is missing====");
	}

}
