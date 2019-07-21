package com.seleniumassignment.common;

import com.seleniumassignment.utils.ProjectTestProps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

class DriverFactory {
    static WebDriver getBrowserDriver(String browserName) {
        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
        return driver;
    }

    static RemoteWebDriver getBrowserStackDriver(String browserName) {
        RemoteWebDriver driver;
        String url = "https://" + ProjectTestProps.getBrowserStackUser() + ":" + ProjectTestProps.getBrowserStackKey() + "@" + ProjectTestProps.getBrowserStackHub();
        try {
            switch (browserName) {
                case "chrome": default:
                    driver = new RemoteWebDriver(
                            new URL(url),
                            DesiredCapabilities.chrome()
                    );
                    return driver;
                case "firefox":
                    driver = new RemoteWebDriver(
                            new URL(url),
                            DesiredCapabilities.firefox()
                    );
                    return driver;
            }
        } catch (MalformedURLException e) {
            System.out.println("BS Url is incorrect");
            e.printStackTrace();
        }
        return null;
    }

}
