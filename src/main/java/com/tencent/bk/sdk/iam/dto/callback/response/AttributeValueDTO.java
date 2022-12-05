package com.tencent.bk.sdk.iam.dto.callback.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author citruswang
 * @since 20/3/2020 18:10
 */
@Data
public class AttributeValueDTO {

    private Object id;

    private String name;

    @JsonProperty("display_name")
    private String displayName;
}
