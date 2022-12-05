package com.tencent.bk.sdk.iam.dto.action;

import com.tencent.bk.sdk.iam.dto.RelatedResourceTypes;
import lombok.Data;

import java.util.List;

@Data
public class UrlAction {
    private String id;
    private List<RelatedResourceTypes> related_resource_types;

    public UrlAction(String id, List<RelatedResourceTypes> relatedResourceTypes) {
        this.id = id;
        this.related_resource_types = relatedResourceTypes;
    }
}
