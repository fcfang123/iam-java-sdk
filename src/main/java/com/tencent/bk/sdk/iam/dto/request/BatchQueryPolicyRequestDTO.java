package com.tencent.bk.sdk.iam.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.action.ActionDTO;
import com.tencent.bk.sdk.iam.dto.resource.ResourceDTO;
import com.tencent.bk.sdk.iam.dto.SubjectDTO;

import lombok.Builder;
import lombok.Data;

/**
 * @author citruswang
 * @since 18/3/2020 16:45
 */
@Data
@Builder
public class BatchQueryPolicyRequestDTO {

    private String system;

    private SubjectDTO subject;

    @JsonProperty("actions")
    private List<ActionDTO> actionList;

    @JsonProperty("resources")
    private List<ResourceDTO> resourceList;

}
