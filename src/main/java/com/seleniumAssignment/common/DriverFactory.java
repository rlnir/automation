package com.seleniumAssignment.common;

import com.seleniumAssignment.utils.ProjectTestProps;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.MarionetteDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class DriverFactory {
    static WebDriver getBrowser(String browserName) {
        WebDriver driver;
        if (browserName != null && browserName.equals("chrome")) {
            String versionToDownload = ProjectTestProps.getChromeDriverVersion();
            if (versionToDownload != null) {
                ChromeDriverManager.getInstance().setup(versionToDownload);
            }
            else {
                ChromeDriverManager.getInstance().setup();
            }
            driver = new ChromeDriver();

        } else {
            MarionetteDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
