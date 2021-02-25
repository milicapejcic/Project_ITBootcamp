package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.LocationPopupPage;

public class ProfileTest extends BasicTest {
	
	
	@Test(priority=0)
	public void editProfile() throws InterruptedException {
		driver.get(this.baseURL+"/guest-user/login-form");
		popupElements.closePopUp();
		logElements.logIn(this.email,this.password);	 
	 	String loginSuccessfull = driver.findElement(By.xpath("//*[@class=\"div_msg\"]/ul/li")).getText();
	 	Assert.assertEquals(loginSuccessfull, "Login Successfull", "[Error! User is not logged in]");
	 	 
	 	 
		 
	}
	@Test(priority=4)
	public void profileImgTest() throws InterruptedException {
		driver.navigate().to(this.baseURL+"/member/account");
		popupElements.closePopUp();
		profileElements.getPersonalInfo().click();
	 	profileElements.getMyAcc().click();
		profileElements.getProfile().click();
	 	profileElements.uploadProfilePhoto("C:\\Users\\x\\Desktop\\slika.jpg");
	 	
	 	Assert.assertEquals(notifElements.getMsgText(), "Profile Image Uploaded Successfully",
	 			"[Error! message doesn't exist!!!]");
	 	notifElements.msgDisaper();
	 	profileElements.removePhoto();
	 	Assert.assertEquals(notifElements.getMsgText(), "Profile Image Deleted Successfully",
	 			"[Error! Image is not deleted!!!");
	 	authElements.logOut();
	 	
	}
	@Test (priority=7)
	public void MealItemTest() {
		driver.navigate().to(this.baseURL+"/meal/lobster-shrimp-chicken-quesadilla-combo");
		popupElements.closePopUp();
		mealElements.addMeal("2");
		Assert.assertEquals(notifElements.getMsgText(), "The Following Errors Occurred:" + 
				"Please Select Location", "[Error! Message don't exist!]");
		notifElements.msgDisaper();
		popupElements.setLocation("City Center - Albany");
		mealElements.addMeal("2");
		Assert.assertEquals(notifElements.getMsgText(), "Meal Added To Cart", 
				"[Error! Message don't exist!]");
	}
		
		@Test(priority = 9)
		public void AddMealtoFavoriteTest() {
			driver.navigate().to(this.baseURL+"/meal/lobster-shrimp-chicken-quesadilla-combo");
			popupElements.closePopUp();
			mealElements.getFavourite();
			Assert.assertEquals(notifElements.getMsgText(), "Please login first!", 
					"[Error! Message don't exist!]");
			driver.get(this.baseURL+"/guest-user/login-form");
			logElements.logIn(this.email,this.password);
			driver.navigate().to(this.baseURL+"/meal/lobster-shrimp-chicken-quesadilla-combo");
			mealElements.getFavourite();
			Assert.assertEquals(notifElements.getMsgText(), "Product has been added to your favorites", 
					"[Error! Message don't exist!]");
		}
		@Test (priority=12)
		public void ClearCartTest() throws IOException {
			SoftAssert sa = new SoftAssert();
			driver.navigate().to(this.baseURL+"/meals");
			popupElements.setLocation("City Center - Albany");
			File file = new File ("Project_ITBootcamp/Data/Data.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);	
			XSSFSheet sheet = wb.getSheet("Meals");
			for (int i =1 ; i < 6; i++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell mealURL = row.getCell(0);
				XSSFCell quantity = row.getCell(1);
				driver.navigate().to(mealURL.getStringCellValue());
				mealElements.addMeal(String.valueOf(quantity.getNumericCellValue()));
				sa.assertEquals(notifElements.getMsgText(), "Meal Added To Cart", 
						"[Error! Message don't exist!]");
			}
			sa.assertAll();
			cartElements.clearAll();
			Assert.assertEquals(notifElements.getMsgText(), "All meals removed from Cart successfully", 
					"[Error! Message don't exist!]");	 
			wb.close();
			fis.close();
			
			
		
		}
		@Test (priority=15)
		public void SearchResultTest() throws IOException {
			 
			driver.navigate().to(this.baseURL+"/meals");
			popupElements.setLocation("City Center - Albany");
			File file= new File ("Project_ITBootcamp/Data/Data.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);	
			XSSFSheet sheet = wb.getSheet("Meal Search Results");
			SoftAssert sa = new SoftAssert() ;
			for (int i =1 ; i < 7; i++) {
				XSSFRow row = sheet.getRow(i);
				XSSFCell location = row.getCell(0);
				XSSFCell mealURL = row.getCell(1);
				XSSFCell numOfRes = row.getCell(2);
				driver.navigate().to(mealURL.getStringCellValue());
				popupElements.setLocation(location.getStringCellValue());
				 
				sa.assertEquals(searchElements.getNumberOfResults(), (int)numOfRes.getNumericCellValue(),
						"[Error!Number of results is not the same! ]");
				
				
				
			}
			
		}
	}
	 
	
 
