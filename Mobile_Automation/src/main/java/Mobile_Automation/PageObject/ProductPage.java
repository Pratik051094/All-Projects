package Mobile_Automation.PageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.AndroidDriver;

public class ProductPage {

	public AndroidDriver driver;
	public ProductPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> AddToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement Cart;
	
	
	public void AddToitemsByIndex(int index) {
		AddToCart.get(index).click();
	}
	
	public void ClickOnCartButton() throws InterruptedException {
		Cart.click();
		Thread.sleep(3000);
	}
}
