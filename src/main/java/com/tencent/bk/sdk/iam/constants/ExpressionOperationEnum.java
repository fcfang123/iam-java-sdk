package com.tencent.bk.sdk.iam.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.tencent.bk.sdk.iam.dto.expression.ExpressionDTO;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author citruswang
 * @since 16/3/2020 16:17
 */
@Getter
@AllArgsConstructor
public enum ExpressionOperationEnum {

    /**
     * 与
     */
    AND("AND", Collections.singletonList(ExpressionDTO.class)),

    /**
     * 或
     */
    OR("OR", Collections.singletonList(ExpressionDTO.class)),

    /**
     * 等于
     */
    EQUAL("eq", Arrays.asList(new Class<?>[]{String.class, Number.class, Boolean.class})),

    /**
     * 不等于
     */
    NOT_EQUAL("not_eq", Arrays.asList(new Class<?>[]{String.class, Number.class, Boolean.class})),

    /**
     * 在列表内
     */
    IN("in", Arrays.asList(new Class<?>[]{String.class, Number.class, Boolean.class})),

    /**
     * 不在列表内
     */
    NOT_IN("not_in", Arrays.asList(new Class<?>[]{String.class, Number.class, Boolean.class})),

    /**
     * 字符串包含
     */
    CONTAIN("contains", Collections.singletonList(String.class)),

    /**
     * 字符串不包含
     */
    NOT_CONTAIN("not_contains", Collections.singletonList(String.class)),

    /**
     * 字符串开头是
     */
    START_WITH("starts_with", Collections.singletonList(String.class)),

    /**
     * 字符串开头不是
     */
    NOT_START_WITH("not_starts_with", Collections.singletonList(String.class)),

    /**
     * 字符串结尾是
     */
    END_WITH("ends_with", Collections.singletonList(String.class)),

    /**
     * 字符串结尾不是
     */
    NOT_END_WITH("not_ends_with", Collections.singletonList(String.class)),

    /**
     * 小于
     */
    LESS_THEN("lt", Collections.singletonList(Number.class)),

    /**
     * 小于等于
     */
    LESS_THAN_OR_EQUAL("lte", Collections.singletonList(Number.class)),

    /**
     * 大于
     */
    GREATER_THAN("gt", Collections.singletonList(Number.class)),

    /**
     * 大于等于
     */
    GREATER_THAN_OR_EQUAL("gte", Collections.singletonList(Number.class)),

    /**
     * 任意，表示匹配所有资源
     */
    ANY("any", Collections.singletonList(String.class)),

    STRING_CONTAINS("string_contains", Collections.singletonList(String.class))
    ;

    @JsonValue
    private String operator;

    private List<Class<?>> supportClass;

    @JsonCreator
    public static ExpressionOperationEnum parseOperator(String operatorStr) {
        if (StringUtils.isBlank(operatorStr)) {
            return null;
        }
        for (ExpressionOperationEnum operator : values()) {
            if (operator.getOperator().equals(operatorStr)) {
                return operator;
            }
        }
        return null;
    }

}
