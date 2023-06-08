package assertions;

import org.openqa.selenium.By;

public class SoftAssert {
    static org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();

    public static void assertElementCheckable(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isCheckable(elementLocated), "Element is not checkable");
            softAssert.assertAll();
            System.out.println("Element is checkable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementChecked(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isChecked(elementLocated), "Element is not checked");
            softAssert.assertAll();
            System.out.println("Element is checked");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementClickable(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isClickable(elementLocated), "Element is not clickable");
            softAssert.assertAll();
            System.out.println("Element is clickable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementEnabled(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isEnabled(elementLocated), "Element is not enabled");
            softAssert.assertAll();
            System.out.println("Element is enabled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementFocusable(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isFocusable(elementLocated), "Element is not focusable");
            softAssert.assertAll();
            System.out.println("Element is focusable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementFocused(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isFocused(elementLocated), "Element is not focused");
            softAssert.assertAll();
            System.out.println("Element is focused");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementLongClickable(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isLongClickable(elementLocated), "Element is not long-clickable");
            softAssert.assertAll();
            System.out.println("Element is long-clickable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementPassword(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isPassword(elementLocated), "Element is not password");
            softAssert.assertAll();
            System.out.println("Element is password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementScrollable(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isScrollable(elementLocated), "Element is not scrollable");
            softAssert.assertAll();
            System.out.println("Element is scrollable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementSelected(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isSelected(elementLocated), "Element is not selected");
            softAssert.assertAll();
            System.out.println("Element is selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementDisplayed(By elementLocated) {
        try {
            softAssert.assertTrue(ElementState.isDisplayed(elementLocated), "Element is not displayed");
            softAssert.assertAll();
            System.out.println("Element is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}