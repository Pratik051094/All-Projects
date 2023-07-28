package Appium_FrameWork;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class EcommerceTest2 extends  BaseClass{
	
	@BeforeMethod(alwaysRun=true)
	public void presetup() throws InterruptedException {
		//Thread.sleep(2000);
		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
		//Thread.sleep(2000);
	}
	
	@Test  
	public void EcommerceTestPass() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("pratik meher");
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"India\").instance(0))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@index='6']")).click();
		Thread.sleep(3000);
		String ToastMass=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(ToastMass, "Please enter your name");
	}
	
	@Test  
	public void EcommerceTestFail() throws InterruptedException {
//		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
//		driver.startActivity(activity);
		//driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("pratik meher");
		//driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"India\").instance(0))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='India']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@index='6']")).click();
		Thread.sleep(3000);
		String ToastMass=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(ToastMass, "Please enter your name");
	}

}
