package com.dek.utils;

import java.util.UUID;

public class UUIDUtil {

    private UUIDUtil(){}

    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
