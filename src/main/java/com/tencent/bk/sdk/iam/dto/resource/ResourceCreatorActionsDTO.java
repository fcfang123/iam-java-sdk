package com.tencent.bk.sdk.iam.dto.resource;

import lombok.Data;

import java.util.List;

@Data
public class ResourceCreatorActionsDTO {
    private String mode;
    private List<ResourceCreateConfigDTO> config;
}
