package assertions;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HardAssert {
    public static void assertElementCheckable(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isCheckable(elementLocated), "Element is not checkable");
            System.out.println("Element is checkable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementChecked(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isChecked(elementLocated), "Element is not checked");
            System.out.println("Element is checked");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementClickable(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isClickable(elementLocated), "Element is not clickable");
            System.out.println("Element is clickable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementEnabled(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isEnabled(elementLocated), "Element is not enabled");
            System.out.println("Element is enabled");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementFocusable(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isFocusable(elementLocated), "Element is not focusable");
            System.out.println("Element is focusable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementFocused(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isFocused(elementLocated), "Element is not focused");
            System.out.println("Element is focused");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementLongClickable(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isLongClickable(elementLocated), "Element is not long-clickable");
            System.out.println("Element is long-clickable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementPassword(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isPassword(elementLocated), "Element is not password");
            System.out.println("Element is password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementScrollable(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isScrollable(elementLocated), "Element is not scrollable");
            System.out.println("Element is scrollable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementSelected(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isSelected(elementLocated), "Element is not selected");
            System.out.println("Element is selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void assertElementDisplayed(By elementLocated) {
        try {
            Assert.assertTrue(ElementState.isDisplayed(elementLocated), "Element is not displayed");
            System.out.println("Element is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}