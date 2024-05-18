package com.maizi.quan.common.utils;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * @Author create by fanwenhao
 */
public class Timestamps {
    public static Timestamp now() {
        return Timestamp.from(Instant.now());
    }

    public static Timestamp plus(Timestamp timestamp, long millisecond) {
        return new Timestamp(timestamp.getTime() + millisecond);
    }
}
