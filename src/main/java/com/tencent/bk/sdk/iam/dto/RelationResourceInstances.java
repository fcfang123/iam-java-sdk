package com.tencent.bk.sdk.iam.dto;

import lombok.Data;

import java.util.List;

@Data
public class RelationResourceInstances {
    private List<RelationResourceInstance> instances;

    public RelationResourceInstances(List<RelationResourceInstance> instances) {
        this.instances = instances;
    }
}
