package com.tencent.bk.sdk.iam.dto;

import lombok.Data;

import java.util.List;

@Data
public class RelatedResourceTypesDTO {
    private String type;
    private List<ConditionDTO> condition;
    private String name;
}
