package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		 
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
	public WebElement getUploadBtn() {
		return driver.findElement(By.xpath("//*[@class='hover-elements']/a[1]"));
	}
	public WebElement getRemoveBtn() {
	    return driver.findElement(By.xpath("//*[@class='hover-elements']/a[2]"));
	}
	public WebElement uploadPhoto() {
		return driver.findElement(By.xpath("//input[@type='file']"));
	}
	public void uploadProfilePhoto(String photoPath) {
		 this.js.executeScript("arguments[0].click();", getUploadBtn());
		 this.uploadPhoto().sendKeys(photoPath);
	}
	public void removePhoto() {
		this.js.executeScript("arguments[0].click()", getRemoveBtn());
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
 
