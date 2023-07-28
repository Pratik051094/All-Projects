package Appium_FrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.AndroidActions;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter name here']")
	private WebElement NameField;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement FemaleField;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement MaleField;

	//com.androidsample.generalstore:id/spinnerCountry
	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement SelectCountrydropdown;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@index='6']")
	private WebElement ShopButton;

	public void SetNameField(String name) {
		NameField.sendKeys(name);
	}

	public void SetGender(String gender) {
		if (gender.contains("female")) {
			FemaleField.click();
		} else {
			MaleField.click();
		}
	}
	
	public void SetCountrySelection(String CountryName) {
		//SelectCountrydropdown.click();
		ScrollToText(CountryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+CountryName+"']")).click();
	}
	
	public ProductPage SubmitForm() {
		ShopButton.click();
		return new ProductPage(driver);
	}
	
	public void SetActivity() throws InterruptedException {
		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
		
		

}
}
