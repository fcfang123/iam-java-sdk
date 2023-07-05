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

package com.tencent.bk.sdk.iam.dto.callback.request;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.PathInfoDTO;
import com.tencent.bk.sdk.iam.dto.expression.ExpressionDTO;
import com.tencent.bk.sdk.iam.dto.resource.ResourceTypeChainDTO;

import lombok.Data;

@Data
public class FilterDTO {

    /**
     * list_attr_value
     * <p>
     * 需要查询的资源属性id
     */
    @JsonProperty("attr")
    private String attribute;

    /**
     * list_attr_value
     * <p>
     * 资源属性值的搜索关键字
     */
    private String keyword;

    /**
     * list_attr_value， fetch_instance_info
     * <p>
     * 需要查询的资源实例的唯一标识列表
     */
    @JsonProperty("ids")
    private List<Object> idList;

    /**
     * list_instance
     * <p>
     * 资源的直接上级，具体包含 type 和 id，type 为直接上级资源的类型，id 为直接上级资源实例 ID
     */
    private PathInfoDTO parent;

    /**
     * list_instance
     * <p>
     * 资源实例的搜索关键字
     */
    private Map<String, List<Object>> search;

    /**
     * list_instance
     * <p>
     * 配置search参数一起使用，resource_type_chain指定返回对象返回的祖先层级拓扑
     */
    @JsonProperty("resource_type_chain")
    private ResourceTypeChainDTO resourceTypeChain;

    /**
     * fetch_instance_info
     * <p>
     * 需要查询的资源属性列表，比如["path", "os"]，空列表或无该参数则表示查询所有属性
     */
    @JsonProperty("attrs")
    private List<String> attributeList;

    /**
     * list_instance_by_policy
     * <p>
     * 表达式
     */
    private ExpressionDTO expression;

}
