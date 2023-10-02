package org.kms.com.groupup03.utils;

public class DataGenerator {
    public static String randomLoginName() {
        return "diemquynh" + String.valueOf(Math.random()*10000);
    }

    public static String randomPassword() {
        return String.valueOf(Math.random()*100000000);
    }
}
