package com.tencent.bk.sdk.iam.dto.expression;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.constants.ExpressionOperationEnum;

import lombok.Data;

/**
 * @author citruswang
 * @since 16/3/2020 16:14
 */
@Data
public class ExpressionDTO {

    @JsonProperty("op")
    private ExpressionOperationEnum operator;

    private String field;

    private Object value;

    private List<ExpressionDTO> content;

    public boolean isEmpty() {
        return new ExpressionDTO().equals(this);
    }
}
