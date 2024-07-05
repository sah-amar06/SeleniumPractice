package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcept {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		//1. Create a WebElement(FindElement) + Perform an action
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile");
//		driver.findElement(By.id("nav-search-submit-button")).click();

		//2. 
//		WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
//		WebElement clickSearch = driver.findElement(By.id("nav-search-submit-button"));
//		
//		searchField.sendKeys("Laptop");
//		clickSearch.click();
		
		//3. By locator 
		
//		By searchField = By.id("twotabsearchtextbox");
//		By clickSearch = By.id("nav-search-submit-button");
//		
//		WebElement search = driver.findElement(searchField);
//		WebElement click = driver.findElement(clickSearch);
//		
//		search.sendKeys("Iphone");
//		click.click();
		
		//4. By locator +Generic function for WebElement
		
//		By searchField = By.id("twotabsearchtextbox");
//		By clickSearch = By.id("nav-search-submit-button");
//		
//		getElement(searchField).sendKeys("mobile");
//		getElement(clickSearch).click();
		
		
		//5. By locator +Generic function for WebElement and sendKeys
//		
//		By searchField = By.id("twotabsearchtextbox");
//		By clickSearch = By.id("nav-search-submit-button");
//		
//		doSendKeys(searchField, "Mobile");
		
		//6. By locator +Generic function for WebElement and sendKeys : ElementUtil
		
		By searchField = By.id("twotabsearchtextbox");
		By clickSearch = By.id("nav-search-submit-button");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(searchField, "mobile");
		
	}

	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value)
	{
		getElement(locator).sendKeys(value);
	}

}
