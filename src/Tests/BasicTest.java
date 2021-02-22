package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pages.AuthPage;
import Pages.CartSummaryPage;
import Pages.LocationPopupPage;
import Pages.LoginPage;
import Pages.MealPage;
import Pages.NotificationSistemPage;
import Pages.ProfilePage;
import Pages.SearchResultPage;

 

public class BasicTest {
	
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;
	protected LocationPopupPage popupElements;
	protected LoginPage logElements;
	protected NotificationSistemPage notifElements;
	protected ProfilePage profileElements;
	protected AuthPage authElements;
	protected MealPage mealElements;
	protected CartSummaryPage cartElements;
	protected SearchResultPage searchElements;
	protected String baseURL;
	protected String email;
	protected String password;
	 
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
			     "driver-lib\\chromedriver.exe");  
			this.driver = new ChromeDriver ();
			this.waiter = new WebDriverWait(driver, 30);
			this.js = (JavascriptExecutor) driver; 
			this.driver.manage().window().maximize();
			this.driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			this.popupElements = new LocationPopupPage(driver, waiter);
			this.logElements = new LoginPage(driver, waiter);
			this.notifElements = new NotificationSistemPage(driver, waiter);
			this.profileElements = new ProfilePage(driver, waiter);
			this.authElements = new AuthPage(driver, waiter);
			this.mealElements = new MealPage(driver, waiter);
			this.cartElements = new CartSummaryPage(driver, waiter);
			this.searchElements = new SearchResultPage(driver, waiter);
			this.baseURL ="http://demo.yo-meals.com";
			this.email = "customer@dummyid.com";
			this.password ="12345678a";
			
			
			
			
			
			 
			 
			 
		 

}
	@AfterClass
	public void clean() {
		driver.quit();
	}
}

 
