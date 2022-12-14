package com.tencent.bk.sdk.iam.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OkhttpUtils {

    public static String joinParams(Map<String, String> params) throws UnsupportedEncodingException {
        List<String> paramItem = new ArrayList<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            paramItem.add(entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return StringUtils.join(paramItem.toArray(), "&");
    }

    public static HashMap objectToMap(Object object) {
        return JSONObject.parseObject(JSONObject.toJSONString(object), HashMap.class);
    }
}
