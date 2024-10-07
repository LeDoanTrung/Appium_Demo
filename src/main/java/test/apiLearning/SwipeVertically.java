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
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumDriverEx;
import utils.MobileCapabilityTypeEx;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class SwipeVertically {
    public static void main(String[] args) throws InterruptedException {

        //Create a session
        // Desired Capabilities để thiết lập thông tin cho session Appium
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_VERSION, "11");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_PACKAGE, "com.wdiodemoapp");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
        desiredCapabilities.setCapability(MobileCapabilityTypeEx.NEW_COMMAND_TIMEOUT, "60");

        // Khởi tạo AndroidDriver
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http://localhost:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        AndroidDriver appiumDriver = new AndroidDriver(appiumServerURL, desiredCapabilities);


        //Click on the Swipe label
        Thread.sleep(5000);
        WebElement swipeLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
        swipeLabel.click();

        //Make sure I'm on the target screen
//        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(1000));
//        Thread.sleep(5000);
//        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"Swipe horizontal\"]"))));

        //Get the mobile screen size
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        //Init start points and end points to touch and release
        int startX = screenWidth / 2;
        int endX = startX;
        int startY = (int) (screenHeight * 0.9);
        int endY = (int) (screenHeight * 0.1);

        //Perform the swipe
        Point startPoint = new Point(startX, startY);
        Point endPoint = new Point(endX, endY);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startPoint.x, startPoint.y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endPoint.x, endPoint.y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        appiumDriver.perform(Arrays.asList(swipe));

    }
}
