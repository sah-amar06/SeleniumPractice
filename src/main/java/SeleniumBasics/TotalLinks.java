package SeleniumBasics;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TotalLinks {

	public static void main(String[] args) {
		
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");

		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By links = By.tagName("a");
		
		ElementUtil eUtil = new ElementUtil(driver);
		List<String> linkText = eUtil.getElementTextList(links);
		
		int count = eUtil.getElementCount(links);
		System.out.println(count);
		System.out.println(linkText);
		
		
		System.out.println("---------------------");
		eUtil.getElementAttributeList(links, "href");
		
		System.out.println("---------------------");
		eUtil.getElementAttributeList(links, "class");
		
		brUtil.quitBrowser();

	}

}
