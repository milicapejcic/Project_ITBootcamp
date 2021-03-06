package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		 
	}
	public WebElement getMealsLink() {
		return driver.findElement(By.linkText("Meals"));
	}

	public WebElement getMealSearch() {
		return driver.findElement(By.name("keywords"));

	}

	public Select getSortBy() {
		Select products = new Select(driver.findElement(By.className("sort-toggle is-active")));
		return products;
	}

	public WebElement getFilters() {
		return driver.findElement(By.className("js-filter-text"));
	}

	public WebElement getResetAllFilters() {
		return driver.findElement(By.linkText("Reset All"));
	}

	public WebElement getChef() {
		WebElement chef = driver.findElement(By.linkText("Chef"));
		chef.click();
		return driver.findElement(By.name("multiple_chefs"));
	}

	public WebElement getResetChef() {
		return driver.findElement(By.linkText("Reset Chef"));
	}

	public WebElement getPrice() {
		return driver.findElement(By.linkText("Price $"));
	}

	public WebElement getMinPriceValue() {
		return driver.findElement(By.name("priceFilterMinValue"));
	}

	public WebElement getMaxPriceValue() {
		return driver.findElement(By.name("priceFilterMaxValue"));
	}

	public WebElement getResetPrice() {
		return driver.findElement(By.linkText("Reset Price"));
	}

	public WebElement getType(String type) {
		return driver.findElement(By.xpath("//*[@veg-name='" + type + "']"));
		 
	}

	public WebElement resetType() {
		return driver.findElement(By.linkText("Reset Type"));
	}

	public WebElement getMealType(String mealType) {
		return driver.findElement(By.xpath("//*[@meal-name='" + mealType + "']"));
		 
	}

	public WebElement resetMealType() {
		return driver.findElement(By.linkText("Reset Meal Type"));
	}

	public WebElement getCouisineType(String cuisineType) {
		return driver.findElement(By.xpath("//*[@cuisine-name='" + cuisineType + "']"));
		 
	}

	public WebElement resetCouisineType() {
		return driver.findElement(By.linkText("Resest Cuisine Type"));
	}

	public void addproduct(String name) {
		driver.findElement(By.linkText(name)).click();
	}
	public void clearAll () {
		this.driver.findElement(By.xpath("//*[@class=\"cart-head\"]/a[2]"));
	}

	public WebElement getFavourite() {
		return this.driver.findElement(By.xpath("//*[@class=\"product-detail-image\"]/a"));
	}

	public void addMeal(String quantity) {
		driver.findElement(By.name("product_qty")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		driver.findElement(By.name("product_qty")).sendKeys(quantity);
		driver.findElement(By.linkText("Add To Cart")).click();
	}
}
	 


