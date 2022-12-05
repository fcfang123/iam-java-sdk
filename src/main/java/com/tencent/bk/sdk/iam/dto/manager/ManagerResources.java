package com.tencent.bk.sdk.iam.dto.manager;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ManagerResources {
    /**
     * 系统ID
     */
    String system;
    /**
     * 资源类型
     */
    String type;
    List<List<ManagerPath>> paths;
}
