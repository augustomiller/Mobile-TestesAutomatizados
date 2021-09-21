package clock;

import static org.junit.Assert.assertEquals;

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

public class Clock {
	
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
	  
	  public void acessarMenuAlarme() throws Exception {
		  MobileElement btnAlarme = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='ALARM']");
		  btnAlarme.click();
	  }
	  
	  public void novoAlarme() throws Exception {
		  MobileElement btnAddAlarm = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Add alarm"));
		  btnAddAlarm.click();
		  
		  MobileElement btnOk = (MobileElement) driver.findElement(MobileBy.id("android:id/button1"));
		  btnOk.click();
	  }

	  @Test
	  public void interagirComEditText() throws Exception {
		  
		  acessarMenuAlarme();
		  novoAlarme();
		  
		  MobileElement campoLabel = (MobileElement) driver.findElement(MobileBy.id("com.google.android.deskclock:id/edit_label"));
		  campoLabel.click();
		  
		  MobileElement campoEditText = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.EditText"));
		  campoEditText.sendKeys("Hora de ir para a academia!");
	  }
	  
	  @Test
	  public void interagirComCombo() throws Exception {
		  acessarMenuAlarme();
		  novoAlarme();
		  
		  MobileElement defaultCombo = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Default (Cesium)']"));
		  defaultCombo.click();
		  
		  MobileElement bariumCombo = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Barium']"));
		  bariumCombo.click();
	  }
	  
	  @Test
	  public void interagindoComSwitch() throws Exception {
		  acessarMenuAlarme();
		  novoAlarme();
		  
		  MobileElement switchApp = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.Switch[@text='ON'][1]"));
		  switchApp.click();
		  
		  assertEquals("false", switchApp.getAttribute("checked"));
	  }
	  
	  @Test
	  public void interagindoComCheckBox() throws Exception {
		  acessarMenuAlarme();
		  novoAlarme();
		   
		  MobileElement campoCheckBox = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.CheckBox[@text='Repeat']"));
		  campoCheckBox.click();
		  
		  assertEquals("true", campoCheckBox.getAttribute("checked"));
	  }

	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	
}
