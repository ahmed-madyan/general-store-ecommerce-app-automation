import actions.ElementActions;
import actions.MobileActions;
import assertions.Assert;
import driver_manager.DriverInitializer;
import driver_waits.FluentWaits;
import io.appium.java_client.AppiumBy;
import mobile_gestures.MobileGestures;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.reader_manager.properties_reader.PropertiesConfigurations;

import java.time.Duration;

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

    @Test
    public void addProductsToCart() {
        fillForm();
        FluentWaits.visibilityOfElementLocated(PRODUCT_TOOL_BAR);
        addToCard("Air Jordan 9 Retro");
        addToCard("Air Jordan 9 Retro");
        double airJordan_productPrice = getProductPrice("Air Jordan 9 Retro");
        addToCard("Nike SFB Jungle");
        double nikeSFBJungle_productPrice = getProductPrice("Nike SFB Jungle");
        MobileGestures.click(CART_BUTTON);
        Assert.assertElementAttributeToBe(PRODUCT_TOOL_BAR, "text", "Cart");
        Assert.assertElementText((PRODUCT_NAME), "Air Jordan 9 Retro");
        double expectedTotalAmount = airJordan_productPrice + nikeSFBJungle_productPrice;
        Assert.assertElementText(TOTAL_AMOUNT_TEXT, ("$ " + expectedTotalAmount).trim());
        MobileGestures.longClick(TERMS_AND_CONDITIONS_BUTTON, 1);
        MobileGestures.click(TERMS_AND_CONDITIONS_CLOSE);
    }

    public void fillForm() {
        ElementActions.sendKeys(NAME_TEXT_BOX, "Ahmed");
        MobileGestures.click(MALE_RADIO_BUTTON);
        MobileGestures.click(LETS_SHOP_BUTTON);
    }

    public void addToCard(String product) {
        MobileActions.scrollIntoView(product);
        if (PropertiesConfigurations.getExecution_Platform().equalsIgnoreCase("local"))
            MobileGestures.scrollWithCoordinates(MobileGestures.Direction.DOWN);
        if (ElementActions.getText(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + product + "']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).equalsIgnoreCase("ADD TO CART"))
            MobileGestures.click(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + product + "']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']"));
        else System.out.println("Product: " + product + " already added to the cart");
    }

    public double getProductPrice(String product) {
        MobileActions.scrollIntoView(product);
        String price = ElementActions.getText(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + product + "']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']")).substring(1);
        double productPrice = Double.parseDouble(price);
        System.out.println("Product: " + product + " price is: " + productPrice);
        return productPrice;
    }
}