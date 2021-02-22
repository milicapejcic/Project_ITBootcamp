package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Tests.BasicTest;

public abstract class BasicPage {
	
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;
	protected BasicTest testElements;
	
	public BasicPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		this.driver = driver;
		this.waiter = waiter;
		this.js = (JavascriptExecutor) driver;
	}
	

}
