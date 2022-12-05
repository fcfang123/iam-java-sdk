package com.tencent.bk.sdk.iam.service.v2.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.sdk.iam.config.IamConfiguration;
import com.tencent.bk.sdk.iam.constants.V2IamUri;
import com.tencent.bk.sdk.iam.dto.V2BelongDTO;
import com.tencent.bk.sdk.iam.dto.V2QueryPolicyDTO;
import com.tencent.bk.sdk.iam.dto.response.ResponseDTO;
import com.tencent.bk.sdk.iam.exception.IamException;
import com.tencent.bk.sdk.iam.service.impl.ApigwHttpClientServiceImpl;
import com.tencent.bk.sdk.iam.service.v2.V2PolicyService;
import com.tencent.bk.sdk.iam.util.JsonUtil;
import com.tencent.bk.sdk.iam.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

@Slf4j
public class V2PolicyServiceImpl implements V2PolicyService {

    private final ApigwHttpClientServiceImpl apigwHttpClientService;
    private final IamConfiguration iamConfiguration;

    public V2PolicyServiceImpl(ApigwHttpClientServiceImpl apigwHttpClientService, IamConfiguration iamConfiguration) {
        this.apigwHttpClientService = apigwHttpClientService;
        this.iamConfiguration = iamConfiguration;
    }

    @Override
    public Boolean verifyPermissions(V2QueryPolicyDTO queryPolicyDTO) {
        try {
            String url = String.format(V2IamUri.V2_AUTH_POLICY, iamConfiguration.getSystemId());
            String responseStr = apigwHttpClientService.doHttpPost(url, queryPolicyDTO);
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

    @Override
    public Map<Integer, Boolean> verifyRoleGruopMember(V2BelongDTO v2BelongDTO) {
        try {
            String url = String.format(
                V2IamUri.V2_MANAGER_ROLE_GROUP_BELONG,
                iamConfiguration.getSystemId(),
                v2BelongDTO.getUserId(),
                v2BelongDTO.getGroupIds(),
                v2BelongDTO.getInherit()
            );
            String responseStr = apigwHttpClientService.doHttpGet(url);
            if (StringUtils.isNotBlank(responseStr)) {
                log.debug("V2 verify gruop member response|{}", responseStr);
                ResponseDTO<Map<Integer, Boolean>> responseInfo = JsonUtil.fromJson(responseStr, new TypeReference<ResponseDTO<Map<Integer, Boolean>>>() {
                });
                if (responseInfo != null) {
                    ResponseUtil.checkResponse(responseInfo);
                    return responseInfo.getData();
                }
            } else {
                log.warn("V2 verify gruop member got empty response!");
            }
        } catch (IamException iamException) {
            log.error("V2 verify Gruop Member  response failed|{}|{}", iamException.getErrorCode(), iamException.getErrorMsg());
            throw iamException;
        } catch (Exception e) {
            log.error("V2 verify gruop member response failed|{}", e);
            throw new RuntimeException(e);
        }
        return null;
    }
}
