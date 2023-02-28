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

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class InstanceDTO {

    /**
     * 资源 ID，必填
     */
    private String id;

    /**
     * 资源所属系统，必填
     */
    private String system;

    /**
     * 资源类型，必填
     */
    private String type;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源路径，不包含本身，选填
     */
    private PathInfoDTO path;

    /**
     * 资源路径，不包含本身，选填
     *
     * path 用于资源只有一个父类,
     * paths 用于资源有多个父类
     */
    private List<PathInfoDTO> paths;

    /**
     * 资源属性，选填
     */
    private Map<String, Object> attribute;
}
