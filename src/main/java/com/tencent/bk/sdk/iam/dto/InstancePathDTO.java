package com.tencent.bk.sdk.iam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InstancePathDTO {
    private String id;
    private String name;
    private String type;
    @JsonProperty("type_name")
    private String typeName;
    @JsonProperty("system_id")
    private String systemId;
}
