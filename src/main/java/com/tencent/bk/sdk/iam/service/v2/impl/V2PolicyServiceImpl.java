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

package com.tencent.bk.sdk.iam.service.v2.impl;

import com.tencent.bk.sdk.iam.config.IamConfiguration;
import com.tencent.bk.sdk.iam.constants.V2IamUri;
import com.tencent.bk.sdk.iam.service.HttpClientService;
import com.tencent.bk.sdk.iam.service.impl.PolicyServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class V2PolicyServiceImpl extends PolicyServiceImpl {

    private final HttpClientService httpClientService;
    private final IamConfiguration iamConfiguration;

    public V2PolicyServiceImpl(HttpClientService httpClientService, IamConfiguration iamConfiguration) {
        super(iamConfiguration, httpClientService);
        this.httpClientService = httpClientService;
        this.iamConfiguration = iamConfiguration;
    }

    @Override
    public String getPolicyByActionUrl() {
        return String.format(V2IamUri.V2_QUERY_POLICY, iamConfiguration.getSystemId());
    }

    @Override
    public String getBatchGetPolicyByActionListUrl() {
        return String.format(V2IamUri.V2_BATCH_QUERY_POLICY, iamConfiguration.getSystemId());
    }

    @Override
    public String getVerifyPermissionsUrl() {
        return String.format(V2IamUri.V2_AUTH_POLICY, iamConfiguration.getSystemId());
    }

    @Override
    public String getBatchVerifyPermissionsUrl() {
        return String.format(V2IamUri.V2_POLICY_QUERY_BY_ACTIONS, iamConfiguration.getSystemId());
    }
}
