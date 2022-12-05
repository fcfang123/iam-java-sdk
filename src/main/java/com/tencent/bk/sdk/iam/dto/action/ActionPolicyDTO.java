package com.tencent.bk.sdk.iam.dto.action;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.expression.ExpressionDTO;

import lombok.Data;

/**
 * @author citruswang
 * @since 18/3/2020 16:54
 */
@Data
public class ActionPolicyDTO {
    @JsonProperty("action_id")
    private String actionId;

    private ExpressionDTO condition;
}
