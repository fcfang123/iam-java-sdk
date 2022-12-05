package com.tencent.bk.sdk.iam.config;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author citruswang
 * @since 19/3/2020 10:38
 */
@Data
@AllArgsConstructor
public class IamConfiguration {

    private String systemId;

    private String appCode;

    private String appSecret;

    private String iamBaseUrl;

    private String apigwBaseUrl;
}
