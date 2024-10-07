package test.apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import utils.AppiumDriverEx;

public class setValue {
    public static void main(String[] args) {
        //1. Launch the target app
        AndroidDriver appiumDriver = AppiumDriverEx.getAppiumDriver();
        //2. Click on the Login label
        WebElement loginLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
        loginLabel.click();
        //3. Enter the username
        WebElement usernameTxtBox = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
        usernameTxtBox.sendKeys("trungletest@gmail.com");
        //4. Enter the password
        WebElement passwordTxtBox = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
        passwordTxtBox.sendKeys("123456789");
        //5. Click on the Login button
        WebElement loginButton = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
        loginButton.click();
    }
}
