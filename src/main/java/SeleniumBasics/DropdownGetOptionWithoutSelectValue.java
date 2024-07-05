package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownGetOptionWithoutSelectValue {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.orangehrm.com/en/contact-sales/");
		
		By country = By.id("Form_getForm_Country");
		
		ElementUtil eUtil = new ElementUtil(driver);
		
		eUtil.selectValueFromDropdown(country, "India");
		eUtil.getDropDownOptionSize(country);
		
		By employee = By.xpath("//select[@id='Form_getForm_NoOfEmployees']/option");
		
		eUtil.selectValueFromDropdownWithoutSelectClass(employee, "76 - 100");
		int count = eUtil.getDropdownOptionSizeWithoutSelectClass(employee);
		System.out.println(count);

	}

}
