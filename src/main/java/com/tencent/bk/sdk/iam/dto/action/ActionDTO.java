package com.tencent.bk.sdk.iam.dto.action;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.bk.sdk.iam.constants.ActionTypeEnum;
import com.tencent.bk.sdk.iam.dto.BaseDTO;
import com.tencent.bk.sdk.iam.dto.resource.RelatedResourceTypeDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author citruswang
 * @since 12/3/2020 22:02
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ActionDTO extends BaseDTO {

    private ActionTypeEnum type;

    @JsonProperty("related_resource_types")
    private List<RelatedResourceTypeDTO> relatedResourceTypes = new ArrayList<>();

    @JsonProperty("related_actions")
    private List<String> relatedAction = new ArrayList<>();

    private Integer version;
}
