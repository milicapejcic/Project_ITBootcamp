package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
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
	public void editProfileTest() throws InterruptedException {
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
		logElements.logIn(this.email, this.password);
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
	public void MealItemTest() throws InterruptedException {
		driver.navigate().to(this.baseURL+"/meal/lobster-shrimp-chicken-quesadilla-combo");
		popupElements.closePopUp();
		mealElements.addMeal("2");
		Assert.assertTrue(notifElements.getMsgText().contains("The Following Errors Occurred:"), "[Error!]");
		Assert.assertTrue(notifElements.getMsgText().contains("Please Select Location"), "[Error!]");
		notifElements.msgDisaper();
		popupElements.openLocation();
		popupElements.setLocation("City Center - Albany");
		Thread.sleep(2000);
		mealElements.addMeal("2");
		 
		Assert.assertEquals(notifElements.getMsgText(), "Meal Added To Cart", 
				"[Error! Meal Added to cart- FAILED!]");
	} 
		
		@Test(priority = 9)
		public void AddMealtoFavoriteTest() throws InterruptedException {
			driver.navigate().to(this.baseURL+"/meal/lobster-shrimp-chicken-quesadilla-combo");
			popupElements.closePopUp();
			mealElements.getFavourite().click();
			Assert.assertEquals(notifElements.getMsgText(), "Please login first!", 
					"[Error! Message don't exist!]");
			driver.get(this.baseURL+"/guest-user/login-form");
			logElements.logIn(this.email,this.password);
			driver.navigate().to(this.baseURL+"/meal/lobster-shrimp-chicken-quesadilla-combo");
			Thread.sleep(1000);
			mealElements.getFavourite().click();
			Thread.sleep(1000);
			Assert.assertTrue(notifElements.getMsgText().contains("Product has been added to your favorites"),
			"[Error! Message don't exist!]");
		} 
	 	@Test (priority=12)
		public void ClearCartTest() throws IOException, InterruptedException {
			SoftAssert sa = new SoftAssert();
			driver.navigate().to(this.baseURL+"/meals");
			Thread.sleep(1000);
			popupElements.setLocation("City Center - Albany");
			File file = new File ("D:\\Projekti IT\\Project_ITBootcamp\\Data\\Data.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);	
			XSSFSheet sheet = wb.getSheet("Meals");
			DataFormatter format = new DataFormatter();
			
			for (int i = 1; i < 6; i++) {
			String url = sheet.getRow(i).getCell(0).getStringCellValue();
			String quantity= format.formatCellValue(sheet.getRow(i).getCell(1));
			driver.navigate().to(url);
			Thread.sleep(2000);
			mealElements.addMeal(quantity); 
			sa.assertEquals(notifElements.getMsgText(),"Meal Added To Cart",
					"[ERROR] FAILED: Add To Cart Message");
			 
		}
			sa.assertAll();
			cartElements.clearAll();
			Assert.assertEquals(notifElements.getMsgText(), "All meals removed from Cart successfully", 
					"[Error! Message don't exist!]");	 
			wb.close();
			fis.close();
			
			
		
		} 
		@Test (priority=15)
		public void SearchResultTest() throws IOException, InterruptedException {
			 
			driver.navigate().to(this.baseURL+"/meals");
			popupElements.setLocation("City Center - Albany");
			File file = new File ("D:\\Projekti IT\\Project_ITBootcamp\\Data\\Data.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);	
			XSSFSheet sheet = wb.getSheet("Meal Search Results");
			SoftAssert sa = new SoftAssert() ;
			
			 
			for (int i =1 ; i < 7; i++) {
				XSSFRow row = sheet.getRow(i);
				String location = row.getCell(0).getStringCellValue();
				String mealURL = row.getCell(1).getStringCellValue();
				int numOfRes = (int)row.getCell(2).getNumericCellValue();
				
				driver.navigate().to(mealURL);
				popupElements.openLocation();
				popupElements.setLocation(location);
				Thread.sleep(2000);
				sa.assertEquals(searchElements.getNumberOfResults(), numOfRes,
						"[Error!Number of results is not the same! ]"+ i);
				Thread.sleep(2000);
				for(int j=3 ; j<searchElements.getAllResults().size()+3; j++) {
					String product = row.getCell(j).getStringCellValue();
				//	System.out.println(product);
					sa.assertTrue(searchElements.getResultsNames().get(j-3).contains(product), "[Error]");
					Thread.sleep(2000);
					 
				}
			 }
			sa.assertAll();
			 wb.close();
			 fis.close();
			
		}
		 
		 
	 
		 
	}
	 
	
 
