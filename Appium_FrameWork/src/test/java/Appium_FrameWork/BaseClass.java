package Appium_FrameWork;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	public UiAutomator2Options options;
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws MalformedURLException {
	    service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\pmeher\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		 options = new UiAutomator2Options();
		options.setDeviceName("pratikMobile1");
		options.setChromedriverExecutable("C:\\Users\\pmeher\\eclipse-workspace\\Appium\\src\\test\\java\\Resources\\mobileApp\\chromedriver.exe");
		//options.setApp("C:\\Users\\pmeher\\eclipse-workspace\\Appium\\src\\test\\java\\Resources\\mobileApp\\ApiDemos-debug.apk");
		options.setApp("C:\\Users\\pmeher\\eclipse-workspace\\Appium\\src\\test\\java\\Resources\\mobileApp\\General-Store.apk");
	      driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      
	      
	}
	
	
	@AfterClass(alwaysRun=true)
	public void stopdownAppium() {
		driver.quit();
		service.stop();
	}

	 public List<HashMap<String, String>> GetJsonData(String JsonPath) throws IOException {
	    	
	    	String Jsoncontent=FileUtils.readFileToString(new File(JsonPath),StandardCharsets.UTF_8);
	    	
	    	ObjectMapper  mapper = new ObjectMapper();
	    	List<HashMap<String,String>> data=mapper.readValue(Jsoncontent, new TypeReference<List<HashMap<String , String>>>(){});
	    	return data;
	    }
	
}
