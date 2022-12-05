package com.tencent.bk.sdk.iam.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author citruswang
 * @since 12/3/2020 21:52
 */
@Getter
@AllArgsConstructor
public enum AuthTypeEnum {

    /**
     * 不鉴权
     */
    NONE("none"),

    /**
     * Http Basic Auth
     */
    BASIC("basic"),

    /**
     * Http Digest Auth
     */
    DIGEST("digest"),

    /**
     * 签名鉴权
     */
    SIGN("signature"),
    ;


    @JsonValue
    private String name;

    @JsonCreator
    public static AuthTypeEnum parseType(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        for (AuthTypeEnum typeEnum : values()) {
            if (typeEnum.getName().equals(name)) {
                return typeEnum;
            }
        }
        return null;
    }
}
