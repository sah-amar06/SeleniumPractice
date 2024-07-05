package SeleniumBasics;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCasting {

	public static void main(String[] args) {
		
		
		//1. Valid and recommended
		//WebDriver driver = new ChromeDriver();
		
		//2. Valid but not recommended (Only two methods are available: findelement and findelements)
		//SearchContext driver = new ChromeDriver();
		
		//3. Valid and recommended -> Local execution
		//RemoteWebDriver driver = new ChromeDriver();
	}

}
