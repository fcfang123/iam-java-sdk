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

package com.tencent.bk.sdk.iam.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CallbackMethodEnum {
    /**
     *
     */
    LIST_ATTRIBUTE("list_attr"),
    /**
     *
     */
    LIST_ATTRIBUTE_VALUE("list_attr_value"),
    /**
     *
     */
    LIST_INSTANCE("list_instance"),
    /**
     *
     */
    FETCH_INSTANCE_INFO("fetch_instance_info"),
    /**
     *
     */
    LIST_INSTANCE_BY_POLICY("list_instance_by_policy"),
    /**
     *
     */
    SEARCH_INSTANCE("search_instance")
    ;

    @JsonValue
    private String method;

    @JsonCreator
    private CallbackMethodEnum parseMethod(String method) {
        if (StringUtils.isBlank(method)) {
            return null;
        }
        for (CallbackMethodEnum callbackMethod : values()) {
            if (callbackMethod.getMethod().equals(method)) {
                return callbackMethod;
            }
        }
        return null;
    }
}
