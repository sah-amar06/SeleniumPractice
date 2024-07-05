package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementVsFindElements {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("ab")).sendKeys("Selenium");
		/** 
		 * Returns:
				The first matching element on the current page
			Throws:
				NoSuchElementException - If no matching elements are found
		 */
		
		List<WebElement> search = driver.findElements(By.xpath("kdjdf"));
		/**  
		 * Returns:
		 *	A list of all matching WebElements, or an empty list if nothing matches
		 */
		
		System.out.println(search.size()); //0

	}

}
