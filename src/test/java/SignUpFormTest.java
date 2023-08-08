import actions.MobileActions;
import actions.ElementActions;
import assertions.Assert;
import driver_manager.DriverInitializer;
import io.appium.java_client.AppiumBy;
import mobile_gestures.MobileGestures;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignUpFormTest extends DriverInitializer {
    private final By COUNTRY_LIST = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By NAME_TEXT_BOX = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private final By MALE_RADIO_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/radioMale");
    private final By FEMALE_RADIO_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    private final By LETS_SHOP_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");

    @Test
    public void validateFormElements() {
        Assert.assertElementDisplayed(COUNTRY_LIST);
        Assert.assertElementEnabled(COUNTRY_LIST);
        Assert.assertElementDisplayed(NAME_TEXT_BOX);
        Assert.assertElementEnabled(NAME_TEXT_BOX);
        Assert.assertElementClickable(NAME_TEXT_BOX);
        Assert.assertElementDisplayed(MALE_RADIO_BUTTON);
        Assert.assertElementDisplayed(FEMALE_RADIO_BUTTON);
        Assert.assertElementDisplayed(LETS_SHOP_BUTTON);
    }

    @Test(dependsOnMethods = "validateFormElements")
    public void fillForm() {
        MobileGestures.click(COUNTRY_LIST);
        String country = ("//android.widget.TextView[@text='{country}']");
        MobileActions.scrollIntoView("Egypt");
        MobileGestures.click(AppiumBy.xpath(country.replace("{country}", "Egypt")));
        ElementActions.sendKeys(NAME_TEXT_BOX, "Ahmed");
        MobileGestures.click(LETS_SHOP_BUTTON);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}