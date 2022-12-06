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

import lombok.Data;

@Data
public class ActionTopologyDTO {
    /**
     * 操作id，必须是已注册的Action ID
     */
    private String id;

    /**
     * 新建操作关联的子操作列表,即所有子级资源的新建操作
     * <p>
     * 例如：业务新建这个Action，其下级有集群新建、目录新建 这两个子操作。
     */
    @JsonProperty("sub_actions")
    private List<ActionDTO> subActionList = new ArrayList<>();

    /**
     * 新建类操作执行后产生的资源的关联操作列表，Action ID列表,
     * <p>
     * 例如：业务新建其关联操作有业务编辑、业务查看、业务删除。
     */
    @JsonProperty("related_actions")
    private List<ActionDTO> relatedActionList = new ArrayList<>();
}
