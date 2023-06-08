import actions.AppiumActions;
import actions.ElementActions;
import assertions.Assertion;
import hooks.TestBase;
import io.appium.java_client.AppiumBy;
import mobile_gestures.MobileGestures;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignUpTest extends TestBase {
    private final By country_List = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By name_TextFiled = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private final By male_RadioBtn = AppiumBy.id("com.androidsample.generalstore:id/radioMale");
    private final By female_RadioBtn = AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    private final By letsShop_btn = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");

    @Test
    public void validateFormElements() {
        Assertion.assertElementDisplayed(country_List);
        Assertion.assertElementEnabled(country_List);
        Assertion.assertElementDisplayed(name_TextFiled);
        Assertion.assertElementEnabled(name_TextFiled);
        Assertion.assertElementClickable(name_TextFiled);
        Assertion.assertElementDisplayed(male_RadioBtn);
        Assertion.assertElementDisplayed(female_RadioBtn);
        Assertion.assertElementDisplayed(letsShop_btn);
    }

    @Test

    public void signUp() {
        MobileGestures.click(country_List);
        String country = ("//android.widget.TextView[@text='{country}']");
        AppiumActions.scrollIntoView(AppiumBy.xpath(country.replace("{country}", "Egypt")), "Egypt");
        MobileGestures.click(AppiumBy.xpath(country.replace("{country}", "Egypt")));
        ElementActions.sendKeys(name_TextFiled, "Ahmed");
        MobileGestures.click(letsShop_btn);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}