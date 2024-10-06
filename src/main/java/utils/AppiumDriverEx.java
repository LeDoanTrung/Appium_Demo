package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverEx {

    public static AppiumDriver getAppiumDriver() {
        //Driver Instance
        AppiumDriver appiumDriver = null;

        //Set Desired Capabilities to send to Appium Server
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_VERSION, "11");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_PACKAGE, "com.wdiodemoapp");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.NEW_COMMAND_TIMEOUT, "60");

        //Setup the APpium Server URL to connect
        try {
            URL appiumServerURL = new URL("http://localhost:4723");

            appiumDriver = new AppiumDriver(appiumServerURL, desiredCapabilities);
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return appiumDriver;
    }
}
