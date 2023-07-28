package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AppiumUtils {
	
	
	AppiumDriver driver;
	public AppiumUtils(AppiumDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	
    public void WaitUntilElemenetToAppear(WebElement ele) {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(ele, "text", "Cart"));
    }
    
   public String GetScreenshot(String testcaseName,AppiumDriver driver) throws IOException {
	   
	  File source= driver.getScreenshotAs(OutputType.FILE);
	  String Destination=System.getProperty("user.dir")+"\\Reprot"+testcaseName+".png";
	  FileUtils.copyFile(source, new File(Destination));
	  return Destination;
   }
	

}
