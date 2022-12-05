package com.tencent.bk.sdk.iam.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.resource.ResourceTypeChainDTO;

import lombok.Data;

/**
 * @author citruswang
 * @since 16/3/2020 16:48
 */
@Data
public class SelectionDTO {

    private String id;

    private String name;

    @JsonProperty("name_en")
    private String englishName;

    @JsonProperty("resource_type_chain")
    private List<ResourceTypeChainDTO> resourceTypeChain;
}
