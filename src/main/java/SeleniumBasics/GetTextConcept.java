package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
		By logo = By.xpath("(//td[@class='navFooterDescItem'])[2]");
		WebElement log = driver.findElement(logo);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", log);
		
		ElementUtil util = new ElementUtil(driver);
		String txt = util.doGetText(logo);
		System.out.println(txt);

	}

}
