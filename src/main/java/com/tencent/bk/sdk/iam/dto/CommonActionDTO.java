package com.tencent.bk.sdk.iam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.dto.action.ActionDTO;
import lombok.Data;

import java.util.List;

@Data
public class CommonActionDTO {
    private List<ActionDTO> actions;
    private String name;
    @JsonProperty("name_en")
    private String englishName;
}
