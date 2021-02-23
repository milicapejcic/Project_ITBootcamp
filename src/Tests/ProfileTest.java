package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

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
		//popupElements.closePopUp();
		profileElements.getPersonalInfo().click();
	 	profileElements.getMyAcc().click();
		profileElements.getProfile().click();
	 	profileElements.uploadProfilePhoto("C:\\Users\\x\\Desktop\\slika.jpg");
	 	
	 	Assert.assertEquals(this.notifElements.getMsgText(), "Profile Image Uploaded Successfully",
	 			"[Error! message doesn't exist!!!]");
	 	this.notifElements.msgDisaper();
	 	this.profileElements.removePhoto();
	 	Assert.assertEquals(this.notifElements.getMsgText(), "Profile Image Deleted Successfully",
	 			"[Error! Image is not deleted!!!");
	}
	
	 
	
}
