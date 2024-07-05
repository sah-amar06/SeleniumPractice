package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisabledElementConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		
		driver.findElement(By.id("pass")).click();//nothing will happen with no exception
		
		
		/*
		 * We won't get any exception if we are performing any operation except sendKeys()
		 * on disable element
		 * 
		 */
		
		driver.findElement(By.id("pass")).sendKeys("Hello");  
		//org.openqa.selenium.ElementNotInteractableException: element not interactable
	}

}
