import actions.AppiumActions;
import actions.ElementActions;
import assertions.Assert;
import driver_manager.DriverInitializer;
import io.appium.java_client.AppiumBy;
import mobile_gestures.MobileGestures;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.reader_manager.properties_reader.PropertiesDataManager;
import driver_waits.Waits;

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
    public void selectProduct() {
        fillForm();
        Waits.visibilityOfElementLocated(productsToolBar);
        if (PropertiesDataManager.getProperty("executionPlatform", PropertiesDataManager.Capability.EXECUTION_CAPABILITIES).equals("remote")) {
            AppiumActions.setPortraitMode();
        }
        AppiumActions.scrollIntoView("Air Jordan 9 Retro");
        for (int i = 0; i < ElementActions.findElements(productName).size() - 1; i++) {
            if (ElementActions.findElements(productName).get(i).getText().contains("Air Jordan 9 Retro")) {
//                AppiumActions.scrollIntoView("ADD TO CART");
                MobileGestures.click(ElementActions.findElements(addToCard).get(i));
            }
        }
        MobileGestures.click(cart);
        Assert.assertElementText(AppiumBy.id("com.androidsample.generalstore:id/productName"), "Air Jordan 9 Retro");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void fillForm() {
        ElementActions.sendKeys(name_TextFiled, "Ahmed");
        MobileGestures.click(male_RadioBtn);
        MobileGestures.click(letsShop_btn);
    }
}