package com.tencent.bk.sdk.iam.dto.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RoleGroupMemberInfo {
    /**
     * 成员类型
     */
    String type;
    /**
     * 成员id
     */
    String id;
    /**
     * 名称
     */
    String name;
    /**
     * 过期时间
     */
    @JsonProperty("expired_at")
    Long expiredAt;

    public RoleGroupMemberInfo() {}

    public RoleGroupMemberInfo(String type, String id, String name, Long expiredAt) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.expiredAt = expiredAt;
    }
}
