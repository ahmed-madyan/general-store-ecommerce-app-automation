import actions.AppiumActions;
import actions.ElementActions;
import assertions.Assert;
import driver_manager.DriverInitializer;
import driver_waits.FluentWaits;
import io.appium.java_client.AppiumBy;
import mobile_gestures.MobileGestures;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ProductsPageTest extends DriverInitializer {
    private final By productsToolBar = AppiumBy.id("com.androidsample.generalstore:id/toolbar_title");
    private final By productName = AppiumBy.id("com.androidsample.generalstore:id/productName");
    private final By addToCard = AppiumBy.id("com.androidsample.generalstore:id/productAddCart");
    private final By cart = AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart");
    private final By male_RadioBtn = AppiumBy.id("com.androidsample.generalstore:id/radioMale");
    private final By female_RadioBtn = AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    private final By country_List = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By name_TextFiled = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private final By letsShop_btn = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");

    @Test
    public void selectProduct() throws InterruptedException {
        fillForm();
        FluentWaits.visibilityOfElementLocated(productsToolBar);
        AppiumActions.scrollIntoView("Air Jordan 9 Retro");
        MobileGestures.scrollWithCoordinates(MobileGestures.Direction.DOWN);
        ElementActions.click(AppiumBy.xpath("//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='Air Jordan 9 Retro']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']"));
        MobileGestures.click(cart);
        Assert.assertElementText(AppiumBy.id("com.androidsample.generalstore:id/productName"), "Air Jordan 9 Retro");
        Thread.sleep(10000);
    }


    public void fillForm() {
        ElementActions.sendKeys(name_TextFiled, "Ahmed");
        MobileGestures.click(male_RadioBtn);
        MobileGestures.click(letsShop_btn);
    }
}