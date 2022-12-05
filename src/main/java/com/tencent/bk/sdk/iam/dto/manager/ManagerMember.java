package com.tencent.bk.sdk.iam.dto.manager;

import lombok.Data;

@Data
public class ManagerMember {
    /**
     * 成员类型
     */
    String type;
    /**
     * 成员id
     */
    String id;

    public ManagerMember(String type, String id) {
        this.type = type;
        this.id = id;
    }

}
