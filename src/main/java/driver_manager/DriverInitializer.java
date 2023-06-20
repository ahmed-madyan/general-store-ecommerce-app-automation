package driver_manager;

import actions.ElementActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.reader_manager.properties_reader.ConfigUtils;
import driver_waits.Wait;

import java.time.Duration;

public class DriverInitializer {
    private static AndroidDriver androidDriver;

    @BeforeClass(alwaysRun = true)
    private void initDriver() {
        ConfigUtils.setConfigProperties();
        switch (ConfigUtils.getExecution_Platform()) {
            case "local" -> setDriver(DriverLocalServiceInitializer.localServiceInitialization());
            case "remote" -> setDriver(BrowserStackInitializer.browserStackInitialization());
            default -> {
                System.out.println("Kindly set the execution platform address.");
                throw new RuntimeException();
            }
        }
        Wait.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/splashscreen"));
        Assert.assertTrue(ElementActions.findElement(AppiumBy.id("com.androidsample.generalstore:id/splashscreen")).isDisplayed());
        DriverManager.getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass(alwaysRun = true)
    private void tearDownDriver() {
        //Tear the driver instance down
        DriverManager.quitDriver();
        if (ConfigUtils.getExecution_Platform().equals("local")) {
            //Stop the server with the builder
            DriverLocalServiceInitializer.localServiceTermination();
        }
    }

    protected static AndroidDriver getDriver() {
        return androidDriver;
    }

    private static void setDriver(AndroidDriver androidDriver) {
        DriverInitializer.androidDriver = androidDriver;
    }
}