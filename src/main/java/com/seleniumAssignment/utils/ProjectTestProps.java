package com.seleniumassignment.utils;

import com.seleniumassignment.common.TestProps;

public class ProjectTestProps {

    public static String getBrowserName() {
        return TestProps.get("browserName");
    }

    public static String getBaseUrl() {
        return TestProps.get("baseUrl");
    }

    public static String getChromeDriverVersion() {
        return TestProps.get("chromeDriverVersion");
    }

    public static boolean isBrowserStack() {
        return TestProps.get("isBrowserStack").equals("true");
    }

    public static String getBrowserStackUser() {
        return TestProps.get("browserStackUser");
    }

    public static String getBrowserStackKey() {
        return TestProps.get("browserStackKey");
    }

    public static String getBrowserStackHub() {
        return TestProps.get("browserStackHub");
    }
}
