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

package com.tencent.bk.sdk.iam.dto.manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.manager.AuthorizationScopes;
import com.tencent.bk.sdk.iam.dto.manager.ManagerScopes;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateSubsetManagerDTO {
    /*
     * 二级管理员名称, 分级管理员下唯一
     * */
    private String name;
    /*
     * 二级管理员描述，可为空字符串
     * */
    private String description;
    /*
     * 分级管理员成员列表
     * */
    private List<String> members;
    /*
     * 分级管理员可授权范围
     * */
    @JsonProperty("authorization_scopes")
    private List<AuthorizationScopes> authorizationScopes;
    /*
     * 分级管理员可授权的人员范围
     * 如需设置 全员 授权范围, type = *, id = *
     * */
    @JsonProperty("subject_scopes")
    private List<ManagerScopes> subjectScopes;
    /*
     * 是否继承上级分级管理员的人员授权范围, 默认false
     * */
    @JsonProperty("inherit_subject_scope")
    private Boolean inheritSubjectScope;
    /**
     * 是否创建同步权限用户组, 默认false
     */
    @JsonProperty("sync_perm")
    private Boolean syncPerm;
}
