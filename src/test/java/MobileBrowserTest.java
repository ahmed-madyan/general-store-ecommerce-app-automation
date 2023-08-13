import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import readers.properties_reader.PropertiesDataManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileBrowserTest {

    private static AppiumDriverLocalService appiumService;
    private static AndroidDriver androidDriver;

    @BeforeTest
    protected static void localServiceInitialization() {
        //Build the Appium service
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\_VOIS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress(PropertiesDataManager.getProperty("executionIPAddress", PropertiesDataManager.Capability.EXECUTION))
                .usingPort(Integer.parseInt(PropertiesDataManager.getProperty("executionPort", PropertiesDataManager.Capability.EXECUTION)));
        //Start the server with the builder
        appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumService.start();
        //Initialize the driver and launch the app
        try {
            androidDriver =
                    new AndroidDriver(new URL(PropertiesDataManager.getProperty("appiumServerURL", PropertiesDataManager.Capability.EXECUTION)),
                            new UiAutomator2Options()
                                    .setDeviceName(PropertiesDataManager.getProperty("mobile_deviceName", PropertiesDataManager.Capability.MOBILE))
                                    .withBrowserName("Chrome")
//                                    .setCapability("appium:autodownloadEnabled", true)
                                    .setChromedriverExecutable("C:\\Users\\_VOIS\\Documents\\GitHub\\general-store-ecommerce-hybrid-app-automation\\src\\main\\resources\\app_binaries\\chromedriver.exe")
                    );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    protected static void localServiceTermination() {
        //Stop the server with the builder
        appiumService.stop();
    }

    @Test
    public void init() {
        androidDriver.get("https://google.com");
        androidDriver.quit();
    }
}
