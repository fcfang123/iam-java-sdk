package com.tencent.bk.sdk.iam.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.SubjectDTO;
import com.tencent.bk.sdk.iam.dto.action.ActionDTO;
import com.tencent.bk.sdk.iam.dto.resource.ResourceDTO;

import lombok.Data;

/**
 * @author citruswang
 * @since 19/6/2020 21:14
 */
@Data
public class QueryPolicyWithDependencyResourceRequestDTO {
    private String system;

    private SubjectDTO subject;

    @JsonProperty("action")
    private ActionDTO action;

    @JsonProperty("resources")
    private List<ResourceDTO> resourceList;

    @JsonProperty("ext_resources")
    private List<ResourceDTO> dependencyResource;
}
