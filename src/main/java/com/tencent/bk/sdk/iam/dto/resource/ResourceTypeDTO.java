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

package com.tencent.bk.sdk.iam.dto.resource;

import com.tencent.bk.sdk.iam.dto.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ResourceTypeDTO extends BaseDTO {

    /**
     * 资源类型的直接上级，可多个直接上级，可以是自身系统的资源类型或其他系统的资源类型, 可为空列表，不允许重复，数据仅用于权限中心产品上显示 产品说明: 上级资源
     */
    private List<ParentResourceDTO> parents;
}
