package SeleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropdown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.orangehrm.com/en/contact-sales/");
		
		By country_opt = By.id("Form_getForm_Country");
		
		ElementUtil eUtil = new ElementUtil(driver);
		
		eUtil.doSelectByIndex(country_opt, 9);
		
		By employeecount = By.id("Form_getForm_NoOfEmployees");
		eUtil.doSelectByVisibleText(employeecount, "51 - 75");
		
		List<String> dropDownOptionTextList = eUtil.getDropDownOptionTextList(employeecount);
		System.out.println(dropDownOptionTextList);
		
		System.out.println(eUtil.getDropDownOptionSize(employeecount));
		System.out.println(eUtil.getDropDownOptionSize(country_opt));
	}

}
