package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartTest {

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");

		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		System.out.println(brUtil.getCurrentURL());
		System.out.println(brUtil.getPageTitle());

		By email = By.id("input-email");
		By password = By.id("input-password");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(email, "Amar@gmail.com");
		eleUtil.doSendKeys(password, "Amar@123");

		// eleUtil.doSendKeys(password, null); // java.lang.IllegalArgumentException:
		// Keys to send should be a not null CharSequence

		//brUtil.closeBrowser();

	}

}
