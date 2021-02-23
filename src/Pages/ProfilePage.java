package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		 
	}
	public WebElement getPersonalInfo() {
		return driver.findElement(By.linkText("Roland Dubois"));
	}
	public WebElement getMyAcc() {
		return driver.findElement(By.linkText("My Account"));
	}
	public WebElement getProfile() {
		return driver.findElement(By.linkText("Profile"));
	}
	public WebElement getFirstName() {
		return driver.findElement(By.name("user_first_name"));
	}
	public WebElement getLastName() {
		return driver.findElement(By.name("user_last_name"));
	}
	public WebElement getEmail() {
		return driver.findElement(By.name("user_email"));
	}
	public WebElement getAddress() {
		return driver.findElement(By.name("user_address"));
	}
	public WebElement getPhone() {
		return driver.findElement(By.name("user_phone"));
	}
	public WebElement getZipCode() {
		return driver.findElement(By.name("user_zip"));
		
	}
	public Select getCountry() {
		Select country = new Select (driver.findElement(By.id("user_country_id")));
		return country;
	}
	public Select getState() {
		Select state = new Select(driver.findElement(By.id("user_state_id")));
		return state;
	}
	public Select getCity() {
		Select city = new Select(driver.findElement(By.id("user_city")));
		return city;
	}
	public WebElement saveAll() {
		return driver.findElement(By.name("btn_submit"));
	}
	public WebElement currentPassword() {
		return driver.findElement(By.name("current_password"));
	}
	public WebElement newPassword() {
		return driver.findElement(By.name("new_password"));
	}
	public WebElement confirmNewPassword() {
		return driver.findElement(By.name("conf_new_password"));
	}
	public void uploadBtn() {
		js.executeScript("arguments[0].click();",
				driver.findElement(By.xpath("//*[@title='Uplaod']")));
	}
	public void uploadProfilePhoto(String photoPath) {
		this.uploadBtn();
		driver.findElement(By.xpath("//*[@type='file']")).sendKeys(photoPath);
	} 
	 public void removePhoto() {
		this.js.executeScript("arguments[0].click()",  
				driver.findElement(By.xpath("//*[@title='Remove']")));
	}
	
	public void changeProfileInfo(String firstName, String lastName , String email, String address,
			String phone, String zipCode) {
		this.getFirstName().sendKeys(Keys.CONTROL+"a" + Keys.DELETE);
		this.getFirstName().sendKeys(firstName);
		this.getLastName().sendKeys(Keys.CONTROL+"a" + Keys.DELETE);
		this.getLastName().sendKeys(lastName);
		this.getEmail().sendKeys(Keys.CONTROL+"a" + Keys.DELETE);
		this.getEmail().sendKeys(email);
		this.getAddress().sendKeys(Keys.CONTROL+"a" + Keys.DELETE);
		this.getAddress().sendKeys(address);
		this.getPhone().sendKeys(Keys.CONTROL+"a" + Keys.DELETE);
		this.getPhone().sendKeys(phone);
		this.getZipCode().sendKeys(Keys.CONTROL+"a" + Keys.DELETE);
		this.getZipCode().sendKeys(zipCode);
		
	}
	 
}
 
