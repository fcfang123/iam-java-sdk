package com.tencent.bk.sdk.iam.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tencent.bk.sdk.iam.config.IamConfiguration;
import com.tencent.bk.sdk.iam.constants.IamUri;
import com.tencent.bk.sdk.iam.dto.response.ResponseDTO;
import com.tencent.bk.sdk.iam.dto.system.TokenDTO;
import com.tencent.bk.sdk.iam.service.HttpClientService;
import com.tencent.bk.sdk.iam.service.TokenService;
import com.tencent.bk.sdk.iam.util.JsonUtil;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author citruswang
 * @since 29/5/2020 12:43
 */
@Slf4j
public class TokenServiceImpl implements TokenService {

    private final IamConfiguration iamConfiguration;
    private final HttpClientService httpClientService;

    private String token = null;

    public TokenServiceImpl(IamConfiguration iamConfiguration, HttpClientService httpClientService) {
        this.iamConfiguration = iamConfiguration;
        this.httpClientService = httpClientService;
    }

    private void initToken() {
        try {
            String getTokenResponse = httpClientService.doHttpGet(String.format(IamUri.GET_SYSTEM_TOKEN, iamConfiguration.getSystemId()));
            if (StringUtils.isNotBlank(getTokenResponse)) {
                log.debug("Get token response|{}", getTokenResponse);
                ResponseDTO<TokenDTO> tokenResponse = JsonUtil.fromJson(getTokenResponse, new TypeReference<ResponseDTO<TokenDTO>>() {
                });
                if (tokenResponse != null) {
                    log.debug("Get token from iam|{}|{}|{}", tokenResponse.getCode(), tokenResponse.getMessage(),
                            tokenResponse.getData().getToken());
                    if (tokenResponse.getCode() == 0) {
                        token = tokenResponse.getData().getToken();
                    }
                }
            }
            if (token == null) {
                throw new RuntimeException("Get token failed!");
            }
        } catch (Exception e) {
            log.error("Get iam system token failed!", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getToken() {
        if (token == null) {
            initToken();
        }
        return token;
    }
}
