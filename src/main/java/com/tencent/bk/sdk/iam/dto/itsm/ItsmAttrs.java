package com.tencent.bk.sdk.iam.dto.itsm;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ItsmAttrs {
    private List<ItsmColumn> column;
}
