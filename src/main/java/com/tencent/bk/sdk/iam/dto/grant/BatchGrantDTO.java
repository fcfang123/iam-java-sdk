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

import com.tencent.bk.sdk.iam.constants.GrantType;
import com.tencent.bk.sdk.iam.dto.SubjectDTO;
import com.tencent.bk.sdk.iam.service.impl.GrantActionDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class BatchGrantDTO extends GrantBaseDTO{
    private List<GrantActionDTO> actions;

    @Builder
    public BatchGrantDTO(
        Boolean asynchronous,
        GrantType operate,
        String system,
        SubjectDTO subject,
        List<GrantResourceDTO> resources,
        Long expiredAt,
        List<GrantActionDTO> actions
    ) {
        super(asynchronous, operate.getType(), system, resources, subject, expiredAt);
        this.actions = actions;
    }
}
