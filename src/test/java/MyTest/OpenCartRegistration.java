package MyTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenCartRegistration extends BaseTest{
	
	public static String getRandomEmail() {
		String email = "opencart" +System.currentTimeMillis()  +"@gmail.com";
		return email;
	}
	
	
	
	@DataProvider
	public Object[][] getRegData() {
		return new Object [][] {
			{"Roshni", "sah",  "9238982012", "Roshni123454"},
			{"Amar", "Sah", "782368328o", "Amar1234"},
			{"Prince", "sah", "9812912301" , "prince1234"}
		};
	}
	
	@Test(dataProvider = "getRegData")
	public void registerTest(String firstName, String lastName, String phone, String password) {
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);
		driver.findElement(By.id("input-email")).sendKeys(getRandomEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(phone);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String text = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		System.out.println(text);
		
		Assert.assertEquals(text, "Your Account Has Been Created!");
		
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.linkText("Register")).click();
	}

}
