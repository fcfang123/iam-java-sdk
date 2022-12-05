package com.tencent.bk.sdk.iam.dto;

import lombok.Data;

@Data
public class RelationResourceInstance {
    private String system_id;
    private String type;
    private String id;
    private String name;

    public RelationResourceInstance(String systemId, String type, String id, String name) {
        this.id = id;
        this.type = type;
        this.system_id = systemId;
        this.name = name;
    }
}
