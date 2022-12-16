package com.tencent.bk.sdk.iam.dto;

import lombok.Data;

import java.util.List;

@Data
public class ConditionDTO {
    private String id;
    private List<InstancesDTO> instances;
}
