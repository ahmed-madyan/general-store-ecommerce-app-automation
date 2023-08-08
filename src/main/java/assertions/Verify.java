package assertions;

import actions.ElementState;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class Verify {
    public Verify() {
    }

    static SoftAssert softAssert = new SoftAssert();

    public static void assertElementCheckable(@NotNull final By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isCheckable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not checkable");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is checkable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementChecked(@NotNull final By  elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isChecked(elementLocated), "Element located with {" + elementLocated.toString() + "} is not checked");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is checked");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementClickable(@NotNull final By  elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isClickable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not clickable");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is clickable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementEnabled(@NotNull final By  elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isEnabled(elementLocated), "Element located with {" + elementLocated.toString() + "} is not enabled");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is enabled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementFocusable(@NotNull final By  elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isFocusable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not focusable");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is focusable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementFocused(@NotNull final By  elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isFocused(elementLocated), "Element located with {" + elementLocated.toString() + "} is not focused");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is focused");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementLongClickable(@NotNull final By  elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isLongClickable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not long-clickable");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is long-clickable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementPassword(@NotNull final By  elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isPassword(elementLocated), "Element located with {" + elementLocated.toString() + "} is not password");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementScrollable(@NotNull final By  elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isScrollable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not scrollable");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is scrollable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementSelected(@NotNull final By  elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isSelected(elementLocated), "Element located with {" + elementLocated.toString() + "} is not selected");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementDisplayed(@NotNull final By  elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isDisplayed(elementLocated), "Element located with {" + elementLocated.toString() + "} is not displayed");
            softAssert.assertAll();
            System.out.println("Element located with {" + elementLocated.toString() + "} is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}