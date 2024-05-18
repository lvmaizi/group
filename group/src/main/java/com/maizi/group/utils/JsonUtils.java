package com.maizi.group.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maizi.group.exception.UnknownException;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author create by fanwenhao
 */
@Slf4j
public class JsonUtils {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new UnknownException("object to json string exception");
        }
    }

    public static <T> T toObject(String json, Class<T> object) {
        try {
            return (T) objectMapper.readValue(json, object);
        } catch (JsonProcessingException e) {
            throw new UnknownException("json string to object exception");
        }
    }
}
