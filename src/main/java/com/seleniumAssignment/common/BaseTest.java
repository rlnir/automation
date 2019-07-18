package com.seleniumAssignment.common;


import com.seleniumAssignment.utils.ProjectTestProps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    @Step
    public void setUp() {
        String browserName = ProjectTestProps.getBrowserName();
        driver = DriverFactory.getBrowser(browserName);

        driver.manage().timeouts().implicitlyWait(Wait.EXPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @AfterTest
    @Step
    public void endSession() throws Exception {
        driver.quit();
    }

}
