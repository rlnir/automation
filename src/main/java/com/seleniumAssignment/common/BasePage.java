package com.seleniumAssignment.common;

import com.seleniumAssignment.utils.ProjectTestProps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public abstract class BasePage {

    protected WebDriver driver;

    String PAGE_PATH;

    public BasePage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    protected void waitForElement(WebElement el) {
        new WebDriverWait(driver, Wait.EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(el));
    }

    protected void waitForElementWithText(WebElement el, String str) {
        new WebDriverWait(driver, Wait.EXPLICIT_WAIT).until(ExpectedConditions.textToBePresentInElement(el, str));
    }

    public abstract String getPagePath();

    public String getPageUrl() {
        return ProjectTestProps.getBaseUrl() + getPagePath();
    }

    public void goTo() {
        driver.get(getPageUrl());
    }
}
