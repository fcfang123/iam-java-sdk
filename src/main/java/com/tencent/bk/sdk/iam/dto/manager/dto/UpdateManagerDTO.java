package com.tencent.bk.sdk.iam.dto.manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.manager.AuthorizationScopes;
import com.tencent.bk.sdk.iam.dto.manager.ManagerScopes;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateManagerDTO {
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

    @JsonProperty("authorization_scopes")
    List<AuthorizationScopes> authorizationScopes;

    @JsonProperty("subject_scopes")
    List<ManagerScopes> subjectScopes;

    @JsonProperty("sync_perm")
    Boolean syncPerm;
}
