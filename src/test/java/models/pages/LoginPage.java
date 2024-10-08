package models.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private AndroidDriver appiumDriver;
    private By usernameTxtBox = AppiumBy.accessibilityId("input-email");
    private By passwordTxtBox = AppiumBy.accessibilityId("input-password");
    private By loginButton = AppiumBy.accessibilityId("button-LOGIN");

    public LoginPage(AndroidDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public WebElement getUsernameTxtBox() {
        return appiumDriver.findElement(usernameTxtBox);
    }

    public WebElement getPasswordTxtBox() {
        return appiumDriver.findElement(passwordTxtBox);
    }

    public WebElement getLoginButton() {
        return appiumDriver.findElement(loginButton);
    }

    public void enterUsername(String username) {
        getUsernameTxtBox().clear();
        getUsernameTxtBox().sendKeys(username);
    }

    public void enterPassword(String password) {
        getPasswordTxtBox().clear();
        getPasswordTxtBox().sendKeys(password);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
