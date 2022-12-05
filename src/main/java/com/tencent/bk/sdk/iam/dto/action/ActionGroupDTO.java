package com.tencent.bk.sdk.iam.dto.action;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ActionGroupDTO {
    private String name;
    @JsonProperty("name_en")
    private String englishName;

    private List<GroupAction> actions;
}
