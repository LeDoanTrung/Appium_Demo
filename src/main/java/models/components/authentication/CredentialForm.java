package models.components.authentication;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CredentialForm {
    private AndroidDriver appiumDriver;

    private By usernameTxtBox = AppiumBy.accessibilityId("input-email");
    private By passwordTxtBox = AppiumBy.accessibilityId("input-password");

    public CredentialForm(AndroidDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }


}
