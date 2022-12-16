package com.tencent.bk.sdk.iam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResourceGroupsDTO {
    private String id;
    @JsonProperty("related_resource_types")
    private List<RelatedResourceTypesDTO> RelatedResourceTypesDTO;
}
