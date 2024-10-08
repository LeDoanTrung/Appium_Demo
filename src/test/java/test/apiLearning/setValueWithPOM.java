package test.apiLearning;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import models.pages.LoginPage;
import org.openqa.selenium.WebElement;
import utils.AppiumDriverEx;

public class setValueWithPOM {
    public static void main(String[] args) {
        //1. Launch the target app
        AndroidDriver appiumDriver = AppiumDriverEx.getAppiumDriver();

        //2. Click on the Login label
        WebElement loginLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
        loginLabel.click();

        //3. Login
        LoginPage loginPage = new LoginPage(appiumDriver);
        loginPage.login("trungletest@gmail.com", "123456789");


    }
}
