package com.seleniumassignment.common;


import com.seleniumassignment.utils.ProjectTestProps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Step
    public void setUp() {
        String browserName = ProjectTestProps.getBrowserName();
        if (ProjectTestProps.isBrowserStack()) {
            driver = DriverFactory.getBrowserStackDriver(browserName);
        }
        else {
            driver = DriverFactory.getBrowserDriver(browserName);
        }

        driver.manage().timeouts().implicitlyWait(Wait.EXPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @AfterMethod(alwaysRun = true)
    @Step
    public void endSession() throws Exception {
        driver.quit();
    }

}
