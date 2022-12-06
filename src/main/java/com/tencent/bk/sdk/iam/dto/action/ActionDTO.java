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

package com.tencent.bk.sdk.iam.dto.action;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.constants.ActionTypeEnum;
import com.tencent.bk.sdk.iam.dto.BaseDTO;
import com.tencent.bk.sdk.iam.dto.resource.RelatedResourceTypeDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ActionDTO extends BaseDTO {

    private ActionTypeEnum type;

    @JsonProperty("related_resource_types")
    private List<RelatedResourceTypeDTO> relatedResourceTypes = new ArrayList<>();

    @JsonProperty("related_actions")
    private List<String> relatedAction = new ArrayList<>();

    private Integer version;
}
