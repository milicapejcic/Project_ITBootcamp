package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import Tests.BasicTest;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		 
	}
	public WebElement getLogin() {
		return driver.findElement(By.linkText("Login"));
	}
	public WebElement username() {
		return driver.findElement(By.name("username"));
	}
	public WebElement password() {
		return driver.findElement(By.name("password"));
	}
	public WebElement loginBtn() {
		return driver.findElement(By.name("btn_submit"));
	}
	public void logIn(String email, String password) {
		this.username().sendKeys(Keys.CONTROL+ "a" + Keys.DELETE);
		this.username().sendKeys(email);
		this.password().sendKeys(Keys.CONTROL+ "a" + Keys.DELETE);
		this.password().sendKeys(password );
		this.loginBtn().click();
	}
	
	
	
	}

 
