package calculadora;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Calculadora {
	
	  private AndroidDriver driver;

	  @Before
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.google.android.deskclock");
	    desiredCapabilities.setCapability("appActivity", "com.android.deskclock.DeskClock");

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	  }

	  @Test
	  public void interagirComElementos() throws Exception {
		  System.out.println("Clock is Running...");
		  
		  MobileElement btnAlarme = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='ALARM']");
		  btnAlarme.click();
		  Thread.sleep(2000);
		  
		  MobileElement btnAddAlarm = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Add alarm"));
		  btnAddAlarm.click();
		  Thread.sleep(2000);
		  
		  MobileElement btnOk = (MobileElement) driver.findElement(MobileBy.id("android:id/button1"));
		  System.out.println("Clicking using MobileBy Id...");
		  btnOk.click();
		  Thread.sleep(2000);
		  
		  MobileElement btnExpand = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.ImageButton[@resource-id='com.google.android.deskclock:id/arrow'][1]"));
		  btnExpand.click();
		  Thread.sleep(2000);
	  }

	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	
}
