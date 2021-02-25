package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		 
	}

	public WebElement getLocation() {
		return driver.findElement(By.className("location-selector"));
	}


	public WebElement close() {
		WebElement closePopUp = driver.findElement(By.xpath("//*[@class=\"model-box-mid location-search\"]/a"));
		waiter.until(ExpectedConditions.elementToBeClickable(closePopUp));
		return closePopUp;
	}
	public void closePopUp() {
		this.close().click();
	}

	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}
	
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}

	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	public WebElement getSubmit() {
	return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}
	public void openLocation() {
		this.getLocation().click();
	}
	public void setLocation(String locationName) {
		this.getKeyword().click();
		String value1 = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value = arguments[1]", this.getLocationInput(), value1);
		js.executeScript("arguments[0].click()" , this.getSubmit());
	}
	



}
