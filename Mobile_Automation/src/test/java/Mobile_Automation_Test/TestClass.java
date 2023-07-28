package Mobile_Automation_Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Mobile_Automation.PageObject.FormPage1;
import Mobile_Automation.PageObject.ProductPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TestClass extends BaseClassMA {
	@Test
	public void EcommerceTest() throws InterruptedException {
		FormPage1 FP1 = new FormPage1(driver);
		FP1.SetNameField("pratik 005");
		FP1.ClickOnGenderOption("Female");
		FP1.ClickOnGenderOption("Male");
		FP1.SetCountryName("India");
		FP1.ClickOnLogin();
		ProductPage productPage = new ProductPage(driver);
		productPage.AddToitemsByIndex(0);
		productPage.AddToitemsByIndex(0);
		productPage.ClickOnCartButton();

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));
		List <WebElement> productlist =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count1=productlist.size();
		double TotalSum=0;
		for(int i =0;i<count1;i++) {
			
			String ProductText=productlist.get(i).getText();
			double price=Double.parseDouble(ProductText.substring(1));
			TotalSum = TotalSum+price;
		}
		
		String Totalprice=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double TotalSum1=Double.parseDouble(Totalprice.substring(1));
		Assert.assertEquals(TotalSum, TotalSum1);
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongPress(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(4000);
		
		Set<String> context=driver.getContextHandles();
		for(String Contextname:context) {
			System.out.println(Contextname);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("fb");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}
	}


