package com.tencent.bk.sdk.iam.dto.manager;

import lombok.Data;

@Data
public class ManagerPath {
    /**
     * 系统ID
     */
    String system;
    /**
     * 资源类型
     */
    String type;
    /**
     * 资源实例ID
     */
    String id;
    /**
     * 资源实例ID名称
     */
    String name;

    public ManagerPath(String system, String type, String id, String name) {
        this.system = system;
        this.type = type;
        this.id = id;
        this.name = name;
    }
}
