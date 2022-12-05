package com.tencent.bk.sdk.iam.dto;

import com.tencent.bk.sdk.iam.dto.action.ActionDTO;
import com.tencent.bk.sdk.iam.dto.resource.V2ResourceNode;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class V2QueryPolicyDTO {
    private String system;

    private SubjectDTO subject;

    private ActionDTO action;

    private List<V2ResourceNode> resources;
}
