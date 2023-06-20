/*
 * TencentBlueKing is pleased to support the open source community by making
 * 蓝鲸智云-权限中心Java SDK(iam-java-sdk) available.
 * Copyright (C) 2017-2021 THL A29 Limited, a Tencent company. All rights reserved.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://opensource.org/licenses/MIT
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.tencent.bk.sdk.iam.dto.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.CommonActionDTO;
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

    @JsonProperty("common_actions")
    private List<CommonActionDTO> commonActions;

    @JsonProperty("instance_selections")
    private List<SelectionDTO> instanceSelections;

    @JsonProperty("resource_creator_actions")
    private ResourceCreatorActionsDTO resourceCreatorActions;

    @JsonProperty("action_groups")
    private List<ActionGroupDTO> actionGroup;
}
