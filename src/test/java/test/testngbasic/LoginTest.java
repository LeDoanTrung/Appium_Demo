package test.testngbasic;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.apiLearning.ExtentReportDemo;
import utils.AppiumDriverEx;

public class LoginTest extends ExtentReportDemo {

    @Test
    public  void LoginWithValidCredentials() {
        ExtentTest test = extent.createTest("LoginWithValidCredentials", "This test is to verify the login functionality with valid credentials");

        AndroidDriver appiumDriver = AppiumDriverEx.getAppiumDriver();

        test.log(Status.INFO, "Click on the Login label");
        WebElement loginLabel = appiumDriver.findElement(MobileBy.accessibilityId("Login"));
        loginLabel.click();

        test.log(Status.INFO, "Enter the username");
        WebElement username = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
        username.sendKeys("trungletest@gmail.com");

        test.log(Status.INFO, "Enter the password");
        WebElement password = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
        password.sendKeys("123456789");

        test.log(Status.INFO, "Click on the Login button");
        WebElement loginButton = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
        loginButton.click();

        test.log(Status.PASS, "Login successfully");
    }
}
