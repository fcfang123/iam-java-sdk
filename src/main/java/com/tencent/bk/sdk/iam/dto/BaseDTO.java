package com.tencent.bk.sdk.iam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

/**
 * @author citruswang
 * @since 12/3/2020 21:58
 */
@Data
public class BaseDTO {

    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 英文名
     */
    @JsonProperty("name_en")
    private String englishName;

    /**
     * 描述
     */
    private String description;

    /**
     * 描述英文
     */
    @JsonProperty("description_en")
    private String englishDescription;

    /**
     * 权限中心回调接入系统的配置文件
     */
    @JsonProperty("provider_config")
    private ProviderConfigDTO providerConfig;
}
