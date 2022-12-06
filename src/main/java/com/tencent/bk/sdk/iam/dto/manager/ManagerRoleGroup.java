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

package com.tencent.bk.sdk.iam.dto.manager;

import lombok.Data;

@Data
public class ManagerRoleGroup {
    /**
     * 用户组名称
     */
    String name;
    /**
     * 描述
     */
    String description;
    /**
     * 用户组类型
     */
    Boolean readonly;

    public ManagerRoleGroup() {}

    public ManagerRoleGroup(String name, String description, Boolean readonly) {
        this.name = name;
        this.description = description;
        this.readonly = readonly;
    }
}
