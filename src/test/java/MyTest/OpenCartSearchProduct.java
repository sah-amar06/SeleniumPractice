package MyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenCartSearchProduct extends BaseTest {
	
	
	@DataProvider
	public Object[][] getData() {
		return new Object [] [] {
			{"macbook", "2"},
		};
	}
	
	
	@Parameters({"username", "password"})
	@Test(dataProvider = "getData")
	public void searchProduct(String prodName, String productCount) {
		driver.findElement(By.linkText("Login")).click();
//		driver.findElement(By.id("input-email")).sendKeys(username);
//		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement search = driver.findElement(By.xpath("//input[@name='search']"));
		search.sendKeys(prodName);
		Actions act = new Actions(driver);
		act.keyDown(Keys.ENTER).perform();
	
		driver.findElement(By.xpath("//a[text()='MacBook']")).click();
		WebElement quantity = driver.findElement(By.cssSelector("#input-quantity"));
		quantity.clear();
		quantity.sendKeys(productCount);
		
		
		WebElement search1= driver.findElement(By.xpath("//div[@class='col-sm-5']/div/input"));
		search1.clear();
		search1.sendKeys(prodName);
		act.keyDown(Keys.ENTER).perform();
		driver.findElement(By.xpath("//a[text()='MacBook Air']")).click();
		WebElement quantity1 = driver.findElement(By.cssSelector("#input-quantity"));
		quantity1.clear();
		quantity1.sendKeys(productCount);
	
	}

}
