package com.tencent.bk.sdk.iam.dto.grant;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GrantResourceV2DTO {
    private String system;
    /*资源类型ID*/
    private String type;
    /*批量资源拓扑，最多1000个*/
    private List<List<GrantPathV2DTO>> paths;
}
