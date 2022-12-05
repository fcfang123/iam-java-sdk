package com.tencent.bk.sdk.iam.dto.resource;

import lombok.Data;

import java.util.List;

@Data
public class ResourceCreateConfigAction {
    private List<ResourceActionDTO> actions;

    private String id;
}
