package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import utils.AppiumDriverEx;


public class clickOnElement {
    public static void main(String[] args) {
        //Driver Instance
        AppiumDriver appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Set Desired Capabilities to send to Appium Server
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
