package com.tencent.bk.sdk.iam.dto;

import com.tencent.bk.sdk.iam.dto.action.UrlAction;
import lombok.Data;

import java.util.List;

@Data
public class PermissionUrlDTO {
    private String system_id;

    private List<UrlAction> actions;

    public PermissionUrlDTO(String systemId, List<UrlAction> actions) {
        this.system_id = systemId;
        this.actions = actions;
    }
}
