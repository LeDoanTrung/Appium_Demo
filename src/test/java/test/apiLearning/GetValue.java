package test.apiLearning;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import utils.AppiumDriverEx;

public class GetValue {
    public static void main(String[] args) {
        //Driver Instance
        AndroidDriver appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Set Desired Capabilities to send to Appium Server
        WebElement loginLabel = appiumDriver.findElement(MobileBy.accessibilityId("Login"));
        loginLabel.click();

        WebElement username = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
        username.sendKeys("trungletest@gmail.com");

        WebElement password = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
        password.sendKeys("123456789");

        WebElement loginButton = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
        loginButton.click();

        //Get the title form the dialog
        WebElement successTitle = appiumDriver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Success']"));
        if (successTitle.isDisplayed() && "Success".equals(successTitle.getText())) {
            System.out.println("Dialog title is displayed and the text is 'Success'");
        } else {
            System.out.println("Dialog title is not displayed or the text is not 'Success'");
        }
    }
}
