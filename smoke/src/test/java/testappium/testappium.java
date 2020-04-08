/**
 * 
 */
package testappium;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author Naresh
 *
 */
public class testappium {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("test ");
		DesiredCapabilities caps=new DesiredCapabilities();
	    caps.setCapability("deviceName","Android");
	   // caps.setCapability("udID","213b6bacbe0b7ece");
	    caps.setCapability("appActivity","com.weather.Weather.app.SplashScreenActivity");
	    caps.setCapability("platformName","Android");
	    caps.setCapability("platformVersion","7.0");
	    caps.setCapability("app","/Users/macmini/Downloads/app_google_universal_debug_812010189.apk");
	    caps.setCapability("appPackage","com.weather.Weather");
	    caps.setCapability("appActivity","com.weather.TWC");
	    
	   // caps.setCapability("noReset","true");
	    
	    AppiumDriver dd=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);

	    System.out.println("failed");
	}

}
