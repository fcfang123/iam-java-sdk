package com.tencent.bk.sdk.iam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.constants.AuthTypeEnum;

import lombok.Data;

/**
 * @author citruswang
 * @since 12/3/2020 21:51
 */
@Data
public class ProviderConfigDTO {

    /**
     * 权限中心调用查询资源实例接口的 HOST
     * <p>
     * 格式：scheme://netloc，与 resource_type.provider_config.path 配合使用
     */
    private String host;

    /**
     * 权限中心调用查询资源实例接口的配置文件
     * <p>
     * 与 system.provider_config.host 配合使用
     */
    private String path;

    /**
     * 权限中心调用查询资源实例接口的鉴权方式, 当前可选: none/basic
     */
    @JsonProperty("auth")
    private AuthTypeEnum authType;
}
