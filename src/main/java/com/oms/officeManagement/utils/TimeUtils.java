package com.oms.officeManagement.utils;

public class TimeUtils {

    public static String getDuration(long startTime){
        long endTime = System.currentTimeMillis();
        return (float)(endTime - startTime) + "milliseconds";
    }
}
