import actions.MobileActions;
import assertions.Assert;
import driver_manager.DriverInitializer;
import io.appium.java_client.AppiumBy;
import mobile_gestures.MobileGestures;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ToastMessageTest extends DriverInitializer {
    private final By LETS_SHOP_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");

    @Test
    public void validateToastMessage() {
        MobileGestures.click(LETS_SHOP_BUTTON);
        Assert.assertTextToBe(MobileActions.getToastMessage(), "Please enter your name");
    }
}