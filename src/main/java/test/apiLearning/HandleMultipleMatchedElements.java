package test.apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;

import java.time.Duration;
import java.util.List;

public class HandleMultipleMatchedElements {
    public static void main(String[] args) {
        //Start an Appium Server
        AppiumDriver appiumDriver = AppiumDriverEx.getAppiumDriver();
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(30));
        //Click on the Login label
        WebElement loginLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));

        loginLabel.click();

        //Explicit wait for the elements to be present
        wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.xpath("//*[@text='Login']"), 2));

        //Find elemenets with the same locator //*[@text='Login']`;
        List<WebElement> loginElements = appiumDriver.findElements(MobileBy.xpath("//*[@text='Login']"));
        System.out.println("How many elements matched: " + loginElements.size());

        final int LOGIN_TEXT_FROM_INDEX = 0;
        final int LOGIN_MENU_FROM_INDEX = 1;

        loginElements.get(LOGIN_TEXT_FROM_INDEX).click();
        System.out.println(loginElements.get(LOGIN_MENU_FROM_INDEX).getText());
    }
}
