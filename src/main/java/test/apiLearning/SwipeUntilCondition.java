package test.apiLearning;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MobileCapabilityTypeEx;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class SwipeUntilCondition {
    public static void main(String[] args) throws InterruptedException {

        // Desired Capabilities để thiết lập thông tin cho session Appium
        AndroidDriver appiumDriver = null;

        //Set Desired Capabilities to send to Appium Server
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_VERSION, "11");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_PACKAGE, "com.wdiodemoapp");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.NEW_COMMAND_TIMEOUT, "60");

        //Setup the APpium Server URL to connect
        try {
            URL appiumServerURL = new URL("http://localhost:4723");

            appiumDriver = new AndroidDriver(appiumServerURL, desiredCapabilities);
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        // Click on the Swipe label
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(AppiumBy.accessibilityId("Swipe"))));
        WebElement swipeLabel = appiumDriver.findElement(AppiumBy.accessibilityId("Swipe"));
        swipeLabel.click();

        //Make sure I'm on the target screen
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Swipe horizontal\"]"))));

        // Get the mobile screen size
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        // Init start points and end points to touch and release
        int startX = (int) (screenWidth * 0.5);
        int endX = (int) (screenWidth * 0.1);
        int startY = (int) (screenHeight * 0.5);
        int endY = startY;

        // Perform the swipe to the left until I see the 'Extendable' card and the swipe time is less than 6
        int swipeTime = 0;

        while (swipeTime <=5){
            try {
                boolean isExtendableCardDisplayed = appiumDriver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"EXTENDABLE\"]")).isDisplayed();
                if (isExtendableCardDisplayed){
                    break;
                }
            } catch (Exception e) {
                // Perform the swipe to the left
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence swipeToLeft = new Sequence(finger, 1)
                        .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                        .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                        .addAction(new Pause(finger, Duration.ofMillis(300))) // Optional pause
                        .addAction(finger.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
                        .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                appiumDriver.perform(Collections.singletonList(swipeToLeft));
            }

            swipeTime += 1;

        }
    }
}
