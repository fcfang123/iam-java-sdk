package com.tencent.bk.sdk.iam.dto.manager;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AuthorizationScopes {
    /**
     * 系统ID
     */
    String system;

    List<Action> actions;

    List<ManagerResources> resources;
}
