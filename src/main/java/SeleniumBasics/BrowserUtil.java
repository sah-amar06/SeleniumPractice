package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {

	WebDriver driver;

	public WebDriver launchBrowser(String browserName) {
		System.out.println("Enter the browser:.. " + browserName);

		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("please pass the right browser.." + browserName);
			throw new BrowserException("Invalid browser.." + browserName);

		}
		return driver;
	}

	public void launchURL(String url) {
		if (url == null) {
			throw new BrowserException("Invalid url..." + url);
		}

		if (url.isBlank() || url.isEmpty()) {
			throw new BrowserException("Blank/empty url... " + url);
		}

		if (url.indexOf("http") == -1 || url.indexOf("http") > 0) {
			throw new BrowserException("http/https is missing..." + url);
		}
		driver.get(url.trim());
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		if (title == null) {
			System.out.println("Null title...");
			return null;
		}
		return title;
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}
}
