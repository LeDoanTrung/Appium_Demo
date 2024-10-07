package test.apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.AppiumDriverEx;
import utils.MobileCapabilityTypeEx;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class RecordVideo {

    public static void main(String[] args) {
        //Init appium driver
        AndroidDriver appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Start recording
        ((CanRecordScreen) appiumDriver).startRecordingScreen();

        //To do something for the test to simulate the user's actions
        WebElement loginLabel = appiumDriver.findElement(MobileBy.accessibilityId("Login"));
        loginLabel.click();

        WebElement username = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
        username.sendKeys("trungletest@gmail.com");

        WebElement password = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
        password.sendKeys("123456789");

        WebElement loginButton = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
        loginButton.click();

        //Stop recording
        String video = ((CanRecordScreen) appiumDriver).stopRecordingScreen();

        //Save the video to the system
        byte[] decodeVideo = Base64.getMimeDecoder().decode(video);

        Path testVideoDir = Paths.get(System.getProperty("user.dir"), "/videos");
        try {
            Files.createDirectories(testVideoDir);
            // test-date.mp4
            Path videoFilePath = Paths.get(testVideoDir.toString(), String.format("%s-%d.%s", "test",  System.currentTimeMillis(), "mp4"));
            Files.write(videoFilePath, decodeVideo);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
