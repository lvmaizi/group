package com.maizi.quan.common.utils;

import java.util.UUID;

/**
 * @Author create by fanwenhao
 */
public class IdGenerator {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
