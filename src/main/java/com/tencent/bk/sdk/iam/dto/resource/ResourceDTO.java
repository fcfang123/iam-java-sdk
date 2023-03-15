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

package com.tencent.bk.sdk.iam.dto.resource;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResourceDTO {

    private String system;

    private String type;

    private String id;

    /**
     * 资源属性
     */
    private Map<String, Object> attribute;

    /**
     * 仅在批量拉取跨系统依赖资源时有效
     */
    @JsonProperty("ids")
    private List<String> idList;
}
