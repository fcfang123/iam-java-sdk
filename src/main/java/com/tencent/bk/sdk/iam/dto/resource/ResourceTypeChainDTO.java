package com.tencent.bk.sdk.iam.dto.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author citruswang
 * @since 16/3/2020 17:03
 */
@Data
public class ResourceTypeChainDTO {
    private String id;

    @JsonProperty("system_id")
    private String systemId;
}
