package com.tencent.bk.sdk.iam.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author citruswang
 * @since 20/3/2020 17:56
 */
@Getter
@AllArgsConstructor
public enum CallbackMethodEnum {
    /**
     *
     */
    LIST_ATTRIBUTE("list_attr"),
    /**
     *
     */
    LIST_ATTRIBUTE_VALUE("list_attr_value"),
    /**
     *
     */
    LIST_INSTANCE("list_instance"),
    /**
     *
     */
    FETCH_INSTANCE_INFO("fetch_instance_info"),
    /**
     *
     */
    LIST_INSTANCE_BY_POLICY("list_instance_by_policy"),
    /**
     *
     */
    SEARCH_INSTANCE("search_instance")
    ;

    @JsonValue
    private String method;

    @JsonCreator
    private CallbackMethodEnum parseMethod(String method) {
        if (StringUtils.isBlank(method)) {
            return null;
        }
        for (CallbackMethodEnum callbackMethod : values()) {
            if (callbackMethod.getMethod().equals(method)) {
                return callbackMethod;
            }
        }
        return null;
    }
}
