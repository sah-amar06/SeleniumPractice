package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartSearch {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		By search = By.name("q");
		
		/**
		 * JavaScript script to pause the screen for locating the dynamic WebElement on the WebPage
		 * 
		 * setTimeout(()=>{
		 * debugger;
		 * }
		 * , 5000)
		 */
		By suggestions = By.xpath("//ul[@class='_1sFryS _2x2Mmc _3ofZy1']//div[@class='YGcVZO _2VHNef']");
		
		
		doSearch(search, "macbook", suggestions, "pro");
		
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
		}		}
}

