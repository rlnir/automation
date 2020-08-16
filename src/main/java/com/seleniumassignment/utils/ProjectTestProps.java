package com.seleniumassignment.utils;

import com.seleniumassignment.common.TestProps;

public class ProjectTestProps {

    public static String getBrowserName() {
        return getProp("browserName");
    }

    public static String getBaseUrl() {
        return getProp("baseUrl");
    }

    public static boolean isBrowserStack() {
        return getProp("isBrowserStack").equals("true");
    }

    public static String getBrowserStackUser() {
        return getProp("browserStack.User");
    }

    public static String getBrowserStackKey() {
        return getProp("browserStack.Key");
    }

    public static String getBrowserStackHub() {
        return getProp("browserStack.Hub");
    }

    private  static String getProp(String prop) {
        return System.getProperty(prop, TestProps.get(prop));
    }
}
