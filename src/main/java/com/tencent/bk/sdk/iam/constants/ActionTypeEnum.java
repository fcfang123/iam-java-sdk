package com.tencent.bk.sdk.iam.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author citruswang
 * @since 16/3/2020 15:22
 */
@Getter
@AllArgsConstructor
public enum ActionTypeEnum {
    /**
     * 创建
     */
    CREATE("create"),

    /**
     * 删除
     */
    DELETE("delete"),

    /**
     * 查看
     */
    VIEW("view"),

    /**
     * 编辑
     */
    EDIT("edit"),

    /**
     * 列表
     */
    LIST("list"),
    /**
     * 使用
     */
    USE("use"),
    /**
     * 管理
     */
    MANAGE("manage"),
    /**
     * 未分类
     */
    UNDEFINED("")
    ;

    @JsonValue
    private String type;

    @JsonCreator
    public static ActionTypeEnum parseType(String type) {
        if (StringUtils.isBlank(type)) {
            return null;
        }
        for (ActionTypeEnum typeEnum : values()) {
            if (typeEnum.getType().equals(type)) {
                return typeEnum;
            }
        }
        return null;
    }

}
