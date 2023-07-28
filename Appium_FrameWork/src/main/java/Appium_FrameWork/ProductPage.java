package Appium_FrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage extends AndroidActions{
	AndroidDriver driver;

	public ProductPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement AddToCartButton;
	
	
	public void AddProductToCart(String ProductName) {
		int count =driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<count;i++) {
			
			String Productname=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(Productname.equalsIgnoreCase(ProductName)) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
			
		}
	}
	
	public void ClickOnAddToCartButton() {
		AddToCartButton.click();
	}
	
	

}
