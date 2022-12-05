package com.tencent.bk.sdk.iam.dto.grant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GrantPathV2DTO {
    /* 拓扑节点类型的系统 ID */
    private String system;
    /* 拓扑节点类型ID */
    private String type;
    /* 拓扑节点实例名称 */
    private String name;
    /* 拓扑节点实例ID */
    private String id;
}
