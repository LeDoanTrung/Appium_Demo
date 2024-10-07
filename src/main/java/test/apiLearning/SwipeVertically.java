package test.apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;
import utils.MobileCapabilityTypeEx;
import utils.SwipeAction;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

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
