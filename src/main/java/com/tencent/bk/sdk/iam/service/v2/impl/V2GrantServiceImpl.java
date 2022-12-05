package com.tencent.bk.sdk.iam.service.v2.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.sdk.iam.config.IamConfiguration;
import com.tencent.bk.sdk.iam.constants.V2IamUri;
import com.tencent.bk.sdk.iam.dto.grant.ManagerRoleGroupGrantDTO;
import com.tencent.bk.sdk.iam.dto.response.ResponseDTO;
import com.tencent.bk.sdk.iam.exception.IamException;
import com.tencent.bk.sdk.iam.service.impl.ApigwHttpClientServiceImpl;
import com.tencent.bk.sdk.iam.service.v2.V2GrantService;
import com.tencent.bk.sdk.iam.util.JsonUtil;
import com.tencent.bk.sdk.iam.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class V2GrantServiceImpl implements V2GrantService {
    private final ApigwHttpClientServiceImpl apigwHttpClientService;
    private final IamConfiguration iamConfiguration;

    public V2GrantServiceImpl(ApigwHttpClientServiceImpl apigwHttpClientService, IamConfiguration iamConfiguration) {
        this.apigwHttpClientService = apigwHttpClientService;
        this.iamConfiguration = iamConfiguration;
    }

    @Override
    public void v2GrantRoleGroup(Integer groupId, ManagerRoleGroupGrantDTO managerRoleGroupGrantDTO) {
        String url = String.format(V2IamUri.V2_MANAGER_ROLE_GROUP_GRANT, iamConfiguration.getSystemId(), groupId);
        try {
            String responseStr = apigwHttpClientService.doHttpPost(url, managerRoleGroupGrantDTO);
            if (StringUtils.isNotBlank(responseStr)) {
                log.debug("grant V2 role group response|{}", responseStr);
                ResponseDTO<Object> responseInfo = JsonUtil.fromJson(responseStr, new TypeReference<ResponseDTO<Object>>() {
                });
                if (responseInfo != null) {
                    ResponseUtil.checkResponse(responseInfo);
                }
            } else {
                log.warn("grant V2 role group got empty response!");
            }
        } catch (IamException iamException) {
            log.error("grant V2 role group failed|{}|{}", iamException.getErrorCode(), iamException.getErrorMsg());
            throw iamException;
        } catch (Exception e) {
            log.error("grant V2 role group failed|{}", e);
            throw new RuntimeException(e);
        }
    }
}
