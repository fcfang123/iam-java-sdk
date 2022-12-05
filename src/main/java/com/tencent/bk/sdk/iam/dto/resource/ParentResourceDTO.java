package com.tencent.bk.sdk.iam.dto.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ParentResourceDTO {
    private String id;
    @JsonProperty("system_id")
    private String systemId;
}
