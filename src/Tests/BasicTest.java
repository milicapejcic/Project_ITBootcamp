package Tests;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import Pages.AuthPage;
import Pages.CartSummaryPage;
import Pages.LocationPopupPage;
import Pages.LoginPage;
import Pages.MealPage;
import Pages.NotificationSistemPage;
import Pages.ProfilePage;
import Pages.SearchResultPage;
import okhttp3.Cookie;

 

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
			this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			this.popupElements = new LocationPopupPage(driver, waiter ,js);
			this.logElements = new LoginPage(driver, waiter,js);
			this.notifElements = new NotificationSistemPage(driver, waiter,js);
			this.profileElements = new ProfilePage(driver, waiter,js);
			this.authElements = new AuthPage(driver, waiter,js);
			this.mealElements = new MealPage(driver, waiter,js);
			this.cartElements = new CartSummaryPage(driver, waiter,js);
			this.searchElements = new SearchResultPage(driver, waiter,js);
			this.baseURL ="http://demo.yo-meals.com";
			this.email = "customer@dummyid.com";
			this.password ="12345678a"; 
		  
}

	@AfterMethod
	public void takeScreenshot(ITestResult result) throws HeadlessException, AWTException, IOException {
		String testTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss'.jpg'").format(new Date());
		if (ITestResult.FAILURE == result.getStatus()) {
			BufferedImage screenshoot = new Robot()
					.createScreenCapture((new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())));
			File screenshot = new File("screenshot.jpg");
			ImageIO.write(screenshoot, "jpg", new File("Screenshots\\" + testTime));
			 
		}this.driver.manage().deleteAllCookies();
		}
	@AfterClass
	public void clean() { 
		driver.quit();
	}
}

 
