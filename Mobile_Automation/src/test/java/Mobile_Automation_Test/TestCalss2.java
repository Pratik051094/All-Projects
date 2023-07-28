package Mobile_Automation_Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TestCalss2 extends BaseClassMA {

	@Test
	public void LoginTest() throws InterruptedException {

		driver.findElement(By.xpath("//android.widget.TextView[@index='4']")).click();
		driver.findElement(By.id("com.alifesoftware.stocktrainer:id/registrationLink")).click();
		driver.findElement(By.id("com.alifesoftware.stocktrainer:id/inputId_nameValue")).sendKeys("Pratik meher");
		driver.findElement(By.id("com.alifesoftware.stocktrainer:id/inputId_emailValue")).sendKeys("pmeher@gmail.com");
		driver.findElement(AppiumBy.id("com.alifesoftware.stocktrainer:id/inputId_passwordValue")).sendKeys("Pratik@05");
		driver.findElement(AppiumBy.id("com.alifesoftware.stocktrainer:id/inputId_confirmPasswordValue")).sendKeys("Pratik@05");
		driver.findElement(AppiumBy.id("com.alifesoftware.stocktrainer:id/countrySpinner")).click();
		ScrollIntoText("Italy");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Italy']")).click();
		driver.findElement(AppiumBy.id("com.alifesoftware.stocktrainer:id/securityQuestionOne")).click();
		ScrollIntoText("Last name of your favorite teacher?");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Last name of your favorite teacher?']")).click();
		driver.findElement(By.id("com.alifesoftware.stocktrainer:id/inputId_firstSecurityAnswer")).sendKeys("abc");
		driver.findElement(AppiumBy.id("com.alifesoftware.stocktrainer:id/securityQuestionTwo")).click();
		ScrollIntoText("Your childhood hero?");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Your childhood hero?']")).click();
		driver.findElement(By.id("com.alifesoftware.stocktrainer:id/inputId_secondSecurityAnswer")).sendKeys("xyz");
		ScrollIntoText("REGISTER NEW ACCOUNT");
		driver.findElement(AppiumBy.id("com.alifesoftware.stocktrainer:id/securityQuestionThree")).click();
		ScrollIntoText("In which city did your parents meet?");
		driver.findElement(By.xpath("//android.widget.TextView[@text='In which city did your parents meet?']")).click();
		driver.findElement(By.id("com.alifesoftware.stocktrainer:id/inputId_thirdSecurityAnswer")).sendKeys("abcd");
		driver.findElement(By.id("com.alifesoftware.stocktrainer:id/registerButton")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='GREAT']")));
		driver.findElement(By.xpath("//android.widget.TextView[@text='GREAT']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='pmeher@gmail.com']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.alifesoftware.stocktrainer:id/md_buttonDefaultPositive")).click();
	
	}
}