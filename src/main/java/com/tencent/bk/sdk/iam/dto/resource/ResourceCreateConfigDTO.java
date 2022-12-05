package com.tencent.bk.sdk.iam.dto.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResourceCreateConfigDTO {
    private List<ResourceActionDTO> actions;
    private String id;
    @JsonProperty("sub_resource_types")
    private List<ResourceCreateConfigAction> subResourceType;
}
