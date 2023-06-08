import actions.AppiumActions;
import assertions.Assert;
import hooks.DriverManager;
import hooks.TestBase;
import io.appium.java_client.AppiumBy;
import mobile_gestures.MobileGestures;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ToastMessageTest extends TestBase {
    private final By letsShop_btn = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");

    @Test
    public void validateToastMessage() {
        MobileGestures.click(letsShop_btn);
        System.out.println();
        Assert.assertTextToBe(AppiumActions.getToastMessage(), "Please enter your name");
//        System.out.println(DriverManager.getDriverInstance().findElement(enterName_ToastMessage).getAttribute("name"));
//        System.out.println(ElementActions.getAttribute(enterName_ToastMessage, "name"));
//        Assert.assertElementDisplayed(enterName_ToastMessage);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
