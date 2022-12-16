package com.tencent.bk.sdk.iam.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.ResourceGroupsDTO;
import lombok.Data;

import java.util.List;

@Data
public class GroupPermissionDetailResponseDTO {
    private String id;
    @JsonProperty("expired_at")
    private Long expiredAt;
    private String name;
    @JsonProperty("resource_groups")
    private List<ResourceGroupsDTO> resourceGroups;
    private String type;
    private String description;
}
