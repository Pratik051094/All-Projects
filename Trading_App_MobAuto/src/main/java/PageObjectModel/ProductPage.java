package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class ProductPage extends AndroidActions {

	public AndroidDriver driver;
	
	public ProductPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@index='0']")
	private WebElement MainMenuButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='pmeher@gmail.com']")
	private WebElement SettingDropdown;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Logout']")
	private WebElement LogoutOption;
	
	@AndroidFindBy(id="com.alifesoftware.stocktrainer:id/md_buttonDefaultPositive")
	private WebElement LogoutButton;
	public void ClickOnMenuButton() throws InterruptedException {
		MainMenuButton.click();
		Thread.sleep(3000);
	}
	
	public void ClickOnSettingDropDown() throws InterruptedException {
		SettingDropdown.click();
		Thread.sleep(3000);
	}
	
	public void ClickOnLogoutOption() throws InterruptedException {
		LogoutOption.click();
		Thread.sleep(3000);
	}
	
	public void ClickOnLogoutButton() {
		LogoutButton.click();
	}
	
	
	
	
}
