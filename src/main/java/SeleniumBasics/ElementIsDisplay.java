package SeleniumBasics;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsDisplay {
	
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//boolean flag = driver.findElement(By.cssSelector(".img-responsive")).isDisplayed();
		
		By logo = By.cssSelector(".img-responsive");
		
		By forgottonPwd = By.tagName("Forgotten Password");
//		
//		ElementUtil eUtil = new ElementUtil(driver);
//		if(eUtil.doIsDisplay(logo));
		
		isElementsDisplayed(logo);
		isElementsDisplayed(forgottonPwd, 2);
	}
	
	public static boolean isElementsDisplayed(By locator) {
		int elementCount =driver.findElements(locator).size();
		if(elementCount==1) {
			System.out.println("Single element is displayed.. ");
			return true;
		}
		else
		{
			System.out.println("Multiple/No elements are displayed..");
			return false;
		}
	}

	
	public static boolean isElementsDisplayed(By locator, int expectedElementCount) {
		int elementCount =driver.findElements(locator).size();
		if(elementCount==expectedElementCount) {
			System.out.println("Element is displayed.. " +locator + " with the occurance of " +expectedElementCount );
			return true;
		}
		else
		{
			System.out.println("Multiple/No elements are displayed.." +locator + " with the occurance of " +expectedElementCount );
			return false;
		}
	}

}
