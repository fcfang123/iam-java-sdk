package com.tencent.bk.sdk.iam.dto.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.SelectionDTO;
import com.tencent.bk.sdk.iam.dto.action.ActionDTO;
import com.tencent.bk.sdk.iam.dto.action.ActionGroupDTO;
import com.tencent.bk.sdk.iam.dto.resource.ResourceCreatorActionsDTO;
import com.tencent.bk.sdk.iam.dto.resource.ResourceTypeDTO;
import lombok.Data;

import java.util.List;

@Data
public class SystemFieldDTO {
    @JsonProperty("base_info")
    private SystemDTO baseInfo;

    @JsonProperty("resource_types")
    private List<ResourceTypeDTO> resourceType;

    private List<ActionDTO> actions;

    @JsonProperty("instance_selections")
    private List<SelectionDTO> instanceSelections;

    @JsonProperty("resource_creator_actions")
    private ResourceCreatorActionsDTO resourceCreatorActions;

    @JsonProperty("action_groups")
    private List<ActionGroupDTO> actionGroup;
}

