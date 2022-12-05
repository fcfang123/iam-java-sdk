package com.tencent.bk.sdk.iam.dto.resource;

import com.tencent.bk.sdk.iam.dto.AttributesValue;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class V2ResourceNode {
    private String system;

    private String type;

    private String id;

    private List<AttributesValue> attribute;
}
