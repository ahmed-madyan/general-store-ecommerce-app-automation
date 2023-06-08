import actions.AppiumActions;
import actions.ElementActions;
import assertions.Assert;
import hooks.TestBase;
import io.appium.java_client.AppiumBy;
import mobile_gestures.MobileGestures;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignUpFormTest extends TestBase {
    private final By country_List = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By name_TextFiled = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private final By male_RadioBtn = AppiumBy.id("com.androidsample.generalstore:id/radioMale");
    private final By female_RadioBtn = AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    private final By letsShop_btn = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");

    @Test
    public void validateFormElements() {
        Assert.assertElementDisplayed(country_List);
        Assert.assertElementEnabled(country_List);
        Assert.assertElementDisplayed(name_TextFiled);
        Assert.assertElementEnabled(name_TextFiled);
        Assert.assertElementClickable(name_TextFiled);
        Assert.assertElementDisplayed(male_RadioBtn);
        Assert.assertElementDisplayed(female_RadioBtn);
        Assert.assertElementDisplayed(letsShop_btn);
    }

    @Test(dependsOnMethods = "validateFormElements")
    public void fillForm() {
        MobileGestures.click(country_List);
        String country = ("//android.widget.TextView[@text='{country}']");
        AppiumActions.scrollIntoView("Egypt");
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