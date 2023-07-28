package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends AndroidActions{
	
	public AndroidDriver driver;
	public LoginPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@index='4']")
	private WebElement PrivacyPolicyDes_acc;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@index='3']")
	private WebElement PrivacyPolicyDes_Decline;
	
	@AndroidFindBy(id="com.alifesoftware.stocktrainer:id/registrationLink")
	private WebElement NewAccountLink;
	
	public void PrivacyPolicyDes(String button) {
		if(button.equalsIgnoreCase("I ACCEPT THE TREMS")) {
			PrivacyPolicyDes_acc.click();
		}else {
			PrivacyPolicyDes_Decline.click();
		}
	}
	
	public void ClickOnNewAccLink() {
		NewAccountLink.click();
	}
	
	
	

}
