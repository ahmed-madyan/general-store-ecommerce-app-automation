package actions;

import hooks.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import webdriver_waits.Waits;

public class AppiumActions {
    public static void scrollIntoView(String elementText) {
        try {
            DriverManager.getDriverInstance().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"));"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scrollIntoElementView(By elementLocated, String elementText) {
        try {
            DriverManager.getDriverInstance().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"));"));
            Waits.visibilityOfElementLocated(elementLocated);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setClipboardText(String text) {
        try {
            DriverManager.getDriverInstance().setClipboardText(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getClipboardText() {
        String clipboardText = null;
        try {
            clipboardText = DriverManager.getDriverInstance().getClipboardText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clipboardText;
    }

    public static void rotateRight() {
        try {
            DriverManager.getDriverInstance().rotate(new DeviceRotation(0, 0, 90));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void rotateLeft() {
        try {
            DriverManager.getDriverInstance().rotate(new DeviceRotation(0, 0, 270));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void rotateCustomAngle(int angle) {
        try {
            DriverManager.getDriverInstance().rotate(new DeviceRotation(0, 0, angle));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setPortrait() {
        try {
            DriverManager.getDriverInstance().rotate(ScreenOrientation.PORTRAIT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getToastMessage() {
        String text = null;
        try {
            text = DriverManager.getDriverInstance().findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}