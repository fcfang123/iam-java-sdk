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
import com.tencent.bk.sdk.iam.dto.manager.ManagerRoleGroup;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ManagerRoleGroupDTO {
    List<ManagerRoleGroup> groups;
    /*
     * 不传时默认为true，当迁移时，将该字段设置false，使得用户组可被管理
     * */
    @JsonProperty("create_attributes")
    Boolean createAttributes;
    /*
     * 是否创建用户组的同步人员模版, 默认false
     * */
    @JsonProperty("sync_subject_template")
    Boolean syncSubjectTemplate;
}
