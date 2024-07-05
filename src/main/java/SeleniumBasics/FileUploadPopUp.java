package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		//tagname : type = 'file' should be there to upload any kind of file
		driver.findElement(By.name("upfile")).sendKeys("/Users/amaranthsah/Desktop/bluelogo21557.png");

	}

}
