package com.tencent.bk.sdk.iam.service;

/**
 * @author citruswang
 * @since 29/5/2020 12:42
 */
public interface TokenService {
    /**
     * 获取 CMDB 鉴权 Token
     *
     * @return 鉴权 Token
     */
    String getToken();
}
