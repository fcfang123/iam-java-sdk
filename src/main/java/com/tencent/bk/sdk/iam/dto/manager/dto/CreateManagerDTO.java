package com.tencent.bk.sdk.iam.dto.manager.dto;

import com.tencent.bk.sdk.iam.dto.manager.AuthorizationScopes;
import com.tencent.bk.sdk.iam.dto.manager.ManagerScopes;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateManagerDTO {
    /**
     * 调用API的系统id
     */
    String system;
    /**
     * 分级管理员名称
     */
    String name;
    /**
     * 描述
     */
    String description;
    /**
     * 用户ID
     */
    List<String> members;

    List<AuthorizationScopes> authorization_scopes;

    List<ManagerScopes> subject_scopes;

    Boolean sync_perm;
}
