package Mobile_Automation.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage1 {

	public AndroidDriver driver;
	public FormPage1 (AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement NameField;
	
	//com.androidsample.generalstore:id/spinnerCountry
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement CountryOptions;
	
	@AndroidFindBy(xpath="//android.widget.Button[@index='6']")
	private WebElement ShopButton;
	
	public void SetNameField(String name) {
		NameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement FemaleOption;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement MaleOption;
	
	public void ClickOnGenderOption(String Option) {
		if(Option.equalsIgnoreCase("Female"))
			{
			FemaleOption.click();
			}else {
				MaleOption.click();
			}
		
		
	}
	
	public void SetCountryName(String CountryName) {
		CountryOptions.click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+CountryName+"\").instance(0))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+CountryName+"']")).click();
	}
	
	public void ClickOnLogin() {
		ShopButton.click();
	}
	
}
