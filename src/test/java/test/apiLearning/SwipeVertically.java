package test.apiLearning;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;
import utils.SwipeAction;

import java.time.Duration;

public class SwipeVertically {
    public static void main(String[] args) throws InterruptedException {

        //Create a session
        AndroidDriver appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Click on the Swipe label
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"))));
        WebElement swipeLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
        swipeLabel.click();

        //Make sure I'm on the target screen
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"Swipe horizontal\"]"))));

        SwipeAction swipeAction = new SwipeAction(appiumDriver);
        swipeAction.swipeToBottom(2);
        swipeAction.swipeToTop(2);
    }
}
