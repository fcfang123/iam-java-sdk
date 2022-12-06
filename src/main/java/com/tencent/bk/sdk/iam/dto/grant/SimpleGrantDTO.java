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

package com.tencent.bk.sdk.iam.dto.grant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.constants.GrantType;
import com.tencent.bk.sdk.iam.dto.SubjectDTO;
import com.tencent.bk.sdk.iam.service.impl.GrantActionDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder
public class SimpleGrantDTO {
    private GrantActionDTO action;
    /* 授权方式 默认为false同步 当前只支持同步 */
    private Boolean asynchronous;
    /* grant 授权 revoke 回收*/
    private String operate;
    private String system;
    /* 资源拓扑, 资源类型的顺序必须操作注册时的顺序一致 */
    private List<GrantResourceDTO> resources;
    private SubjectDTO subject;
    /* 有效期，时间戳，即到了对应时间戳时间后权限就过期 */
    @JsonProperty("expired_at")
    private Long expiredAt;
//
//    @Builder
//    public SimpleGrantDTO(
//        Boolean asynchronous,
//        GrantType operate,
//        String system,
//        GrantActionDTO action,
//        SubjectDTO subject,
//        List<GrantResourceDTO> resources,
//        Long expiredAt
//    ) {
//        super(asynchronous, operate, system, resources, subject, expiredAt);
//        this.action = action;
//    }
}
