package test.apiLearning;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import utils.AppiumDriverEx;

import java.time.Duration;

public class PutAppInBackground {
    public static void main(String[] args) {
        //Init a session with Appium server
        AndroidDriver appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Go to login form
        WebElement loginLabel = appiumDriver.findElement(MobileBy.accessibilityId("Login"));
        loginLabel.click();

        WebElement username = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
        username.sendKeys("trungletest@gmail.com");

        WebElement password = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
        password.sendKeys("123456789");

        WebElement loginButton = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
        loginButton.click();

        //Put the app in the background => Simulate the user's behavior when they press to the home button
        appiumDriver.runAppInBackground(Duration.ofSeconds(5));

        //Gonna do some more steps here on another app
    }
}
