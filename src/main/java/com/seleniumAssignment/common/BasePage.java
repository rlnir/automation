package com.seleniumAssignment.common;

import com.seleniumAssignment.utils.ProjectTestProps;
import io.qameta.allure.Step;
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

    public void waitForElement(WebElement el) {
        new WebDriverWait(driver, Wait.EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(el));
    }

    public void waitForElementWithText(WebElement el, String str) {
        new WebDriverWait(driver, Wait.EXPLICIT_WAIT).until(ExpectedConditions.textToBePresentInElement(el, str));
    }

    public abstract String getPagePath();

    public String getPageUrl() {
        return ProjectTestProps.getBaseUrl() + getPagePath();
    }

    @Step
    public void goTo() {
        driver.get(getPageUrl());
    }

    @Step
    public BasePage clickBack(){
        driver.navigate().back();
        return previousPage();
    }

    public abstract BasePage previousPage();
}
