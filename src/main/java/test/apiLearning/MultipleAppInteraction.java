package test.apiLearning;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import utils.AppiumDriverEx;

import java.time.Duration;

public class MultipleAppInteraction {
    public static void main(String[] args) {
        //Init a session with Appium server
        AndroidDriver appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Go to login form
        WebElement loginLabel = appiumDriver.findElement(MobileBy.accessibilityId("Login"));
        loginLabel.click();

        WebElement username = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
        username.sendKeys("trungletest@gmail.com");

        WebElement password = appiumDriver.findElement(AppiumBy.accessibilityId("input-password"));
        password.sendKeys("123456789");

        WebElement loginButton = appiumDriver.findElement(AppiumBy.accessibilityId("button-LOGIN"));
        loginButton.click();

        //Put the app in the background => Simulate the user's behavior when they press to the home button
        appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

        //Open the setting application
        appiumDriver.activateApp("com.android.settings");

        //Go to wifi
        appiumDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text= 'Network & internet']")).click();

        //Turn the wifi off
        appiumDriver.findElement(AppiumBy.accessibilityId("Wi‑Fi")).click();

        //Turn on the wifi
        appiumDriver.findElement(AppiumBy.accessibilityId("Wi‑Fi")).click();

        //Re-launch the app
        appiumDriver.activateApp("com.wdiodemoapp");

        //Continue interacting with other elements on the app
        appiumDriver.findElement(AppiumBy.xpath("//*[@text='OK']")).click();

    }
}
