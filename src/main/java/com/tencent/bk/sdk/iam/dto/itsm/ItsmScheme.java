package com.tencent.bk.sdk.iam.dto.itsm;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItsmScheme {
    private ItsmAttrs attrs;
    private String type;
}
