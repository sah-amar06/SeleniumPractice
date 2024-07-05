package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//getAttribute(): it will give the value of the given attribute 
		
		By login =  By.linkText("Login");
		String loginValue= driver.findElement(login).getAttribute("href");
		System.out.println(loginValue);
		
		By email = By.id("input-email");
		String emailValue = driver.findElement(email).getAttribute("name");
		System.out.println(emailValue);
		
		
		//If we need to get the entered value on console, we have to use the "value" attribute
		
		driver.navigate().to("https://www.amazon.in/");
		
		ElementUtil util = new ElementUtil(driver);
		
		By searchbox = By.id("twotabsearchtextbox");
		util.doSendKeys(searchbox, "Mobile");
		
//		String searchValue = driver.findElement(searchbox).getAttribute("value");
//		System.out.println(searchValue);
		
		String searchValue = util.doGetAttribute(searchbox, "value");
		System.out.println(searchValue);
	}

}
