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

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GrantPathV2DTO {
    /* 拓扑节点类型的系统 ID */
    private String system;
    /* 拓扑节点类型ID */
    private String type;
    /* 拓扑节点实例名称 */
    private String name;
    /* 拓扑节点实例ID */
    private String id;
}
