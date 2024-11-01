package com.example.btnjava.Utils;

public class StringUtils {
    public static boolean isString(Object object){
        return object != null && !object.toString().isEmpty();
    }
}
