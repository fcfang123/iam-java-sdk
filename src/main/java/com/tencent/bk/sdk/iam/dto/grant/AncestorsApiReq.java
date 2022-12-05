package com.tencent.bk.sdk.iam.dto.grant;

import lombok.Data;

@Data
public class AncestorsApiReq {
    private String system;
    private String type;
    private String id;

    public AncestorsApiReq(String system, String type, String id) {
        this.system = system;
        this.type = type;
        this.id = id;
    }
}
