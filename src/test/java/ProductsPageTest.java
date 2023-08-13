import actions.ElementActions;
import actions.KeyEvents;
import actions.MobileActions;
import actions.TouchActions;
import assertions.Assertions;
import driver_manager.DriverInitializer;
import driver_manager.DriverManager;
import io.appium.java_client.AppiumBy;
import mobile_gestures.MobileGestures;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import waits.Waits;

public class ProductsPageTest extends DriverInitializer {
    private final By PRODUCT_TOOL_BAR = AppiumBy.id("com.androidsample.generalstore:id/toolbar_title");
    private final By PRODUCT_NAME = AppiumBy.id("com.androidsample.generalstore:id/productName");
    private final By ADD_TO_CART_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/productAddCart");
    private final By CART_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart");
    private final By MALE_RADIO_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/radioMale");
    private final By FEMALE_RADIO_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    private final By COUNTRY_LIST = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By NAME_TEXT_BOX = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private final By LETS_SHOP_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");
    private final By TOTAL_AMOUNT_TEXT = AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl");
    private final By TERMS_AND_CONDITIONS_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/termsButton");
    private final By TERMS_AND_CONDITIONS_CLOSE = AppiumBy.id("android:id/button1");
    private final By SEND_EMAILS_CHECK_BOX = AppiumBy.className("android.widget.CheckBox");
    private final By COMPLETE_PURCHASE_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/btnProceed");
    @Test
    public void addProductsToCart() throws InterruptedException {
        fillForm();
        Waits.fluentlyWait().visibilityOfElementLocated(PRODUCT_TOOL_BAR);
        addToCard("Air Jordan 9 Retro");
        addToCard("Air Jordan 9 Retro");
        float airJordan9_productPrice = getProductPrice("Air Jordan 9 Retro");
        addToCard("Nike SFB Jungle");
        float nikeSFBJungle_productPrice = getProductPrice("Nike SFB Jungle");
        addToCard("Air Jordan 4 Retro");
        float airJordan4_productPrice = getProductPrice("Air Jordan 4 Retro");
        Assertions.hardAssert().elementDisplayed(ADD_TO_CART_BUTTON);
        MobileGestures.click(CART_BUTTON);
        Assertions.hardAssert().elementAttributeToBe(PRODUCT_TOOL_BAR, "text", "Cart");
        Assertions.hardAssert().elementText(PRODUCT_NAME, "Air Jordan 9 Retro");
        float expectedTotalAmount = airJordan9_productPrice + nikeSFBJungle_productPrice + airJordan4_productPrice;
        System.out.println("Expected total amount: " + expectedTotalAmount);
        Assertions.hardAssert().elementText(TOTAL_AMOUNT_TEXT, ("$ " + expectedTotalAmount).trim());
        MobileGestures.longClick(TERMS_AND_CONDITIONS_BUTTON, 1);
        MobileGestures.click(TERMS_AND_CONDITIONS_CLOSE);
        MobileGestures.click(SEND_EMAILS_CHECK_BOX);
        MobileGestures.click(COMPLETE_PURCHASE_BUTTON);
        Thread.sleep(5000);
        System.out.println(DriverManager.getContextHandles());
        DriverManager.switchContext("WEBVIEW_com.androidsample.generalstore");
        System.out.println(DriverManager.getDriverInstance().getCurrentUrl());
        KeyEvents.keyBack();
        DriverManager.switchContext("NATIVE_APP");
        fillForm();
    }

    public void fillForm() {
        Waits.fluentlyWait().visibilityOfElementLocated(COUNTRY_LIST);
        Assertions.hardAssert().elementDisplayed(COUNTRY_LIST);
        Assertions.hardAssert().elementDisplayed(FEMALE_RADIO_BUTTON);
        ElementActions.sendKeys(NAME_TEXT_BOX, "Ahmed");
        MobileGestures.click(MALE_RADIO_BUTTON);
        MobileGestures.click(LETS_SHOP_BUTTON);
    }

    public void addToCard(String product) {
        TouchActions.scrollToElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + product + "']"));
        if (ElementActions.getText(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + product + "']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).equalsIgnoreCase("ADD TO CART"))
            MobileGestures.click(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + product + "']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']"));
        else System.out.println("Product: " + product + " already added to the cart");
    }

    public float getProductPrice(String product) {
        TouchActions.scrollToElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + product + "']"));
        String price = ElementActions.getText(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + product + "']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']")).substring(1);
        float productPrice = Float.parseFloat(price);
        System.out.println("Product: " + product + " price is: " + productPrice);
        return productPrice;
    }
}