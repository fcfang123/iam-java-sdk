package com.tencent.bk.sdk.iam.dto;

import lombok.Data;

import java.util.List;

@Data
public class InstancesDTO {
    private String type;
    private String name;
    private List<List<InstancePathDTO>> path;
}
