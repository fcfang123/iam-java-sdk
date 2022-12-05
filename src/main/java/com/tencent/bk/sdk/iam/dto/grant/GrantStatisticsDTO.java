package com.tencent.bk.sdk.iam.dto.grant;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GrantStatisticsDTO {
    private int instance_count;
}
