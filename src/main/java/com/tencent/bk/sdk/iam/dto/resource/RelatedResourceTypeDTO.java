package com.tencent.bk.sdk.iam.dto.resource;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.InstanceDTO;
import com.tencent.bk.sdk.iam.dto.SelectionDTO;
import com.tencent.bk.sdk.iam.dto.callback.response.AttributeDTO;
import com.tencent.bk.sdk.iam.dto.expression.ExpressionDTO;

import lombok.Data;

/**
 * @author citruswang
 * @since 16/3/2020 15:46
 */
@Data
public class RelatedResourceTypeDTO {

    private String id;

    @JsonProperty("system_id")
    private String systemId;

    private String type;

    @JsonProperty("name_alias")
    private String nameAlias;

    @JsonProperty("name_alias_en")
    private String englishNameAlias;

    private ExpressionDTO scope;

    @JsonProperty("instance_selections")
    private List<SelectionDTO> instanceSelection;

    @JsonProperty("related_instance_selections")
    private List<ResourceTypeChainDTO> relatedInstanceSelections;

    @JsonProperty("instances")
    private List<List<InstanceDTO>> instance;

    @JsonProperty("attributes")
    private List<AttributeDTO> attribute;

}
