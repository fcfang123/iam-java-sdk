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

import static com.tencent.bk.sdk.iam.constants.ParentType.CMDB_BUSINESS;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class IamSearchCondition {
    private List<String> idList;

    private List<Long> appIdList;

    private Map<String, List<String>> attribute;

    private Long start;

    private Long length;

    public static IamSearchCondition fromReq(CallbackRequestDTO request) {
        IamSearchCondition condition = new IamSearchCondition();
        if (request.getFilter() != null) {
            FilterDTO filter = request.getFilter();
            if (filter.getParent() != null) {
                if (CMDB_BUSINESS.equals(filter.getParent().getType())) {
                    try {
                        condition.setAppIdList(Collections.singletonList(Long.valueOf(filter.getParent().getId())));
                    } catch (NumberFormatException e) {
                        log.warn("Error while parse app id!|{}", filter.getParent());
                    }
                } else {
                    condition.setAttribute(new ConcurrentHashMap<>(1));
                    condition.getAttribute().put(filter.getParent().getType(),
                            Collections.singletonList(filter.getParent().getId()));
                }
            }
            if (filter.getIdList() != null) {
                condition.setIdList(filter.getIdList().parallelStream().map(String::valueOf).collect(Collectors.toList()));
            }
        }
        if (request.getPage() != null) {
            condition.setStart(request.getPage().getOffset());
            condition.setLength(request.getPage().getLimit());
        } else {
            condition.setStart(0L);
            condition.setLength(10L);
        }
        return condition;
    }
}
