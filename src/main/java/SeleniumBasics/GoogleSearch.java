package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		By search = By.name("q");
		By suggestions = By.xpath("//ul[@class='G43f7e']/li//div[@class='wM6W7d']");

		doSearch(search, "Selenium", suggestions, "interview");

	}

	public static void doSearch(By searchField, String searchValue, By suggestions, String value)
			throws InterruptedException {
		driver.findElement((searchField)).sendKeys(searchValue);
		Thread.sleep(3000);

		List<WebElement> suggestionList = driver.findElements(suggestions);

		System.out.println("Number of suggestions:  " + suggestionList.size());

		for (WebElement e : suggestionList) {
			String text = e.getText();
			System.out.println(text);

			if (text.contains(value)) {
				e.click();
				break;
			}
		}

	}

}
