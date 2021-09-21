package calculadora;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

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
	    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	  }

	  @Test
	  public void sampleTest() {
	    MobileElement el4 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
	    el4.click();
	    MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("plus");
	    el5.click();
	    MobileElement el6 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
	    el6.click();
	    MobileElement el7 = (MobileElement) driver.findElementByAccessibilityId("equals");
	    el7.click();
	    MobileElement el8 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
	    el8.click();
	  }

	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	
}
