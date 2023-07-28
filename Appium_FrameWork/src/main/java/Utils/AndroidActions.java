package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import Utils.AppiumUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils{
	
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		
	}
	
	
	public void LongPress(WebElement Ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)Ele).getId(),"duration",2000));
	}
	
	public void ScrollToEndAction() {
		boolean canScrollMore ;
		do {
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));}while(canScrollMore);
	}
	
	public void SwipeAction(WebElement ele,String Dir) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)ele).getId(),
			    "direction", Dir,
			    "percent", 0.75
			));
	}
	
	public void ScrollToText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+text+"\").instance(0))"));
	}

}
