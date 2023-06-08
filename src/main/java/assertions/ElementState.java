package assertions;

import actions.ElementActions;
import org.openqa.selenium.By;
import webdriver_waits.Waits;

public class ElementState {

    public static boolean isCheckable(By elementLocated) {
        boolean checkable = false;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.getAttribute(elementLocated, "checkable").equals("true")) {
                checkable = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkable;
    }

    public static boolean isChecked(By elementLocated) {
        boolean checked = false;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.getAttribute(elementLocated, "checked").equals("true")) {
                checked = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checked;
    }

    public static boolean isClickable(By elementLocated) {
        boolean clickable = false;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.getAttribute(elementLocated, "clickable").equals("true")) {
                clickable = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clickable;
    }

    public static boolean isEnabled(By elementLocated) {
        boolean enabled = false;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).isEnabled()) {
                enabled = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enabled;
    }

    public static boolean isFocusable(By elementLocated) {
        boolean focusable = false;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).getAttribute("focusable").equals("true")) {
                focusable = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return focusable;
    }

    public static boolean isFocused(By elementLocated) {
        boolean focused = false;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).getAttribute("focused").equals("true")) {
                focused = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return focused;
    }

    public static boolean isLongClickable(By elementLocated) {
        boolean longClickable = false;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).getAttribute("long-clickable").equals("true")) {
                longClickable = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return longClickable;
    }

    public static boolean isPassword(By elementLocated) {
        boolean password = false;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).getAttribute("password").equals("true")) {
                password = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    public static boolean isScrollable(By elementLocated) {
        boolean scrollable = false;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).getAttribute("scrollable").equals("true")) {
                scrollable = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scrollable;
    }

    public static boolean isSelected(By elementLocated) {
        boolean selected = false;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).isSelected()) {
                selected = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selected;
    }

    public static boolean isDisplayed(By elementLocated) {
        boolean displayed = false;
        try {
            Waits.visibilityOfElementLocated(elementLocated);
            if (ElementActions.findElement(elementLocated).isDisplayed()) {
                displayed = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return displayed;
    }
}