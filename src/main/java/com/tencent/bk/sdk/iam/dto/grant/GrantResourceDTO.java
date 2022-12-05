package com.tencent.bk.sdk.iam.dto.grant;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GrantResourceDTO {
    private String system;
    private String type;
    private List<GrantPathDTO> path;
}
