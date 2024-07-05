package TestNgPractice;

import org.testng.annotations.*;

public class TestNgAnnotations {
	
	@BeforeSuite
	public void connectWithDB() {
		System.out.println("Before Suite.... This will execute on the suite level");
	}
	
	@BeforeTest
	public void createUser() {
		System.out.println("Before Test... This will execute after Suite ");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("Before Class.. This will execute after Suite");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("Before Method.. This will execute @Afterclass and before each @Test method");
	}
	
	@Test
	public void searchProduct() {
		System.out.println("This @Test method will have all the actional class/method");
	}
	
	@Test
	public void addToCart() {
		System.out.println("This @Test method will have all the actional class/method");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("After method.. This will execute before @AfterClass and after each @Test method");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("After Class.. This will execute before Suite");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("After Test... This will execute before Suite ");
	}
	
	@AfterSuite
	public void disconnectWithDB() {
		System.out.println("After Suite.... This will execute on the suite level");
	}

}
