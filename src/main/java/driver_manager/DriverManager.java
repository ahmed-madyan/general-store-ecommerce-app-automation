package driver_manager;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.appium.java_client.android.AndroidDriver;

import java.util.Set;

public class DriverManager {
    public static AndroidDriver getDriverInstance() {
        return DriverInitializer.getDriver();
    }

    public static Set<String> getContextList() {
        return DriverManager.getDriverInstance().getContextHandles();
    }
    public static void switchContext(@NotNull final String context) {
        getDriverInstance().context(context);
    }

    protected static void quitDriver() {
        getDriverInstance().quit();
    }
}