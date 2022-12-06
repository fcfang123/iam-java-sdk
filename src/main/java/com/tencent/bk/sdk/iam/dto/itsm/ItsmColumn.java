package com.tencent.bk.sdk.iam.dto.itsm;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItsmColumn {
    private String key;
    private String name;
    private String type;
    private Integer width;
}
