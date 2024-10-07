package test.apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utils.AppiumDriverEx;

import java.io.File;
import java.io.IOException;

public class TakingScreenShot {
    public static void main(String[] args) {

        //create a session first
        AndroidDriver appiumDriver = AppiumDriverEx.getAppiumDriver();

        //navigate to forms screen
        WebElement formLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
        formLabel.click();

        //click on toggle buttonIF it's off, turn it on
        WebElement switchElement = appiumDriver.findElement(MobileBy.AccessibilityId("switch"));
        WebElement switchTextElement = appiumDriver.findElement(MobileBy.AccessibilityId("switch-text"));
        if (switchTextElement.getText().equals("Click to turn the switch ON")) {
            switchElement.click();
        }

        //click on the dropdown menu -> select tbe first option
        WebElement dropdownElement = appiumDriver.findElement(MobileBy.AccessibilityId("Dropdown"));
        dropdownElement.click();

        WebElement firstOption = appiumDriver.findElement(MobileBy.xpath("//android.widget.CheckedTextView[@text='webdriver.io is awesome']"));
        firstOption.click();

        //taking a screenshot
        File formScreenBase64Data = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
        String formScreenFilePath = System.getProperty("user.dir") + "/screenshots/formScreen.png";

        try {
            FileUtils.copyFile(formScreenBase64Data, new File(formScreenFilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
