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

package com.tencent.bk.sdk.iam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.constants.AuthTypeEnum;

import lombok.Data;

@Data
public class ProviderConfigDTO {

    /**
     * 权限中心调用查询资源实例接口的 HOST
     * <p>
     * 格式：scheme://netloc，与 resource_type.provider_config.path 配合使用
     */
    private String host;

    /**
     * 权限中心调用查询资源实例接口的配置文件
     * <p>
     * 与 system.provider_config.host 配合使用
     */
    private String path;

    /**
     * 权限中心调用查询资源实例接口的鉴权方式, 当前可选: none/basic
     */
    @JsonProperty("auth")
    private AuthTypeEnum authType;
}
