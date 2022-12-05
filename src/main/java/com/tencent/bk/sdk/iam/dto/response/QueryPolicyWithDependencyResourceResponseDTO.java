package com.tencent.bk.sdk.iam.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.expression.ExpressionDTO;
import com.tencent.bk.sdk.iam.dto.resource.DependencyResourceInfoDTO;

import lombok.Data;

/**
 * @author citruswang
 * @since 19/6/2020 21:26
 */
@Data
public class QueryPolicyWithDependencyResourceResponseDTO {

    private ExpressionDTO expression;

    @JsonProperty("ext_resources")
    private List<DependencyResourceInfoDTO> dependencyResourceList;
}
