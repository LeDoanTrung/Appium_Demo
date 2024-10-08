package test.apiLearning;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import utils.AppiumDriverEx;

public class HandleToggleButton {
    public static void main(String[] args) {
        //Driver Instance
        AndroidDriver appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Click on the Form label
        WebElement formLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
        formLabel.click();

        //Get the Toggle Label before switching
        WebElement toggleLabel = appiumDriver.findElement(MobileBy.AccessibilityId("switch-text"));
        System.out.println("Toggle Label before switching: " + toggleLabel.getText());
        Assertions.assertThat(toggleLabel.getText()).isEqualTo("Click to turn the switch ON");

        //Get the toggle button and click on it
        WebElement switchButton = appiumDriver.findElement(MobileBy.AccessibilityId("switch"));
        switchButton.click();

        //Get the Toggle Label after switching
        System.out.println("Toggle Label before switching: " + toggleLabel.getText());
        Assertions.assertThat(toggleLabel.getText()).isEqualTo("Click to turn the switch OFF");

    }
}
