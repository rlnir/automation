package com.seleniumAssignment.utils;

import com.seleniumAssignment.common.TestProps;

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
}
