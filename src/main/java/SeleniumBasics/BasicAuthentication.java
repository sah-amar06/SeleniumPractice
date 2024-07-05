package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthentication {
	
	static WebDriver driver;
	

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
//		String username = "admin";
//		String password = "admin";
	
//		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		
		

	}

}
