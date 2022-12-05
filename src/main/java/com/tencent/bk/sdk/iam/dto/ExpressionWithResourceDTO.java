package com.tencent.bk.sdk.iam.dto;

import java.util.List;
import java.util.Map;

import com.tencent.bk.sdk.iam.dto.expression.ExpressionDTO;

import lombok.Data;

/**
 * @author citruswang
 * @since 19/6/2020 21:11
 */
@Data
public class ExpressionWithResourceDTO {
    private ExpressionDTO expression;

    private Map<String, Map<String, List<InstanceDTO>>> instanceMap;
}
