package com.tencent.bk.sdk.iam.util;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpUtils {
    // 用于拼接Http请求路径的参数
    public static String joinParams(Object object) throws IOException {
        if (object == null)
            throw new RuntimeException("Object cannot be null !");
        HashMap<String, String> params = JsonUtil.fromJson(JsonUtil.toJson(object), new TypeReference<HashMap<String, String>>() {
        });
        List<String> paramItem = new ArrayList<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            paramItem.add(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return StringUtils.join(paramItem.toArray(), "&");
    }
}
