package test.tips;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LaunchApp {
    public static void main(String[] args) {
        //Driver Instance
        AppiumDriver appiumDriver;

        //Set Desired Capabilities to send to Appium Server
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        desiredCapabilities.setCapability("appPackage", "com.wdiodemoapp");
        desiredCapabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");

        //Setup the APpium Server URL to connect
        try {
            URL appiumServerURL = new URL("http://192.168.217.22:4723");

            appiumDriver = new AppiumDriver(appiumServerURL, desiredCapabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
}
