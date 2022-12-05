package com.tencent.bk.sdk.iam.dto.grant;

import com.tencent.bk.sdk.iam.dto.manager.Action;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ManagerRoleGroupGrantDTO {
    private String system;
    /*操作*/
    private List<Action> actions;
    /*资源拓扑*/
    private List<GrantResourceV2DTO> resources;
}
