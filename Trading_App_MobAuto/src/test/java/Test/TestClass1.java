package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.BaseClass_TA;
import PageObjectModel.LoginPage;
import PageObjectModel.NewAccountPage;
import PageObjectModel.ProductPage;
import io.appium.java_client.AppiumBy;

public class TestClass1 extends BaseClass_TA {

	//@Test
	public void LoginWithNewAccountpositivetestcase() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.PrivacyPolicyDes("I ACCEPT THE TREMS");
		loginpage.ClickOnNewAccLink();
		NewAccountPage newaccountpage = new NewAccountPage(driver);
		newaccountpage.CreateNewaccount();
		newaccountpage.ClickOnGreatButton();
		newaccountpage.ClickOnOkButton();
		ProductPage productpage = new ProductPage(driver);
		productpage.ClickOnMenuButton();
		productpage.ClickOnSettingDropDown();
		productpage.ClickOnLogoutOption();
		productpage.ClickOnLogoutButton();

	}
	
	@Test
	public void LoginWithNewAccountnegativetestcase() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.PrivacyPolicyDes("I ACCEPT THE TREMS");
		loginpage.ClickOnNewAccLink();
		NewAccountPage newaccountpage = new NewAccountPage(driver);
		newaccountpage.CreateNewaccountWithMissingField();
		

	}
}
