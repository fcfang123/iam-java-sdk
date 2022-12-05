package com.tencent.bk.sdk.iam.dto.manager;

import lombok.Data;

@Data
public class ManagerRoleGroup {
    /**
     * 用户组名称
     */
    String name;
    /**
     * 描述
     */
    String description;
    /**
     * 用户组类型
     */
    Boolean readonly;

    public ManagerRoleGroup() {}

    public ManagerRoleGroup(String name, String description, Boolean readonly) {
        this.name = name;
        this.description = description;
        this.readonly = readonly;
    }
}
