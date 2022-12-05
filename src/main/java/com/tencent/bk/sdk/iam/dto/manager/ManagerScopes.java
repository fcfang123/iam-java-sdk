package com.tencent.bk.sdk.iam.dto.manager;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ManagerScopes {
    /**
     * 作用范围类型： 1. user 2. department 3. *
     */
    String type;
    /**
     * 成员id
     */
    String id;
    public ManagerScopes() {
    }
    public ManagerScopes(String type, String id) {
        this.type = type;
        this.id = id;
    }
}
