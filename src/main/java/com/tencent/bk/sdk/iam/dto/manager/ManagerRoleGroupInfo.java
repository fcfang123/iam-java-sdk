package com.tencent.bk.sdk.iam.dto.manager;

import lombok.Data;

import java.util.Map;

@Data
public class ManagerRoleGroupInfo {
    /**
     * 名称
     */
    String name;
    /**
     * 描述
     */
    String description;
    Integer id;
    Map<String, Object> attributes;

    public ManagerRoleGroupInfo() {}

    public ManagerRoleGroupInfo(String name, String description, Integer id, Map<String, Object> attributes) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.attributes = attributes;
    }

    public ManagerRoleGroupInfo(String name, String description, Integer id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }
}
