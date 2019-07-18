package com.seleniumAssignment.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtils {


    public static void dbClick(WebDriver driver, WebElement el) {
        Actions actions = new Actions(driver);
        actions.doubleClick(el).perform();
    }
}