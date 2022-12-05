package com.tencent.bk.sdk.iam.dto;

import lombok.Data;

import java.util.List;

@Data
public class RelatedResourceTypes {
    private String system;
    private String type;
    private List<List<RelationResourceInstance>> instances;
    private List<Attributes> attributes;

    public RelatedResourceTypes(
        String systemId,
        String type,
        List<List<RelationResourceInstance>> instances,
        List<Attributes> attributes
    ) {
        this.system = systemId;
        this.type = type;
        this.instances = instances;
        this.attributes = attributes;
    }
}
