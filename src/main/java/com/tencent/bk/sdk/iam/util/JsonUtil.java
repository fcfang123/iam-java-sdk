package com.tencent.bk.sdk.iam.util;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author citruswang
 * @since 16/3/2020 17:44
 */
public class JsonUtil {
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz) throws IOException {
        return OBJECT_MAPPER.readValue(jsonStr, clazz);
    }

    public static <T> T fromJson(String jsonStr, TypeReference<T> typeReference) throws IOException {
        return OBJECT_MAPPER.readValue(jsonStr, typeReference);
    }

    public static String toJson(Object obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(obj);
    }
}
