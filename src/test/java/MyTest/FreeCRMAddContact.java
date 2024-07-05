package MyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FreeCRMAddContact extends BaseTest {

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "Roshni", "sah" } };
	}

	@Parameters({ "username", "password" })
	@Test()
	public void doAddContect(String uName, String pass) {
		driver.findElement(By.name("username")).sendKeys(uName);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		WebElement contact = driver.findElement(By.xpath("//a[text()='Contacts']"));
		WebElement newContact = driver.findElement(By.xpath("//a[text()='New Contact']"));

		Actions act = new Actions(driver);
		act.moveToElement(contact).moveToElement(newContact).click().build().perform();

		WebElement option = driver.findElement(By.xpath("//select[@name='title']"));
		Select select = new Select(option);
		select.selectByVisibleText("Mr.");

		driver.findElement(By.name("first_name")).sendKeys("abc");
		driver.findElement(By.name("surname")).sendKeys("abc");

		driver.findElement(By.xpath("//input[@value='Load From Company']//following::input[1]")).click();

	}
}
