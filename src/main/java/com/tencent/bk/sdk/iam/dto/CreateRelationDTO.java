package com.tencent.bk.sdk.iam.dto;

import com.tencent.bk.sdk.iam.dto.grant.AncestorsApiReq;
import lombok.Data;

import java.util.List;

@Data
public class CreateRelationDTO {
    private String system;
    private String type;
    private String id;
    private String name;
    private String creator;
    private List<AncestorsApiReq> ancestors;

    public CreateRelationDTO(
        String system,
        String type,
        String id,
        String name,
        String creator,
        List<AncestorsApiReq> ancestors
    ) {
        this.ancestors = ancestors;
        this.creator = creator;
        this.system = system;
        this.type = type;
        this.id = id;
        this.name = name;
    }
}
