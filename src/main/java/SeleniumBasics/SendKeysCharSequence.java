package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysCharSequence {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.amazon.in/");

		String searchItem = "Mobile";
		String price = "under 1000";
		StringBuffer sb = new StringBuffer("display size");
		StringBuilder sbr = new StringBuilder("6inch");

		WebElement searchField= driver.findElement(By.xpath("//input[@name='field-keywords']"));
		searchField.sendKeys(searchItem, " ", price, " ", sb, " ", sbr);

	}

}
