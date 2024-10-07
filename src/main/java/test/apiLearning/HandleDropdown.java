package test.apiLearning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import utils.AppiumDriverEx;

public class HandleDropdown {
    public static void main(String[] args) {
        //Driver Instance
        AppiumDriver appiumDriver = AppiumDriverEx.getAppiumDriver();

        //Click on the Form label
        WebElement formLabel = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
        formLabel.click();

        //Get the toggle button and click on it
        WebElement dropdownElement = appiumDriver.findElement(MobileBy.AccessibilityId("Dropdown"));
        dropdownElement.click();

        //Select the first option
        WebElement firstOption = appiumDriver.findElement(MobileBy.xpath("//android.widget.CheckedTextView[@text='webdriver.io is awesome']"));
        firstOption.click();

        //Verify the selected option
        WebElement selectedOption = appiumDriver.findElement(MobileBy.xpath("//android.widget.EditText[@text=\"webdriver.io is awesome\"]"));
        Assertions.assertThat(selectedOption.isDisplayed()).isTrue();
        Assertions.assertThat(selectedOption.getText()).isEqualTo("webdriver.io is awesome");
        System.out.println("Dropdown Value:" + selectedOption.getText());

    }

}
