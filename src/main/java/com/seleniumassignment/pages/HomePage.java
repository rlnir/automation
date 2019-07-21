package com.seleniumassignment.pages;

import com.seleniumassignment.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    private static final String PAGE_PATH = "/";

    @FindBy(linkText = "React")
    private WebElement reactButton;

    private final WebDriver driver;

    public HomePage(final WebDriver driver) {
        super(driver);
        this.driver = driver;
        driver.manage().window().maximize();
    }

    public ReactExamplePage clickOnReact() {
        reactButton.click();
        return new ReactExamplePage(driver);
    }

    @Override
    public String getPagePath() {
        return PAGE_PATH;
    }

    @Override
    public BasePage previousPage() {
        return null;
    }
}
