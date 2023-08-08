package assertions;

import actions.ElementActions;
import actions.ElementState;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.openqa.selenium.By;
import org.testng.asserts.Assertion;

public class Assert {
    public static void assertElementCheckable(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(ElementState.isCheckable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not checkable");
            System.out.println("Element located with {" + elementLocated + "} is checkable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementChecked(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(ElementState.isChecked(elementLocated), "Element located with {" + elementLocated.toString() + "} is not checked");
            System.out.println("Element located with {" + elementLocated + "} is checked");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementClickable(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(ElementState.isClickable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not clickable");
            System.out.println("Element located with {" + elementLocated + "} is clickable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementEnabled(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(ElementState.isEnabled(elementLocated), "Element located with {" + elementLocated.toString() + "} is not enabled");
            System.out.println("Element located with {" + elementLocated + "} is enabled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementFocusable(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(ElementState.isFocusable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not focusable");
            System.out.println("Element located with {" + elementLocated + "} is focusable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementFocused(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(ElementState.isFocused(elementLocated), "Element located with {" + elementLocated.toString() + "} is not focused");
            System.out.println("Element located with {" + elementLocated + "} is focused");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementLongClickable(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(ElementState.isLongClickable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not long-clickable");
            System.out.println("Element located with {" + elementLocated + "} is long-clickable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementPassword(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(ElementState.isPassword(elementLocated), "Element located with {" + elementLocated.toString() + "} is not password");
            System.out.println("Element located with {" + elementLocated + "} is password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementScrollable(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(ElementState.isScrollable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not scrollable");
            System.out.println("Element located with {" + elementLocated + "} is scrollable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementSelected(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(ElementState.isSelected(elementLocated), "Element located with {" + elementLocated.toString() + "} is not selected");
            System.out.println("Element located with {" + elementLocated + "} is selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementDisplayed(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(ElementState.isDisplayed(elementLocated), "Element located with {" + elementLocated.toString() + "} is not displayed");
            System.out.println("Element located with {" + elementLocated + "} is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementText(@NotNull final By elementLocated, final String expectedText) {
        try {
            new Assertion().assertEquals(ElementActions.getText(elementLocated).trim(), expectedText.trim());
            System.out.println("Element text {" + ElementActions.getText(elementLocated).trim() + "} located with {" + elementLocated.toString() + "} is equals to the expected text {" + expectedText.trim() + "}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertTextToBe(@NotNull final String actualText, @NotNull final String expectedText) {
        try {
            new Assertion().assertEquals(actualText, expectedText);
            System.out.println("Actual text {" + actualText + "} is equals to the expected text {" + expectedText + "}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertAttributeToBe(@NotNull final String attribute, @NotNull final boolean expected) {
        try {
            new Assertion().assertEquals(attribute, expected);
            System.out.println("Attribute {" + attribute + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertAttributeToBe(@NotNull final String attribute, @NotNull final String expected) {
        try {
            new Assertion().assertEquals(attribute, expected);
            System.out.println("Attribute {" + attribute + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementAttributeToBe(@NotNull final By elementLocated, @NotNull final String attribute, @NotNull final boolean expected) {
        try {
            new Assertion().assertEquals(ElementActions.getAttribute(elementLocated, attribute), expected);
            System.out.println("Attribute {" + attribute + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementAttributeToBe(@NotNull final By elementLocated, @NotNull final String attribute, @NotNull final String value) {
        try {
            new Assertion().assertEquals(ElementActions.getAttribute(elementLocated, attribute), value);
            System.out.println("Attribute {" + attribute + "} is equals to the expected {" + value + "}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}