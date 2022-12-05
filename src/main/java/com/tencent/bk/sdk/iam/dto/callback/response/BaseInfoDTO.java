package com.tencent.bk.sdk.iam.dto.callback.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author citruswang
 * @since 20/3/2020 18:16
 */
@Data
public class BaseInfoDTO {

    private String id;

    @JsonProperty("display_name")
    private String displayName;
}
