package com.example.rebuytest.utils;

public class LoginAndRegisterUtil {

    private static String username = null;

    private static String password = null;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        LoginAndRegisterUtil.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        LoginAndRegisterUtil.password = password;
    }
}
