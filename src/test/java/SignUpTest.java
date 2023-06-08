import actions.AppiumActions;
import actions.ElementActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import mobile_gestures.MobileGestures;
import hooks.TestBase;

public class SignUpTest extends TestBase {
    private final By country_List = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By name_TextFiled = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private final By letsShop_btn = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");

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