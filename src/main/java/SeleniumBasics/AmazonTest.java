package SeleniumBasics;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class AmazonTest {

	public static void main(String[] args) {
		
	
		ReadProperty propReader = new ReadProperty();
		
		Properties prop = propReader.initProp();
		BrowserUtil brUtil = new BrowserUtil();
		
		brUtil.launchBrowser(prop.getProperty("browser"));
		brUtil.launchURL(prop.getProperty("url"));
		
		String pgTitle = brUtil.getPageTitle();
		
		if(pgTitle.contains("Online Shopping site in India"))
		{
			System.out.println("Title is correct..");
		}
		else
		{
			System.out.println("Title is incorrect...");
		}
		
		String currentUrl  =brUtil.getCurrentURL();
		
		if(currentUrl.contains("amazon"))
		{
			System.out.println("Url is correct..");
		}
		else
		{
			System.out.println("Incorrect url..");
		}
		
		brUtil.quitBrowser();
	}

}
