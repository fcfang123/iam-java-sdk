package com.tencent.bk.sdk.iam.dto.action;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.resource.RelatedResourceTypeDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActionUpdateDTO {
    /**
     * 名称
     */
    private String name;

    /**
     * 英文名
     */
    @JsonProperty("name_en")
    private String englishName;

    /**
     * 描述
     */
    private String description;

    /**
     * 描述英文
     */
    @JsonProperty("description_en")
    private String englishDescription;

    @JsonProperty("related_resource_types")
    private List<RelatedResourceTypeDTO> relatedResourceTypes = new ArrayList<>();

    @JsonProperty("related_actions")
    private List<String> relatedAction = new ArrayList<>();

    private Integer version;
}
