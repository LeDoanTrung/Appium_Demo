package test.testngbasic;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.AppiumDriverEx;

public class LoginTest {

    @Test
    public  void LoginWithValidCredentials() {
        AndroidDriver appiumDriver = AppiumDriverEx.getAppiumDriver();

        WebElement loginLabel = appiumDriver.findElement(MobileBy.accessibilityId("Login"));
        loginLabel.click();

        WebElement username = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
        username.sendKeys("trungletest@gmail.com");

        WebElement password = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
        password.sendKeys("123456789");

        WebElement loginButton = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
        loginButton.click();
    }
}
