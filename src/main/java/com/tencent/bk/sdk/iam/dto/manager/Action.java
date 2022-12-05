package com.tencent.bk.sdk.iam.dto.manager;

import lombok.Data;

@Data
public class Action {
    String id;

    public Action(String id) {
        this.id = id;
    }
}
