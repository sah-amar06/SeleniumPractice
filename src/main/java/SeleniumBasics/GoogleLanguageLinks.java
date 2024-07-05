package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLanguageLinks {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		List<WebElement> langLinks = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));

		System.out.println(langLinks.size());

		for (WebElement e : langLinks) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals("ಕನ್ನಡ")) {
				e.click();
				break;
			}
		}
		
		List<WebElement> footerLinks = driver.findElements(By.xpath("//div[@class='KxwPGc SSwjIe']/div/a"));
		System.out.println(footerLinks.size());
		
		for(WebElement e: footerLinks) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals("Privacy")) {
				e.click();
				break;
			}
			
		}
	}

}
