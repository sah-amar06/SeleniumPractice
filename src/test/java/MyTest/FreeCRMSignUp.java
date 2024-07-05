package MyTest;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumBasics.ElementUtil;

public class FreeCRMSignUp extends BaseTest {

	@DataProvider
	public Object[][] getData() {
		return new Object[] [] {
			{"Amarnath", "Sah", "amarnathsah2013@gmail.com", "sahamar06", "Amar@12345", "ABC", "8923712009"}
		};

	}

	@Test(dataProvider = "getData")
	public void doSignUp(String name, String surname, String email, String uId, String pass, String company, String phone) {
		
		By edition = By.id("payment_plan_id");
		ElementUtil eUtil = new ElementUtil(driver);
		eUtil.doSelectByVisibleText(edition, "Free Edition");

		driver.findElement(By.name("first_name")).sendKeys(name);
		driver.findElement(By.name("surname")).sendKeys(surname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("email_confirm")).sendKeys(email);
		driver.findElement(By.name("username")).sendKeys(uId);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("passwordconfirm")).sendKeys(pass);
		
		driver.findElement(By.name("agreeTerms")).click();
		driver.findElement(By.className("myButton")).click();
		
		driver.findElement(By.name("company_name")).sendKeys(company);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("copy_address")).click();
		driver.findElement(By.name("btnSubmit")).click();
	}

}
