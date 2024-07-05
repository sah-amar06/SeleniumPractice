package SeleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		
		/*
		 * Alert is an Interface in Selenium
		 * 
		 * JS alerts:
		 * 1. alert() with conform button
		 * 2. alert() with conform and cancel button
		 * 3. alert() with text field and conform and cancel button
		 */

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		//driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		//1. alert() with conform button
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		alert.accept();
		
		//2. alert() with conform and cancel button
		//Thread.sleep(3000);
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		alert.dismiss();
//		
//		String text = driver.findElement(By.xpath("//p[@id='result']")).getText();
//		System.out.println(text);
		
		//3. alert() with text field and conform and cancel button
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Welcome");
		alert.accept();
		
		
		

	}

}
