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
public enum ActionTypeEnum {
    /**
     * 创建
     */
    CREATE("create"),

    /**
     * 删除
     */
    DELETE("delete"),

    /**
     * 查看
     */
    VIEW("view"),

    /**
     * 编辑
     */
    EDIT("edit"),

    /**
     * 列表
     */
    LIST("list"),
    /**
     * 使用
     */
    USE("use"),
    /**
     * 管理
     */
    MANAGE("manage"),
    /**
     * 未分类
     */
    UNDEFINED("")
    ;

    @JsonValue
    private String type;

    @JsonCreator
    public static ActionTypeEnum parseType(String type) {
        if (StringUtils.isBlank(type)) {
            return null;
        }
        for (ActionTypeEnum typeEnum : values()) {
            if (typeEnum.getType().equals(type)) {
                return typeEnum;
            }
        }
        return null;
    }

}
