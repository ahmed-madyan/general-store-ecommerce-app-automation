import actions.AppiumActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import mobile_gestures.MobileGestures;
import hooks.TestBase;

public class SignUpTest extends TestBase {
    private final By country_List = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
    private final String country = ("//android.widget.TextView[@text='{country}']");
    private final By dragDot_1 = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");
    private final By dragDot_2 = AppiumBy.id("io.appium.android.apis:id/drag_dot_2");
    private final By dragDot_3 = AppiumBy.id("io.appium.android.apis:id/drag_dot_2");
    private final By dragResultText = AppiumBy.id("io.appium.android.apis:id/drag_result_text");

    @Test
    public void signUp() {
        MobileGestures.click(country_List);
        AppiumActions.scrollIntoView(AppiumBy.xpath(country.replace("{country}", "Egypt")), "Egypt");
        MobileGestures.click(AppiumBy.xpath(country.replace("{country}", "Egypt")));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}