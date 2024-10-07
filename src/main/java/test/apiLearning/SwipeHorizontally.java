package test.apiLearning;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MobileCapabilityTypeEx;
import utils.SwipeAction;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SwipeHorizontally {
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
        WebDriverWait wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"))));
        WebElement swipeLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
        swipeLabel.click();

        //Make sure I'm on the target screen
        wait.until(ExpectedConditions.visibilityOf(appiumDriver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"Swipe horizontal\"]"))));

        //Swipe horizontally
        SwipeAction swipeAction = new SwipeAction(appiumDriver);
        swipeAction.swipeToRight(5);
        swipeAction.swipeToLeft(5);


    }
}
