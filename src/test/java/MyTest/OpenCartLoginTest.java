package MyTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartLoginTest extends BaseTest {
	
	
	@Test(description= "Checking login page title", priority =1)
	public void loginPageTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Account Login", "====title is mismatched====");
		
	}
	
	@Test(description="Checking Login page url..", priority =2)
	public void loginPageUrlTest() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("route=account/login"), "===url is not matched====");
	}
	
	@Test(description= "Checking Login page logo..", priority =3)
	public void loginPageLogoTest() {
		boolean flag = driver.findElement(By.cssSelector("img.img-responsive")).isDisplayed();
		Assert.assertEquals(flag, true, "====Logo is missing====");
	}

}
