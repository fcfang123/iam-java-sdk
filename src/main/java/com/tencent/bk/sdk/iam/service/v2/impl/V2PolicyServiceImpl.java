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

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.sdk.iam.config.IamConfiguration;
import com.tencent.bk.sdk.iam.constants.V2IamUri;
import com.tencent.bk.sdk.iam.dto.SubjectDTO;
import com.tencent.bk.sdk.iam.dto.V2QueryPolicyDTO;
import com.tencent.bk.sdk.iam.dto.action.ActionDTO;
import com.tencent.bk.sdk.iam.dto.expression.ExpressionDTO;
import com.tencent.bk.sdk.iam.dto.request.QueryPolicyRequestDTO;
import com.tencent.bk.sdk.iam.dto.resource.ResourceDTO;
import com.tencent.bk.sdk.iam.dto.response.ResponseDTO;
import com.tencent.bk.sdk.iam.exception.IamException;
import com.tencent.bk.sdk.iam.service.HttpClientService;
import com.tencent.bk.sdk.iam.service.impl.PolicyServiceImpl;
import com.tencent.bk.sdk.iam.util.JsonUtil;
import com.tencent.bk.sdk.iam.util.ResponseUtil;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

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
    public ExpressionDTO getPolicyByAction(String username, ActionDTO action, List<ResourceDTO> resourceList) {
        if (resourceList == null) {
            resourceList = Collections.emptyList();
        }
        QueryPolicyRequestDTO queryPolicyRequest =
                QueryPolicyRequestDTO.builder().subject(SubjectDTO.builder().id(username).type("user").build())
                        .action(action).resourceList(resourceList).system(iamConfiguration.getSystemId()).build();
        if (log.isDebugEnabled()) {
            log.debug("Get policy by action request|{}|{}|{}|{}", username, action, resourceList, queryPolicyRequest);
        }
        String url = String.format(V2IamUri.V2_QUERY_POLICY, iamConfiguration.getSystemId());
        String policyResponse = httpClientService.doHttpPost(url, queryPolicyRequest);
        if (StringUtils.isNotBlank(policyResponse)) {
            if (log.isDebugEnabled()) {
                log.debug("Get policy by action response|{}", policyResponse);
            }
            ResponseDTO<ExpressionDTO> responseInfo;
            try {
                responseInfo = JsonUtil.fromJson(policyResponse,
                        new TypeReference<ResponseDTO<ExpressionDTO>>() {
                        });
            } catch (IOException e) {
                log.error("Error while parse policy response!|{}|{}|{}|{}", username, action, resourceList,
                        policyResponse, e);
                return null;
            }
            if (responseInfo != null) {
                ResponseUtil.checkResponse(responseInfo);
                return responseInfo.getData();
            }
        } else {
            log.warn("Get policy by action got empty response!");
        }
        return null;
    }

    @Override
    public Boolean verifyPermissions(V2QueryPolicyDTO queryPolicyDTO) {
        try {
            String url = String.format(V2IamUri.V2_AUTH_POLICY, iamConfiguration.getSystemId());
            String responseStr = httpClientService.doHttpPost(url, queryPolicyDTO);
            if (StringUtils.isNotBlank(responseStr)) {
                log.debug("V2 verify permissions response|{}", responseStr);
                ResponseDTO<Map<String, Boolean>> responseInfo = JsonUtil.fromJson(responseStr, new TypeReference<ResponseDTO<Map<String, Boolean>>>() {
                });
                if (responseInfo != null) {
                    ResponseUtil.checkResponse(responseInfo);
                    return responseInfo.getData().get("allowed");
                }
            } else {
                log.warn("V2 verify permissions got empty response!");
            }
        } catch (IamException iamException) {
            log.error("V2 verify permissions response failed|{}|{}", iamException.getErrorCode(), iamException.getErrorMsg());
            throw iamException;
        } catch (Exception e) {
            log.error("V2 verify permissions response failed|{}", e);
            throw new RuntimeException(e);
        }
        return null;
    }
}
