import actions.MobileActions;
import actions.ElementActions;
import assertions.Assertions;
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
        Assertions.hardAssert().elementDisplayed(COUNTRY_LIST);
        Assertions.hardAssert().elementEnabled(COUNTRY_LIST);
        Assertions.hardAssert().elementDisplayed(NAME_TEXT_BOX);
        Assertions.hardAssert().elementEnabled(NAME_TEXT_BOX);
        Assertions.hardAssert().elementClickable(NAME_TEXT_BOX);
        Assertions.hardAssert().elementDisplayed(MALE_RADIO_BUTTON);
        Assertions.hardAssert().elementDisplayed(FEMALE_RADIO_BUTTON);
        Assertions.hardAssert().elementDisplayed(LETS_SHOP_BUTTON);
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