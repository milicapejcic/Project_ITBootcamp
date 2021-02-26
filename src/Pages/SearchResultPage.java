package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasicPage {

	public SearchResultPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
		 
	}
	public List<WebElement> getAllResults() {
		List<WebElement> results = driver.findElements(By.xpath("//*[@class='product-name']/a"));
		return results;
	}

	public ArrayList<String> getResultsNames() {
		ArrayList<String> names = new ArrayList<>();
		for (int i = 0; i < this.getAllResults().size(); i++) {
			names.add(this.getAllResults().get(i).getText());
		}
		return names;
	}
	public int getNumberOfResults() {
		int number=this.getAllResults().size();
		return number;
	}
}
	 

 
